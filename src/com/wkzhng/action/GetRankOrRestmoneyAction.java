package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.PeopleDetails;
import com.wkzhng.service.IPeopleManage;

public class GetRankOrRestmoneyAction implements Action{
	
	@Resource
	IPeopleManage peopleManage;
	
	private String uid;
	private String type;
	private Map<String, Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Override
	public String execute(){
		System.out.println("GetRankOrRestmoneyAction is working");
		dataMap = new HashMap<>();
		PeopleDetails peopleDetails = peopleManage.getPeopleDetailInfo(uid);
		String result = "";
		if(type.equals("1")){
			result = String.valueOf(peopleDetails.getReputation());
		}
		else if(type.equals("2")){
			result = String.valueOf(peopleDetails.getMoney());
		}
		dataMap.put("num", result);
		return SUCCESS;
	}
}
