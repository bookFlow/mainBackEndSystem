package com.wkzhng.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.constv.Const;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.Record;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

public class RecordDaoImpl implements IRecordDao{
	
	@Resource
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String addRecord(String userName, int bookId, long time, double x, double y, String pname){
		System.out.println("RecordDaoImpl is working...addRecord");
		Session session = sessionFactory.getCurrentSession();
		Book book = (Book)session.load(Book.class, bookId);
		Record record = new Record(userName, book.getPeople().getUserName(), bookId, new Timestamp(time),
				x, y, pname, 0);
		session.save(record);
		return Const.SUCCEED;
	}
	
	@Override
	public List<Record> getBuyedBooks(String userName){
		System.out.println("RecordDaoImpl is working...getBuyedBooks");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from record where record.bid = '" + userName + "' and record.status = 5";
		@SuppressWarnings("unchecked")
		List<Record> recordList = session.createSQLQuery(sql).addEntity(Record.class).list();
		return recordList;
	}
	
	@Override
	public List<Record> getBuyingBooks(String userName){
		System.out.println("RecordDaoImpl is working...getBuyingBooks");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from record where record.bid = '" + userName + "' and (record.status = 0 "
				+ "or record.status = 1 or record.status = 2 or record.status = 3)";
		@SuppressWarnings("unchecked")
		List<Record> recordList = session.createSQLQuery(sql).addEntity(Record.class).list();
		return recordList;
	}
	
	@Override
	public List<Record> getBuyerRecord(String userName, int status) {
		System.out.println("RecordDaoImpl is working...getBuyerRecord");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from record where bid = '" + userName +"' and status = " + status;
		@SuppressWarnings("unchecked")
		List<Record> recordList = session.createSQLQuery(sql).addEntity(Record.class).list();
		return recordList;
	}

	@Override
	public List<Record> getSellerRecord(String userName, int status) {
		System.out.println("RecordDaoImpl is working...getSellerRecord");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from record where sid = '" + userName +"' and status = " + status;
		@SuppressWarnings("unchecked")
		List<Record> recordList = session.createSQLQuery(sql).addEntity(Record.class).list();
		return recordList;
	}

	@Override
	public Record getRecord(int rid) {
		System.out.println("RecordDaoImpl is working...getRecord");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		return record;
	}

	@Override
	public String whenSet(int rid) {
		System.out.println("RecordDaoImpl is working...whenSet");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		int i = record.getStatus();
		if(i == 0){
			record.setStatus(2);
			session.update(record); 
			return Const.SUCCEED;
		}

		else if(i == 1){
			record.setStatus(3);
			session.update(record);
			return Const.SUCCEED;
		}

		else
			return Const.FAIL;
	}

	@Override
	public String whenDel(int rid) {
		System.out.println("RecordDaoImpl is working...whenDel");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		int i = record.getStatus();
		if(i == 2){
			record.setStatus(0);
			session.update(record); 
			return Const.SUCCEED;
		}
		else if(i == 3){
			record.setStatus(1);
			session.update(record);
			return Const.SUCCEED;
		}
		else
			return Const.FAIL;
	}

	@Override
	public String whereSet(int rid) {
		System.out.println("RecordDaoImpl is working...whereSet");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		int i = record.getStatus();
		if(i == 0){
			record.setStatus(1);
			session.update(record); 
			return Const.SUCCEED;
		}
		else if(i == 2){
			record.setStatus(3);
			session.update(record);
			return Const.SUCCEED;
		}
		else
			return Const.FAIL;
	}

	@Override
	public String whereDel(int rid) {
		System.out.println("RecordDaoImpl is working...whereDel");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		int i = record.getStatus();
		if(i == 1){
			record.setStatus(0);
			session.update(record); 
			return Const.SUCCEED;
		}

		else if(i == 3){
			record.setStatus(2);
			session.update(record);
			return Const.SUCCEED;
		}

		else
			return Const.FAIL;
	}
	
	@Override
	public Record getRecordByBookIdAndBid(String uid, int bid){
		System.out.println("RecordDaoImpl is working...getRecordByBookIdAndBid");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from record where bid = '" + uid +"' and bookid = " + bid;
		@SuppressWarnings("unchecked")
		List<Record> recordList = session.createSQLQuery(sql).addEntity(Record.class).list();
		if(recordList.size() == 0){
			return null;
		}
		return recordList.get(0);
	}
	
	@Override
	public String reBook(int rid){
		System.out.println("RecordDaoImpl is working...reBook");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		
		record.setStatus(0);
		session.update(record);
		return Const.SUCCEED;
	}
	
	@Override
	public String confirmBuy(int rid){
		System.out.println("RecordDaoImpl is working...confirmBuy");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		
		record.setStatus(5);
		record.setDateOk(new Timestamp(new Date().getTime()));
		session.update(record);
		return Const.SUCCEED;
	}
	
	@Override
	public String confirmNotBuy(int rid){
		System.out.println("RecordDaoImpl is working...confirmNotBuy");
		Session session = getSessionFactory().getCurrentSession();
		Record record =(Record)session.load(Record.class, rid);
		
		record.setStatus(4);
		session.update(record);
		return Const.SUCCEED;
	}
}
