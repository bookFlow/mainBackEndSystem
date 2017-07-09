package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.service.IMessageManage;

public class GetNewMsgNumAction implements Action{
	@Resource
	IMessageManage messageManage;
	
	String uid;
	
	Map<String, Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public IMessageManage getMessageManage() {
		return messageManage;
	}
	
	public void setMessageManage(IMessageManage messageManage) {
		this.messageManage = messageManage;
	}
	
	@Override
	public String execute(){
		System.out.println("GetNewMsgNumAction is working...");
		dataMap = new HashMap<>();
		return SUCCESS;
	}
}
