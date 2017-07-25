package com.wkzhng.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private People people;
	private String type;
	private String name;
	private int status;
	private Double x;
	private Double y;
	private Timestamp date;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(People people, String type, String name, int status,
			Double x, Double y, Set<Comment> comments, Timestamp date) {
		this.people = people;
		this.type = type;
		this.name = name;
		this.status = status;
		this.x = x;
		this.y = y;
		this.comments = comments;
		this.date = date;
	}

	// Property accessors

	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}