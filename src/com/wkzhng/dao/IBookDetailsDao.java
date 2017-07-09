package com.wkzhng.dao;

import com.wkzhng.entity.BookDetails;

public interface IBookDetailsDao {
	public BookDetails getBookDetailsInfoById(int id);
	public String addBookDetails(int bookId, String version, String pName,
			String editor, String publishingCompany, String images, Double price, String description);
}
