package com.egen.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfileAndSettings {
	private static final long serialVersionUID = -549896810197689366L;
	@Id
	private Integer restId;
	private String restName;
	private String tagLine;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;
	private Boolean autoAssign;
	private String openCloseDetails;
	private Boolean mon;
	private Boolean tues;
	private Boolean wed;
	private Boolean thur;
	private Boolean fri;
	private Boolean sat;
	private Boolean sun;
	
	private String monStart;
	private String tuesStart;
	private String wedStart;
	private String thurStart;
	private String friStart;
	private String satStart;
	private String sunStart;
	
	private String monEnd;
	private String tuesEnd;
	private String wedEnd;
	private String thurEnd;
	private String friEnd;
	private String satEnd;
	private String sunEnd;
	
	
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean isAutoAssign() {
		return autoAssign;
	}
	public void setAutoAssign(Boolean autoAssign) {
		this.autoAssign = autoAssign;
	}
	public String getOpenCloseDetails() {
		return openCloseDetails;
	}
	public void setOpenCloseDetails(String openCloseDetails) {
		this.openCloseDetails = openCloseDetails;
	}
	
	public Boolean isMon() {
		return mon;
	}
	public void setMon(Boolean mon) {
		this.mon = mon;
	}
	public Boolean isTues() {
		return tues;
	}
	public void setTues(Boolean tues) {
		this.tues = tues;
	}
	public Boolean isWed() {
		return wed;
	}
	public void setWed(Boolean wed) {
		this.wed = wed;
	}
	public Boolean isThur() {
		return thur;
	}
	public void setThur(Boolean thur) {
		this.thur = thur;
	}
	public Boolean isFri() {
		return fri;
	}
	public void setFri(Boolean fri) {
		this.fri = fri;
	}
	public Boolean isSat() {
		return sat;
	}
	public void setSat(Boolean sat) {
		this.sat = sat;
	}
	public Boolean isSun() {
		return sun;
	}
	public void setSun(Boolean sun) {
		this.sun = sun;
	}
	public String getMonStart() {
		return monStart;
	}
	public void setMonStart(String monStart) {
		this.monStart = monStart;
	}
	public String getTuesStart() {
		return tuesStart;
	}
	public void setTuesStart(String tuesStart) {
		this.tuesStart = tuesStart;
	}
	public String getWedStart() {
		return wedStart;
	}
	public void setWedStart(String wedStart) {
		this.wedStart = wedStart;
	}
	public String getThurStart() {
		return thurStart;
	}
	public void setThurStart(String thurStart) {
		this.thurStart = thurStart;
	}
	public String getFriStart() {
		return friStart;
	}
	public void setFriStart(String friStart) {
		this.friStart = friStart;
	}
	public String getSatStart() {
		return satStart;
	}
	public void setSatStart(String satStart) {
		this.satStart = satStart;
	}
	public String getSunStart() {
		return sunStart;
	}
	public void setSunStart(String sunStart) {
		this.sunStart = sunStart;
	}
	public String getMonEnd() {
		return monEnd;
	}
	public void setMonEnd(String monEnd) {
		this.monEnd = monEnd;
	}
	public String getTuesEnd() {
		return tuesEnd;
	}
	public void setTuesEnd(String tuesEnd) {
		this.tuesEnd = tuesEnd;
	}
	public String getWedEnd() {
		return wedEnd;
	}
	public void setWedEnd(String wedEnd) {
		this.wedEnd = wedEnd;
	}
	public String getThurEnd() {
		return thurEnd;
	}
	public void setThurEnd(String thurEnd) {
		this.thurEnd = thurEnd;
	}
	public String getFriEnd() {
		return friEnd;
	}
	public void setFriEnd(String friEnd) {
		this.friEnd = friEnd;
	}
	public String getSatEnd() {
		return satEnd;
	}
	public void setSatEnd(String satEnd) {
		this.satEnd = satEnd;
	}
	public String getSunEnd() {
		return sunEnd;
	}
	public void setSunEnd(String sunEnd) {
		this.sunEnd = sunEnd;
	}
	public ProfileAndSettings(){
		
	}
	public ProfileAndSettings(Integer restId, String restName, String tagLine, String addrLine1, String addrLine2,
			String city, String state, String zipCode, String phone, String email, Boolean autoAssign,
			String openCloseDetails, Boolean mon, Boolean tues, Boolean wed, Boolean thur, Boolean fri, Boolean sat,
			Boolean sun, String monStart, String tuesStart, String wedStart, String thurStart, String friStart,
			String satStart, String sunStart, String monEnd, String tuesEnd, String wedEnd, String thurEnd,
			String friEnd, String satEnd, String sunEnd) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.tagLine = tagLine;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
		this.autoAssign = autoAssign;
		this.openCloseDetails = openCloseDetails;
		this.mon = mon;
		this.tues = tues;
		this.wed = wed;
		this.thur = thur;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
		this.monStart = monStart;
		this.tuesStart = tuesStart;
		this.wedStart = wedStart;
		this.thurStart = thurStart;
		this.friStart = friStart;
		this.satStart = satStart;
		this.sunStart = sunStart;
		this.monEnd = monEnd;
		this.tuesEnd = tuesEnd;
		this.wedEnd = wedEnd;
		this.thurEnd = thurEnd;
		this.friEnd = friEnd;
		this.satEnd = satEnd;
		this.sunEnd = sunEnd;
	}
	@Override
	public String toString() {
		return "ProfileAndSettings [restId=" + restId + ", restName=" + restName + ", tagLine=" + tagLine
				+ ", addrLine1=" + addrLine1 + ", addrLine2=" + addrLine2 + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", phone=" + phone + ", email=" + email + ", autoAssign=" + autoAssign
				+ ", openCloseDetails=" + openCloseDetails + ", mon=" + mon + ", tues=" + tues + ", wed=" + wed
				+ ", thur=" + thur + ", fri=" + fri + ", sat=" + sat + ", sun=" + sun + ", monStart=" + monStart
				+ ", tuesStart=" + tuesStart + ", wedStart=" + wedStart + ", thurStart=" + thurStart + ", friStart="
				+ friStart + ", satStart=" + satStart + ", sunStart=" + sunStart + ", monEnd=" + monEnd + ", tuesEnd="
				+ tuesEnd + ", wedEnd=" + wedEnd + ", thurEnd=" + thurEnd + ", friEnd=" + friEnd + ", satEnd=" + satEnd
				+ ", sunEnd=" + sunEnd + "]";
	}

	
	
}
