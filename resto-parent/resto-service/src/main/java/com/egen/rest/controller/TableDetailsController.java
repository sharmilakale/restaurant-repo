
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

import com.egen.rest.dao.TableDetailsDao;
import com.egen.rest.dao.UserDao;
import com.egen.rest.domain.TableDetails;
import com.egen.rest.domain.User;
import com.egen.rest.exception.AppException;

@Path("/tables")
public class TableDetailsController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TableDetails> findAll() {
		List<TableDetails> tables = null;
		try {
			TableDetailsDao dao = new TableDetailsDao();
			tables = dao.getAll();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return tables;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TableDetails findOne(@PathParam("id") int id) {
		TableDetails tableDetails = null;
		try {
			TableDetailsDao dao = new TableDetailsDao();
			tableDetails = dao.get(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return tableDetails;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TableDetails create(TableDetails tableDetails) {

		try {
			TableDetailsDao dao = new TableDetailsDao();
			tableDetails = dao.create(tableDetails);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return tableDetails;
	}

	// PUT /api/tables/1

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TableDetails update(@PathParam("id") int id, TableDetails tableDetails) {

		try {
			TableDetailsDao dao = new TableDetailsDao();
			tableDetails = dao.update(id, tableDetails);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return tableDetails;
	}

	// DELETE /api/tables/2
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {

		try {
			TableDetailsDao dao = new TableDetailsDao();
			dao.delete(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return Response.ok().build();
	}
}
