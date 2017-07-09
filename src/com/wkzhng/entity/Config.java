package com.wkzhng.entity;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */

public class Config implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private String des;

	// Constructors

	/** default constructor */
	public Config() {
	}

	/** full constructor */
	public Config(String value, String des) {
		this.value = value;
		this.des = des;
	}

	// Property accessors

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}