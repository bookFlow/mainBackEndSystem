package com.wkzhng.dao;

import java.util.List;

import com.wkzhng.entity.Message;

public interface IMessageDao {
	public String addMessage(String content, int rid, String uid, int type,int class_, long time, 
			double x, double y, String PName, long btime);
	public List<Message> search_message_by_rid(int rid);
	public List<Message> search_message_by_rid_beforesometime(int rid, long time);
	public List<Message> search_message_by_rid_aftersometime(int rid, long time);
}
