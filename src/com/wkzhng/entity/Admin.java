package com.wkzhng.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String passport;
	private String password;
	private String position;
	private String name;
	private Set<Operationlog> operationlogs = new HashSet<Operationlog>(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String password, String position, String name) {
		this.password = password;
		this.position = position;
		this.name = name;
	}

	/** full constructor */
	public Admin(String password, String position, String name,
			Set<Operationlog> operationlogs) {
		this.password = password;
		this.position = position;
		this.name = name;
		this.operationlogs = operationlogs;
	}

	// Property accessors

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Operationlog> getOperationlogs() {
		return this.operationlogs;
	}

	public void setOperationlogs(Set<Operationlog> operationlogs) {
		this.operationlogs = operationlogs;
	}

}