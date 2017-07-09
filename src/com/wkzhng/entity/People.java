package com.wkzhng.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * People entity. @author MyEclipse Persistence Tools
 */

public class People implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	// Fields

	private String userName;
	private String password;
	private Set<Book> books = new HashSet<Book>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public People() {
	}

	/** full constructor */
	public People(String userName, String password, Set<Book> books, Set<Comment> comments) {
		this.userName = userName;
		this.password = password;
		this.books = books;
		this.comments = comments;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}