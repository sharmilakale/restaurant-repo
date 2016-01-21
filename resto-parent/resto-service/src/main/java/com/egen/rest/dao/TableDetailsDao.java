

package com.egen.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.TableDetails;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;

@Component
@Qualifier("tableDetailsDao")
public class TableDetailsDao {
	public List<TableDetails> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from TableDetails");
			List<TableDetails> tableList = query.list();
			return tableList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public TableDetails create(TableDetails tableDetails) throws AppException {
		if(isValidData(tableDetails)){
			try {
				Session session = DBUtil.getSession();
				session.beginTransaction();
				session.save(tableDetails);
				session.getTransaction().commit();

				return tableDetails;
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
		}else{
			throw new AppException("Invalid table data");
		}
		

	}

	public TableDetails get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM TableDetails where tableId=:tableId");
			query.setParameter("tableId", id);
			return (TableDetails) query.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}
	public List<Integer> getTableIdsByCapacity(Integer capacity) throws AppException {
		try {
			
			Session session = DBUtil.getSession();
			Query query = session.createQuery("select tableId FROM TableDetails where capacity >= :capacity");
			query.setParameter("capacity", capacity);
			List<Integer> tableList = new ArrayList<Integer>();
			tableList = (List<Integer>)query.list();
			System.out.println("in getTableByCapacity: "+ tableList);
			return tableList;

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
			Query query = session.createQuery("delete TableDetails where tableId=:tableId");
			query.setParameter("tableId", id);
			query.executeUpdate();
			session.getTransaction().commit();
			flagDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return flagDeleted;
	}

	private boolean isValidData(TableDetails tableDetails) {

		if (tableDetails.getTableId() == null || tableDetails.getTableId() <= 0) {
			return false;
		}
		if (tableDetails.getCapacity() == null || tableDetails.getCapacity() <= 0) {
			return false;
		}
		
		return true;
	}

	public TableDetails update(int id, TableDetails tableDetails) throws AppException {
		TableDetails persistedTableDetails = get(id);
		
		if(isValidData(tableDetails)){
			if (persistedTableDetails != null) {
				try {
					Session session = DBUtil.getSession();
					session.beginTransaction();
					persistedTableDetails.setTableId(tableDetails.getTableId());
					persistedTableDetails.setCapacity(tableDetails.getCapacity());
					session.save(persistedTableDetails);
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					throw new AppException(e.getMessage());
				}

			}
		}else{
			throw new AppException("Data is invalid");
		}

		return persistedTableDetails;
	}

}
