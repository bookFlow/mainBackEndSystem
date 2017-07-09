package com.wkzhng.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.wkzhng.dao.IMessageDao;
import com.wkzhng.entity.Message;

public class MessageManageImpl implements IMessageManage{
	
	private SessionFactory sessionFactory;
	
	@Resource
	private IMessageDao messageDao;
	
	public IMessageDao getMessageDao() {
		return messageDao;
	}
	
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String addMessage(String content, int rid, String uid, int type, int class_, long time, 
			double x, double y, String pName){
		System.out.println("MessageManageImpl is working...addMessage");
		return messageDao.addMessage(content, rid, uid, type, class_, time, x, y, pName);
	}
	
	@Override
	public List<Message> getMessageBefore(int rid, long time){
		System.out.println("MessageManageImpl is working...getMessageBefore");
		return messageDao.search_message_by_rid_beforesometime(rid, time);
	}
	
	@Override
	public List<Message> getMessageAfter(int rid, long time){
		System.out.println("MessageManageImpl is working...getMessageAfter");
		return messageDao.search_message_by_rid_aftersometime(rid, time);
	}
}
