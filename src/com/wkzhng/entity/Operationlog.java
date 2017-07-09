package com.wkzhng.entity;

import java.sql.Timestamp;

/**
 * Operationlog entity. @author MyEclipse Persistence Tools
 */

public class Operationlog implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	private String passport;
	private Admin admin;
	private String des;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Operationlog() {
	}

	/** full constructor */
	public Operationlog(Admin admin, String des, Timestamp date) {
		this.admin = admin;
		this.des = des;
		this.date = date;
	}

	// Property accessors

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}