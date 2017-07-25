package com.wkzhng.dao;

import java.util.List;

import com.wkzhng.entity.Book;
import com.wkzhng.entity.Comment;

public interface IBookDao {
	public int addBook(String name, String type, Double x, Double y, String userName, long time);
	public String change_book_status(int id, int status);
	public List<Book> search_book_by_name(String searchInfo);
	public List<Book> search_book_by_position(Double x, Double y, Double scop);
	public Book getBookInfoById(int id);
	public List<Comment> get_comments_by_bookId(int id);
}

