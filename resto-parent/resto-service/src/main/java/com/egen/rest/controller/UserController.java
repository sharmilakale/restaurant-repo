package com.egen.rest.controller;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.egen.rest.dao.UserDao;
import com.egen.rest.domain.User;
import com.egen.rest.exception.AppException;

@Path("/users")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() {
		List<User> users = null;
		try {
			UserDao dao = new UserDao();
			users = dao.getAll();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return users;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findOne(@PathParam ("id") int id) {
		User user = null;
		try {
			UserDao dao = new UserDao();
			user = dao.get(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return user;
	}
	
	@GET
	@Path("/email/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByEmail(@PathParam ("email") String email) {
		User user = null;
		try {
			UserDao dao = new UserDao();
			user = dao.get(email);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return user;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User create (User user) {
		
		try {
			UserDao dao = new UserDao();
			user = dao.create(user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return user;
	}
	
	// PUT /api/Users/1020 
		
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User update (@PathParam("id") int id, User user) {
		
		try {
			UserDao dao = new UserDao();
			user = dao.update(id, user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return user;
	}

	
	
	// DELETE /api/User/1002
	@DELETE
	@Path("/{id}")
	public Response delete (@PathParam("id") int id) {

		try {
			UserDao dao = new UserDao();
			dao.delete(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return Response.ok().build();
	}
}


