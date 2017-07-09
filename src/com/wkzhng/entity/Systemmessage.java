package com.wkzhng.entity;

import java.sql.Time;

/**
 * Systemmessage entity. @author MyEclipse Persistence Tools
 */

public class Systemmessage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer sid;
	private Time stime;
	private String scontent;

	// Constructors

	/** default constructor */
	public Systemmessage() {
	}

	/** full constructor */
	public Systemmessage(Time stime, String scontent) {
		this.stime = stime;
		this.scontent = scontent;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Time getStime() {
		return this.stime;
	}

	public void setStime(Time stime) {
		this.stime = stime;
	}

	public String getScontent() {
		return this.scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

}