package com.egen.rest.controller;

	import java.util.ArrayList;
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

	@Path("/tableReservation")
	public class TableReservationController {
		@GET
		@Produces(MediaType.APPLICATION_JSON)	
		public List<Reservation> findTableReservationDetails() {

			List<Reservation> r1 = new ArrayList<Reservation>();
			try {
				ReservationsDao dao = new ReservationsDao();
				r1 = dao.findTableReservationDetails();
			} catch (AppException e) {
				e.printStackTrace();
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}
			
			return r1;
		}

		
	}

