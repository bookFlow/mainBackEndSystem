package com.wkzhng.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer recordid;
	private String bid;
	private String sid;
	private Integer bookid;
	private Timestamp dateOk;
	private Double x;
	private Double y;
	private String pname;
	private Integer status;
	private Set<Message> messages = new HashSet<Message>(0);

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record(String bid, String sid, Integer bookid, Timestamp dateOk,
			Double x, Double y, String pname, Integer status) {
		this.bid = bid;
		this.sid = sid;
		this.bookid = bookid;
		this.dateOk = dateOk;
		this.x = x;
		this.y = y;
		this.pname = pname;
		this.status = status;
	}

	// Property accessors

	public Integer getRecordid() {
		return this.recordid;
	}

	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
	}

	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public String getSid() {
		return sid;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getBookid() {
		return this.bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	
	public Timestamp getDateOk() {
		return dateOk;
	}
	
	public void setDateOk(Timestamp dateOk) {
		this.dateOk = dateOk;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Double getX() {
		return x;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	public Set<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}