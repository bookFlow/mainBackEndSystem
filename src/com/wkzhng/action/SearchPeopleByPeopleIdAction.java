package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.PeopleDetails;
import com.wkzhng.service.IPeopleManage;

public class SearchPeopleByPeopleIdAction implements Action{
	@Resource
	private IPeopleManage peopleManage;
	
	private String uid;
	Map<String, Object> dataMap;
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
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
	
	@Override
	public String execute(){
		System.out.println("SearchPeopleByPeopleIdAction is working");
		dataMap = new HashMap<>();
		PeopleDetails peopleDetails = peopleManage.getPeopleDetailInfo(uid);
		dataMap.put("uname", peopleDetails.getName());
		dataMap.put("rank", peopleDetails.getReputation());
		dataMap.put("uid", peopleDetails.getPeopleUserName());
		dataMap.put("sex", peopleDetails.getSex());
		dataMap.put("age", peopleDetails.getAge());
		return SUCCESS;
	}
}
