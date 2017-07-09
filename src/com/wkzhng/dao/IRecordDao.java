package com.wkzhng.dao;

import java.util.List;
import com.wkzhng.entity.Record;

public interface IRecordDao {
	public String addRecord(String userName, int bookId, long time, double x, double y, String pname);
	public List<Record> getBuyedBooks(String userName);
	public List<Record> getBuyerRecord(String userName, int status);
	public List<Record> getSellerRecord(String userName, int status);
	public Record getRecord(int rid);
	public String whenSet(int rid);
	public String whenDel(int rid);
	public String whereSet(int rid);
	public String whereDel(int rid);
}
