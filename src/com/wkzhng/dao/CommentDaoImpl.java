package com.wkzhng.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.constv.Const;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.Comment;
import com.wkzhng.entity.CommentId;
import com.wkzhng.entity.People;

public class CommentDaoImpl implements ICommentDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String addComment(String userName, int bookId, String commentInfo){
		System.out.println("CommentDaoImpl is working...addComment");
		Session session = sessionFactory.getCurrentSession();
		People people = (People)session.load(People.class, userName);
		Book book = (Book)session.load(Book.class, bookId);
		Comment comment = new Comment(new CommentId(people, book), commentInfo);
		session.save(comment);
		return Const.SUCCEED;
	}
}
