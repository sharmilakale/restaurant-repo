
package com.egen.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.ProfileAndSettings;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;

@Component
@Qualifier("profileAndSettingsDao")
public class ProfileAndSettingsDao {

	public List<ProfileAndSettings> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from ProfileAndSettings");
			List<ProfileAndSettings> profileList = query.list();
			return profileList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public ProfileAndSettings create(ProfileAndSettings profile) throws AppException {
		try {
			Session session = DBUtil.getSession();
			if(isValidProfileData(profile)){
				session.beginTransaction();
				session.save(profile);
				session.getTransaction().commit();
				return profile;
			}else{
				throw new AppException("Invalid profile data");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public ProfileAndSettings get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM ProfileAndSettings where restId=:restId");
			query.setParameter("restId", id);
			return (ProfileAndSettings) query.list().get(0);

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
			Query query = session.createQuery("delete ProfileAndSettings where restId=:restId");
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

	public ProfileAndSettings update(int id, ProfileAndSettings profile) throws AppException {
		ProfileAndSettings persistedProfile = get(id);
		if (persistedProfile != null) {
			if(isValidProfileData(profile)){
				try {
					Session session = DBUtil.getSession();
					session.beginTransaction();
	
					persistedProfile.setRestName(profile.getRestName());
					persistedProfile.setTagLine(profile.getTagLine());
					persistedProfile.setAddrLine1(profile.getAddrLine1());
					persistedProfile.setAddrLine2(profile.getAddrLine2());
					persistedProfile.setCity(profile.getCity());
					persistedProfile.setState(profile.getState());
					persistedProfile.setZipCode(profile.getZipCode());
					persistedProfile.setPhone(profile.getPhone());
					persistedProfile.setEmail(profile.getEmail());
					persistedProfile.setAutoAssign(profile.isAutoAssign());
					
					persistedProfile.setMon(profile.isMon());
					persistedProfile.setTues(profile.isTues());
					persistedProfile.setWed(profile.isWed());
					persistedProfile.setThur(profile.isThur());
					persistedProfile.setFri(profile.isFri());
					persistedProfile.setSat(profile.isSat());
					persistedProfile.setSun(profile.isSun());
					
					persistedProfile.setMonStart(profile.getMonStart());
					persistedProfile.setTuesStart(profile.getTuesStart());
					persistedProfile.setWedStart(profile.getWedStart());
					persistedProfile.setThurStart(profile.getThurStart());
					persistedProfile.setFriStart(profile.getFriStart());
					persistedProfile.setSatStart(profile.getSatStart());
					persistedProfile.setSunStart(profile.getSunStart());
					
					persistedProfile.setMonEnd(profile.getMonEnd());
					persistedProfile.setTuesEnd(profile.getTuesEnd());
					persistedProfile.setWedEnd(profile.getWedEnd());
					persistedProfile.setThurEnd(profile.getThurEnd());
					persistedProfile.setFriEnd(profile.getFriEnd());
					persistedProfile.setSatEnd(profile.getSatEnd());
					persistedProfile.setSunEnd(profile.getSunEnd());
					
					session.save(persistedProfile);
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					throw new AppException(e.getMessage());
				}
			}else{
				throw new AppException("Invalid profile data");
			}

		}

		return persistedProfile;
	}

	private boolean isValidProfileData(ProfileAndSettings profile){
		if(profile.getRestName() == null || profile.getRestName().trim().length() == 0){
			return false;
		}
		return true;
	}
}
