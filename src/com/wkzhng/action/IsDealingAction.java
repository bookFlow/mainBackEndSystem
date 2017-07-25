package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IBookManage;
import com.wkzhng.service.IRecordManage;

public class IsDealingAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	
	@Resource
	IBookManage bookManage;
	
	String bid;
	String uid;
	
	Map<String, Object> dataMap;
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public IRecordManage getRecordManage() {
		return recordManage;
	}
	
	public void setRecordManage(IRecordManage recordManage) {
		this.recordManage = recordManage;
	}

	@Override
	public String execute(){
		System.out.println("IsDealingAction is working...");
		dataMap = new HashMap<>();
		Record record = recordManage.getRecordByBookIdAndBid(uid, Integer.parseInt(bid));
		Book book = bookManage.getBookById(Integer.parseInt(bid));
		if(book.getStatus() == 0)
			dataMap.put("candeal", true);
		else
			dataMap.put("candeal", false);
		if(record == null){
			dataMap.put("isInYourDeal", false);
		}
		else{
			dataMap.put("isInYourDeal", true);
		}
		return SUCCESS;
	}
}
