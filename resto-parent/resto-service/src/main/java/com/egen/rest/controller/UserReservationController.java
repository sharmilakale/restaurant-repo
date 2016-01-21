package com.egen.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.egen.rest.dao.ReservationsDao;
import com.egen.rest.domain.Reservation;
import com.egen.rest.exception.AppException;

@Path("/userReservation")
public class UserReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getCustomerReservationDetailsList() {
		List<Reservation> r1 = new ArrayList<Reservation>();
		try {
			ReservationsDao dao = new ReservationsDao();
			r1 = dao.getCustomerReservationDetails();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return r1;
	}
}
