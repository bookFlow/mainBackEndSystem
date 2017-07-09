package com.wkzhng.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.entity.Book;
import com.wkzhng.entity.People;
import com.wkzhng.constv.Const;

public class PeopleDaoImpl implements IPeopleDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public String check_userName_password(String userName, String password){
		System.out.println("PeopleDaoImpl is working...check_userName_password");
		Session session = getSessionFactory().getCurrentSession();
		People people = (People)session.load(People.class, userName);
		if(!people.getPassword().equals(password)){
			return Const.FAIL;
		}
		else
			return Const.SUCCEED;
	}
	
	@Override
	public String add_userName_password(String newUserName, String newPassword){
		System.out.println("PeopleDaoImpl is working...add_userName_password");
		Session session = getSessionFactory().getCurrentSession();
		People people = new People();
		people.setUserName(newUserName);
		people.setPassword(newPassword);
		session.save(people);
		return Const.SUCCEED;
	}
	
	@Override
	public String check_userName(String userName){
		System.out.println("PeopleDaoImpl is working...check_userName");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from people where people.userName = '" + userName + "'";
		@SuppressWarnings("unchecked")
		List<People> peopleList = session.createSQLQuery(sql).addEntity(People.class).list();
		if(peopleList.size() == 0){
			return Const.UNEXSITED;
		}
		else{
			return Const.EXSITED;
		}
	}
	
	@Override
	public String change_password(String userName, String newPassword){
		System.out.println("PeopleDaoImpl is working...change_password");
		Session session = getSessionFactory().getCurrentSession();
		People people = new People();
		people.setUserName(userName);
		people.setPassword(newPassword);
		session.update(people);
		return Const.SUCCEED;
	}
	
	@Override
	public List<Book> getBookListByUserName(String userName){
		System.out.println("PeopleDaoImpl is working...getBookListByUserName");
		Session session = getSessionFactory().getCurrentSession();
		People people = (People)session.load(People.class, userName);
		Set<Book> bookSet = people.getBooks();
		List<Book> bookList = new ArrayList<>();
		Iterator<Book> it = bookSet.iterator();
		while(it.hasNext()){
			bookList.add(it.next());
		}
		return bookList;
	}
}