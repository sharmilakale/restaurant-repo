
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

import com.egen.rest.dao.ProfileAndSettingsDao;
import com.egen.rest.domain.ProfileAndSettings;
import com.egen.rest.exception.AppException;

@Path("/profiles")
public class ProfileAndSettingsController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProfileAndSettings> findAll() {
		List<ProfileAndSettings> profiles = null;
		try {
			ProfileAndSettingsDao dao = new ProfileAndSettingsDao();
			profiles = dao.getAll();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return profiles;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileAndSettings get(@PathParam("id") int id) {
		ProfileAndSettings profile = null;
		try {
			ProfileAndSettingsDao dao = new ProfileAndSettingsDao();
			profile = dao.get(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return profile;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileAndSettings create(ProfileAndSettings profile) {

		try {
			ProfileAndSettingsDao dao = new ProfileAndSettingsDao();
			profile = dao.create(profile);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return profile;
	}

	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileAndSettings update(@PathParam("id") int id, ProfileAndSettings profile) {
		System.out.println("in update method");
		System.out.println("profile data: "+profile.toString());
		try {
			ProfileAndSettingsDao dao = new ProfileAndSettingsDao();
			profile = dao.update(id, profile);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return profile;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {

		try {
			ProfileAndSettingsDao dao = new ProfileAndSettingsDao();
			dao.delete(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return Response.ok().build();
	}
}
