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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.egen.rest.dao.ReservationsDao;
import com.egen.rest.domain.Reservation;
import com.egen.rest.exception.AppException;

@Path("/reservations")
public class ReservationsController {
	private static Log log = LogFactory.getLog(ReservationsController.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> findAll() {

		List<Reservation> r1 = null;
		try {
			ReservationsDao dao = new ReservationsDao();
			r1 = dao.getAll();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return r1;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation findOne(@PathParam("id") int id) {
		Reservation r1 = null;
		try {
			ReservationsDao dao = new ReservationsDao();
			r1 = dao.get(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return r1;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation create(Reservation r1) {

		try {
			ReservationsDao dao = new ReservationsDao();
			r1 = dao.create(r1);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return r1;
	}

	// PUT /api/reservations/1020
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation update(@PathParam("id") int id, Reservation r1) {

		try {
			ReservationsDao dao = new ReservationsDao();
			r1 = dao.update(id, r1);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return r1;
	}

	// DELETE /api/reservations/1002
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {

		try {
			ReservationsDao dao = new ReservationsDao();
			dao.delete(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return Response.ok().build();
	}
}
