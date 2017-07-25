package com.wkzhng.service;

import java.util.List;

import com.wkzhng.entity.Record;

public interface IRecordManage {
	public String addRecord(String userName, int bookId, long time, double x, double y, String pname);
	public List<Record> getBuyedBooks(String userName);
	public List<Record> getBuyingBooks(String userName);
	public List<Record> getRecordsByTypeAndStatus(String uid, int type, int dealed);
	public Record getRecordById(int rid);
	public String updateStatus(int rid, int operation, int type);
	public Record getRecordByBookIdAndBid(String uid, int bid);
}
