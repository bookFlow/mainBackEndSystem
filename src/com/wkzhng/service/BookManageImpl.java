package com.wkzhng.service;

import java.util.List;

import javax.annotation.Resource;

import com.wkzhng.dao.IBookDao;
import com.wkzhng.dao.IBookDetailsDao;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.BookDetails;
import com.wkzhng.entity.Comment;

public class BookManageImpl implements IBookManage{
	
	@Resource(name="bookDao")
	private IBookDao bookDao;
	
	@Resource(name="bookDetailsDao")
	private IBookDetailsDao bookDetailsDao;
	
	public IBookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public IBookDetailsDao getBookDetailsDao() {
		return bookDetailsDao;
	}
	
	public void setBookDetailsDao(IBookDetailsDao bookDetailsDao) {
		this.bookDetailsDao = bookDetailsDao;
	}
	
	@Override
	public List<Book> getBooks(String bookName){
		System.out.println("BookManageImpl is working...getBooks");
		List<Book> resultBooks = bookDao.search_book_by_name(bookName);
		return resultBooks;
	}
	
	@Override
	public List<Book> getBooks(Double x, Double y, Double scop){
		System.out.println("BookManageImpl is working...getBooks");
		List<Book> resultBooks = bookDao.search_book_by_position(x, y, scop);
		return resultBooks;
	}
	
	@Override
	public BookDetails getBookDetailsInfo(int bookId){
		System.out.println("BookManageImpl is working...getBookDetailsInfo");
		BookDetails bookDetails = bookDetailsDao.getBookDetailsInfoById(bookId);
		return bookDetails;
	}
	
	@Override
	public Book getBookById(int bookId){
		System.out.println("BookManageImpl is working...getBookById");
		Book book = bookDao.getBookInfoById(bookId);
		return book;
	}
	
	@Override
	public List<Comment> getComments(int bookId){
		System.out.println("BookManageImpl is working...getComments");
		List<Comment> comments = bookDao.get_comments_by_bookId(bookId);
		return comments;
	}
	
	@Override
	public String modifyStatus(int bookId, int status){
		System.out.println("BookManageImpl is working...modifyStatus");
		return bookDao.change_book_status(bookId, status);
	}
	
	@Override
	public String addBook(String userName, String name, Double x, Double y, long time, String description, 
			String productor, String company, String images, Double price, String pName){
		System.out.println("BookManageImpl is working...addBook");
		int bookId = bookDao.addBook(name, "", x, y, userName, time);
		return bookDetailsDao.addBookDetails(bookId, "", pName, productor, company, images, price, 
				description);
	}
}
