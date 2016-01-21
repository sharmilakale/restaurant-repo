package com.egen.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.User;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;


@Component
@Qualifier("userDao")
public class UserDao{

	public List<User> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from User");
			List<User> userList = query.list();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public User create(User user) throws AppException {
		try {
			Session session = DBUtil.getSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
	}

	public User get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM User where id=:userId");
			query.setParameter("userId", id);
			return (User) query.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}
	public User get(String emailId) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM User where email=:emailId and userType='owner'");
			query.setParameter("emailId", emailId);
			return (User) query.list().get(0);

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
			Query query = session.createQuery("delete User where id=:userId");
			query.setParameter("userId", id);
			query.executeUpdate();
			session.getTransaction().commit();
			flagDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return flagDeleted;
	}

	public User update(int id, User user) throws AppException {
		User persistedUser = get(id);
		if (persistedUser != null) {
			try{
					Session session = DBUtil.getSession();
					session.beginTransaction();
		
					if (user.getFirstName() != null)
						persistedUser.setFirstName(user.getFirstName());
					
					if (user.getLastName() != null)
						persistedUser.setLastName(user.getLastName());
					if (user.getPhone() != null)
						persistedUser.setPhone(user.getPhone());
				
						persistedUser.setEmail(user.getEmail());
		
					session.save(persistedUser);
					session.getTransaction().commit();
			}catch(Exception e){
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}

		}

		return persistedUser;
	}

}
