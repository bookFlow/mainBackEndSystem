package com.wkzhng.entity;

/**
 * CommentId entity. @author MyEclipse Persistence Tools
 */

public class CommentId implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	private People people;
	private Book book;

	// Constructors

	/** default constructor */
	public CommentId() {
	}

	/** full constructor */
	public CommentId(People people, Book book) {
		this.people = people;
		this.book = book;
	}

	// Property accessors

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return ((this.getPeople() == castOther.getPeople()) || (this
				.getPeople() != null && castOther.getPeople() != null && this
				.getPeople().equals(castOther.getPeople())))
				&& ((this.getBook() == castOther.getBook()) || (this.getBook() != null
						&& castOther.getBook() != null && this.getBook()
						.equals(castOther.getBook())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPeople() == null ? 0 : this.getPeople().hashCode());
		result = 37 * result
				+ (getBook() == null ? 0 : this.getBook().hashCode());
		return result;
	}

}