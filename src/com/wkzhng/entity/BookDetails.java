package com.wkzhng.entity;

/**
 * BookDetails entity. @author MyEclipse Persistence Tools
 */

public class BookDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private String version;
	private String editor;
	private String publishingCompany;
	private String images;
	private Double price;
	private String description;
	private String pName;

	// Constructors

	/** default constructor */
	public BookDetails() {
	}

	/** full constructor */
	public BookDetails(Integer bookId, String version, String editor, String pName,
			String publishingCompany, String images, Double price, String description) {
		this.bookId = bookId;
		this.version = version;
		this.editor = editor;
		this.publishingCompany = publishingCompany;
		this.images = images;
		this.price = price;
		this.description = description;
		this.pName = pName;
	}

	// Property accessors

	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getPublishingCompany() {
		return this.publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getImages() {
		return images;
	}
	
	public void setImages(String images) {
		this.images = images;
	}
	
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}