package com.wkzhng.entity;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer newsid;
	private Timestamp date;
	private String title;
	private String publisher;
	private String content;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Timestamp date, String title, String publisher, String content) {
		this.date = date;
		this.title = title;
		this.publisher = publisher;
		this.content = content;
	}

	// Property accessors

	public Integer getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}