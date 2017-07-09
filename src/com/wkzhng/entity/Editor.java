package com.wkzhng.entity;

/**
 * Editor entity. @author MyEclipse Persistence Tools
 */

public class Editor implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer editorid;
	private String passport;
	private String password;

	// Constructors

	/** default constructor */
	public Editor() {
	}

	/** full constructor */
	public Editor(String passport, String password) {
		this.passport = passport;
		this.password = password;
	}

	// Property accessors

	public Integer getEditorid() {
		return this.editorid;
	}

	public void setEditorid(Integer editorid) {
		this.editorid = editorid;
	}

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

}