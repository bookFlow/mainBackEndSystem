package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IRecordManage;

public class GetRecordNewestStatusAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	
	String rid;
	
	Map<String, Object> dataMap;
	
	public IRecordManage getRecordManage() {
		return recordManage;
	}
	
	public void setRecordManage(IRecordManage recordManage) {
		this.recordManage = recordManage;
	}
	
	public String getRid() {
		return rid;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public String execute(){
		System.out.println("GetRecordNewestStatusAction is working...");
		dataMap = new HashMap<>();
		Record record = new Record();
		record = recordManage.getRecordById(Integer.parseInt(rid));
		dataMap.put("rStatus", record.getStatus());
		return SUCCESS;
	}
}
