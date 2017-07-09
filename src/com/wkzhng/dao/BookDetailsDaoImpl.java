package com.wkzhng.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.constv.Const;
import com.wkzhng.entity.BookDetails;

public class BookDetailsDaoImpl implements IBookDetailsDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Override
	public BookDetails getBookDetailsInfoById(int bookId){
		System.out.println("BookDetailsDaoImpl is working...getBookDetailsInfoById");
		Session session = sessionFactory.getCurrentSession();
		BookDetails bookDetails = (BookDetails)session.load(BookDetails.class, bookId);
		return bookDetails;
	}
	
	@Override
	public String addBookDetails(int bookId, String version, String pName,
			String editor, String publishingCompany, String images, Double price, String description){
		System.out.println("BookDetailsDaoImpl is working...addBookDetails");
		Session session = sessionFactory.getCurrentSession();
		BookDetails bookDetails = new BookDetails(bookId, version, editor, pName, publishingCompany, images, price, description);
		session.save(bookDetails);
		return Const.SUCCEED;
	}
}
