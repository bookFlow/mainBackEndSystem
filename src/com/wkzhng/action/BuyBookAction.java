package com.wkzhng.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.IBookManage;
import com.wkzhng.service.IPeopleManage;
import com.wkzhng.service.IRecordManage;

public class BuyBookAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	
	@Resource
	IBookManage bookManage;
	
	@Resource
	IPeopleManage peopleManage;
	
	private String uid;
	private String bid;
	private String x;
	private String y;
	private String pname;
	private String time;
	private Map<String, Object> dataMap;
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getX() {
		return x;
	}
	
	public void setX(String x) {
		this.x = x;
	}
	
	public String getY() {
		return y;
	}
	
	public void setY(String y) {
		this.y = y;
	}
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
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
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String execute() throws ParseException{
		System.out.println("BuyBookAction is working");
		dataMap = new HashMap<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(time);
		String result1 = recordManage.addRecord(uid, Integer.parseInt(bid), date.getTime(), 
				Double.parseDouble(x), Double.parseDouble(y), pname);
		if(result1.equals(Const.SUCCEED)){
			dataMap.put("isSucceed", true);
		}
		else{
			dataMap.put("isSucceed", false);
		}
		Double restMoney = peopleManage.getMoney(uid);
		dataMap.put("restMoney", restMoney);
		return SUCCESS;
	}
}
