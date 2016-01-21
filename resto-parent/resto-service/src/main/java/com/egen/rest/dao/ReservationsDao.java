
package com.egen.rest.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.ProfileAndSettings;
import com.egen.rest.domain.Reservation;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;

@Component
@Qualifier("reservationsDao")
public class ReservationsDao {

	public List<Reservation> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from Reservation");
			List<Reservation> reservationList = query.list();
			return reservationList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	/*
	 * Scan reservations table and see if table with capacity is already
	 * reserved for given date and time. If yes, remove those tables from input
	 * table list else return that table number
	 */
	public List<Integer> findAvailableTables(List<Integer> tableList, Date reserveDate, String reserveTime)
			throws AppException {
		List<Integer> availableTables = new ArrayList<Integer>();
		if (tableList != null && tableList.size() > 0) {
			try {
				Session session = DBUtil.getSession();
				StringBuilder sqlStringSB = new StringBuilder();
				sqlStringSB.append("select tableNo from db_restaurant.reservations");
				sqlStringSB.append(
						"\n where  reserveDate = :reserveDate and reserveTime = :reserveTime and tableNo in (:tableList) ");
				String sqlString = sqlStringSB.toString();

				SQLQuery query = session.createSQLQuery(sqlString);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				query.setParameter("reserveDate", formatter.format(reserveDate).toString());
				query.setParameter("reserveTime", reserveTime);
				query.setParameterList("tableList", tableList);

				List<Integer> result = query.list();
				availableTables = tableList;
				if (result != null && result.size() > 0) {
					for (Integer tableId : result) {
						availableTables.remove(tableId);
					}
				}
				Collections.sort(availableTables);
				return availableTables;
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
		}
		return availableTables;
	}

	public List<Reservation> findTableReservationDetails() throws AppException {
		try {
			Session session = DBUtil.getSession();
			StringBuilder sqlStringSB = new StringBuilder();
			sqlStringSB.append(
					"select t1.table_id, t1.capacity,t2.id,t2.status,t2.reserveDate,t2.reserveTime,t2.noOfPeople");
			sqlStringSB.append("\n from db_restaurant.table_details t1");
			sqlStringSB.append(
					"\n left outer join db_restaurant.reservations t2 on t1.table_id=t2.tableNo order by t1.table_id");

			String sqlString = sqlStringSB.toString();

			SQLQuery query = session.createSQLQuery(sqlString);
			List<Object[]> result = query.list();
			List<Reservation> reservationList = new ArrayList<Reservation>();
			if (result != null && result.size() > 0) {
				for (Object[] currentObject : result) {
					Reservation r1 = new Reservation();
					r1.setTableNo((Integer) currentObject[0]);
					r1.setTableCapacity((Integer) currentObject[1]);
					r1.setId((Integer) currentObject[2]);
					r1.setStatus((String) currentObject[3]);
					r1.setReserveDate((Date) currentObject[4]);
					r1.setReserveTime((String) currentObject[5]);
					r1.setNoOfPeople((Integer) currentObject[6]);
					reservationList.add(r1);
				}
			}
			return reservationList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

	public List<Reservation> getCustomerReservationDetails() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from Reservation order by customerPhone");
			List<Reservation> reservationList = query.list();
			return reservationList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public Reservation create(Reservation reservation) throws AppException {
		if (isValidData(reservation)) {
			try {
				Session session = DBUtil.getSession();
				ProfileAndSettingsDao profileAndSettingsDao = new ProfileAndSettingsDao();
				TableDetailsDao tableDetailsDao = new TableDetailsDao();
				ProfileAndSettings profile = profileAndSettingsDao.get(1);
				if (profile != null && profile.isAutoAssign()) {
					List<Integer> tableList = tableDetailsDao.getTableIdsByCapacity(reservation.getNoOfPeople());
					List<Integer> availableTables = findAvailableTables(tableList, reservation.getReserveDate(),
							reservation.getReserveTime());
					if (availableTables.size() > 0) {
						reservation.setTableNo(availableTables.get(0));
						reservation.setStatus("Reserved");
					} else {
						// Table not available
						reservation.setStatus("Pending");
					}
				} else {
					reservation.setStatus("Pending");
				}
				
				session.beginTransaction();
				session.save(reservation);
				session.getTransaction().commit();
				return reservation;
			
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
		} else {
			throw new AppException("Invalid reservation data");
		}

	}

	public Reservation get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM Reservation where id=:restId");
			query.setParameter("restId", id);
			return (Reservation) query.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

	public boolean delete(Integer id) throws AppException {
		boolean flagDeleted = false;
		try {
			Session session = DBUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("delete Reservation where id=:restId");
			query.setParameter("restId", id);
			query.executeUpdate();
			session.getTransaction().commit();
			flagDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return flagDeleted;
	}

	private boolean isValidData(Reservation reservation) {

		if (reservation.getReserveDate() == null || reservation.getReserveDate().toString().trim().length() <= 0) {
			return false;
		}
		if (reservation.getNoOfPeople() == null || reservation.getNoOfPeople() <= 0) {
			return false;
		}
		if (reservation.getCustomerName() == null || reservation.getCustomerName().trim().length() == 0) {
			return false;
		}
		if (reservation.getCustomerPhone() == null || reservation.getCustomerPhone().trim().length() <= 0) {
			return false;
		}
		return true;
	}

	public Reservation update(int id, Reservation reservation) throws AppException {
		Reservation persistedReservation = get(id);

		if (isValidData(reservation)) {
			if (persistedReservation != null) {
				try {
					Session session = DBUtil.getSession();
					session.beginTransaction();

					persistedReservation.setReserveDate(reservation.getReserveDate());
					persistedReservation.setReserveTime(reservation.getReserveTime());
					persistedReservation.setNoOfPeople(reservation.getNoOfPeople());
					persistedReservation.setStatus(reservation.getStatus());
					persistedReservation.setTableNo(reservation.getTableNo());
					persistedReservation.setCustomerName(reservation.getCustomerName());
					persistedReservation.setCustomerEmail(reservation.getCustomerEmail());
					persistedReservation.setCustomerPhone(reservation.getCustomerPhone());
					session.save(persistedReservation);
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					throw new AppException(e.getMessage());
				}

			}
		} else {
			throw new AppException("Data is invalid");
		}

		return persistedReservation;
	}

}
