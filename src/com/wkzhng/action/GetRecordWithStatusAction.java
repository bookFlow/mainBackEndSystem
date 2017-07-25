package com.wkzhng.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.BookDetails;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IBookManage;
import com.wkzhng.service.IRecordManage;

import net.sf.json.JSONArray;

public class GetRecordWithStatusAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	@Resource
	IBookManage bookManage;
	
	String uid;
	String type;
	String dealed;
	Map<String, Object> dataMap;
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDealed() {
		return dealed;
	}
	
	public void setDealed(String dealed) {
		this.dealed = dealed;
	}
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public IRecordManage getRecordManage() {
		return recordManage;
	}
	
	public void setRecordManage(IRecordManage recordManage) {
		this.recordManage = recordManage;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public String execute(){
		System.out.println("GetRecordWithStatusAction is working...");
		dataMap = new HashMap<>();
		List<Record> records = new ArrayList<>();
		records = recordManage.getRecordsByTypeAndStatus(uid, Integer.parseInt(type), 
				Integer.parseInt(dealed));
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		for(Record record: records){
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("rId", record.getRecordid());
			resultMap.put("rStatus", record.getStatus());
			if(Integer.parseInt(type) == 0)
				resultMap.put("ownerId", record.getSid());
			else
				resultMap.put("ownerId", record.getBid());
			resultMap.put("bId", record.getBookid());
			Book book = bookManage.getBookById(record.getBookid());
			resultMap.put("bookName", book.getName());
			BookDetails bookDetails = bookManage.getBookDetailsInfo(record.getBookid());
			resultMap.put("bookImage", bookDetails.getImages());
			resultMaps.add(resultMap);
		}
		JSONArray jsonArray = JSONArray.fromObject(resultMaps);
		dataMap.put("list", jsonArray);
		return SUCCESS;
	}
}
