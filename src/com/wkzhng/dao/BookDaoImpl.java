package com.wkzhng.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.wkzhng.constv.Const;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.Comment;
import com.wkzhng.entity.People;

public class BookDaoImpl implements IBookDao {
	
	private SessionFactory SessionFactory;
	
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public int addBook(String name, String type, Double x, Double y, String userName, long time){
		System.out.println("BookDaoImpl is working...addBook");
		Session session = getSessionFactory().getCurrentSession();
		Book book = new Book();
		book.setName(name);
		book.setType(type);
		book.setStatus(0);
		book.setX(x);
		book.setY(y);
		book.setDate(new Timestamp(time));
		book.setPeople((People)session.load(People.class, userName));
		session.save(book);
		return book.getId();
	}
	
	@Override
	public String change_book_status(int id, int status){
		System.out.println("BookDaoImpl is working...change_book_status");
		Session session = getSessionFactory().getCurrentSession();
		Book book = (Book)session.load(Book.class, id);
		book.setStatus(status);
	    session.update(book); 
		return Const.SUCCEED;
	}
	
	@Override
	public List<Book> search_book_by_name(String searchInfo){
		System.out.println("BookDaoImpl is working...search_book_by_name");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from book where name LIKE '%" + searchInfo + "%'";
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createSQLQuery(sql).addEntity(Book.class).list();
		return bookList;
	}
	
	@Override
	public List<Book> search_book_by_position(Double x, Double y, Double scop){
		System.out.println("BookDaoImpl is working...search_book_by_position");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from book";
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createSQLQuery(sql).addEntity(Book.class).list();
		List<Book> resultList = new ArrayList<>();
		for(Book book: bookList){
			Double xd = Math.abs(book.getX() - x);
			Double yd = Math.abs(book.getY() - y);
			if(xd * xd + yd * yd <= scop){
				resultList.add(book);
			}
		}
		return resultList;
	}
	
	@Override
	public Book getBookInfoById(int id){
		System.out.println("BookDaoImpl is working...getBookInfoById");
		Session session = getSessionFactory().getCurrentSession();
		Book book = (Book)session.load(Book.class, id);
		return book;
	}
	
	@Override
	public List<Comment> get_comments_by_bookId(int id){
		System.out.println("BookDaoImpl is working...get_comments_by_bookId");
		Session session = getSessionFactory().getCurrentSession();
		Book book = (Book)session.load(Book.class, id);
		Set<Comment> commentSet = book.getComments();
		List<Comment> commentList = new ArrayList<>();
		Iterator<Comment> it = commentSet.iterator();
		while(it.hasNext()){
			commentList.add(it.next());
		}
		return commentList;
	}
}
