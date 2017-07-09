package com.wkzhng.service;

import java.util.List;

import com.wkzhng.entity.Book;
import com.wkzhng.entity.BookDetails;
import com.wkzhng.entity.Comment;

public interface IBookManage {
	public List<Book> getBooks(String bookName);
	public List<Book> getBooks(Double x, Double y, Double scop);
	public BookDetails getBookDetailsInfo(int bookId);
	public Book getBookById(int bookId);
	public List<Comment> getComments(int bookId);
	public String modifyStatus(int bookId);
	public String addBook(String userName, String name, Double x, Double y, String description, 
			String productor, String company, String images, Double price, String pName);
}
