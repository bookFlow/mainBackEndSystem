package com.wkzhng.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.PeopleDetails;
import com.wkzhng.service.IPeopleManage;

import net.sf.json.JSONArray;

public class SearchPeoplesByPeopleNameAction implements Action{
	
	@Resource
	private IPeopleManage peopleManage;
	
	private String name;
	Map<String, Object> dataMap;
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public String execute(){
		System.out.println("SearchBooksByPeopleNameAction is working");
		dataMap = new HashMap<>();
		List<PeopleDetails> peopleDetailsList = peopleManage.getPeopleDetails(name);
		List<Map<String, Object>> peopleDetailsMaps = new ArrayList<>();
		for(PeopleDetails peopleDetails: peopleDetailsList){
			Map<String, Object> peopleDetailsMap = new HashMap<>();
			peopleDetailsMap.put("uname", peopleDetails.getName());
			peopleDetailsMap.put("rank", peopleDetails.getReputation());
			peopleDetailsMap.put("uid", peopleDetails.getPeopleUserName());
			peopleDetailsMap.put("sex", peopleDetails.getSex());
			peopleDetailsMap.put("age", peopleDetails.getAge());
			peopleDetailsMaps.add(peopleDetailsMap);
		}
		JSONArray peopleDetailsMapsJson = JSONArray.fromObject(peopleDetailsMaps);
		dataMap.put("list", peopleDetailsMapsJson);
		return SUCCESS;
	}
}
