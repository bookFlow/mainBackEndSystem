package com.wkzhng.entity;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer mid;
	private String uid;
	private Record record;
	private String content;
	private Integer type;
	private Integer class_;
	private Integer operation;
	private Timestamp btime;
	private Timestamp time;
	private Double x;
	private Double y;
	private String pname;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Record record, String uid, String content, Integer type, Integer class_,
			Integer operation, Timestamp btime, Timestamp time, Double x, Double y, String pname) {
		this.uid = uid;
		this.record = record;
		this.content = content;
		this.type = type;
		this.class_ = class_;
		this.operation = operation;
		this.time = time;
		this.x = x;
		this.y = y;
		this.pname = pname;
		this.btime = btime;
	}

	// Property accessors

	public Timestamp getBtime() {
		return btime;
	}
	
	public void setBtime(Timestamp btime) {
		this.btime = btime;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Record getRecord() {
		return this.record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getClass_() {
		return this.class_;
	}

	public void setClass_(Integer class_) {
		this.class_ = class_;
	}

	public Integer getOperation() {
		return this.operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}