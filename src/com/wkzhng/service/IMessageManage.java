package com.wkzhng.service;

import java.util.List;

import com.wkzhng.entity.Message;

public interface IMessageManage {
	//public Message getLastMessage(int rid, long time);
	public String addMessage(String content, int rid, String uid, int type, int class_, long time, 
			double x, double y, String pName);
	//public List<Message> getMessagesByRid(int rid);
	public List<Message> getMessageBefore(int rid, long time);
	public List<Message> getMessageAfter(int rid, long time);
}
