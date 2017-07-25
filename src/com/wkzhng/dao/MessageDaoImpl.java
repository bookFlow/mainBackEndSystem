package com.wkzhng.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.constv.Const;
import com.wkzhng.entity.Message;
import com.wkzhng.entity.Record;

public class MessageDaoImpl implements IMessageDao{
	
private SessionFactory SessionFactory;
	
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	
	@Override
	public String addMessage(String content, int rid, String uid, int type,int class_, long time, 
			double x, double y, String PName, long btime) {
		System.out.println("MessageDaoImpl is working...addMessage");
		Session session = getSessionFactory().getCurrentSession();
		Message message = new Message();
		message.setContent(content);
		message.setRecord((Record)session.load(Record.class,rid));
		message.setUid(uid);
		message.setType(type);
		message.setClass_(class_);
		message.setTime(new Timestamp(time));
		message.setX(x);
		message.setY(y);
		message.setOperation(0);
		message.setPname(PName);
		message.setBtime(new Timestamp(btime));
		session.save(message);
		return Const.SUCCEED;
	}

	@Override
	public List<Message> search_message_by_rid(int rid){
		System.out.println("MessageDaoImpl is working...search_message_by_rid");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from message where recordid" + rid;
		@SuppressWarnings("unchecked")
		List<Message> messageList = session.createSQLQuery(sql).addEntity(Message.class).list();
		return messageList;
	}
	
	@Override
	public List<Message> search_message_by_rid_beforesometime(int rid, long time){
		System.out.println("MessageDaoImpl is working...search_message_by_rid_beforesometime");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from message where recordid=" + rid + " and time<=" + "'" +
		new Timestamp(time).toString().substring(0, new Timestamp(time).toString().length() - 2) + "'";
		@SuppressWarnings("unchecked")
		List<Message> messageList = session.createSQLQuery(sql).addEntity(Message.class).list();
		return messageList;	
	}

	@Override
	public List<Message> search_message_by_rid_aftersometime(int rid, long time){
		System.out.println("MessageDaoImpl is working...search_message_by_rid_aftersometime");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from message where recordid=" + rid + " and time >=" + "'" +
		new Timestamp(time).toString().substring(0, new Timestamp(time).toString().length() - 2) + "'";
		@SuppressWarnings("unchecked")
		List<Message> messageList = session.createSQLQuery(sql).addEntity(Message.class).list();
		return messageList;	
	}
}
