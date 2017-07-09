package com.wkzhng.entity;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private CommentId id;
	private String comment;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(CommentId id, String comment) {
		this.id = id;
		this.comment = comment;
	}

	// Property accessors

	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}