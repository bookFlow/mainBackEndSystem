package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.IPeopleManage;
import com.wkzhng.service.IUserManage;

public class RegisterAction implements Action{
	
	@Resource
	private IUserManage userManage;
	
	@Resource
	private IPeopleManage peopleManage;
	
	private String uid;
	private String pwd;
	private Map<String, Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public IUserManage getUserManage() {
		return userManage;
	}
	
	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	@Override
	public String execute(){
		System.out.println("RegisterAction is working...");
		dataMap = new HashMap<>();
		String result = userManage.add_user_register(uid, pwd);
		if(result.equals(Const.SUCCEED)){
			peopleManage.addPeople(uid);
			dataMap.put("isSucceed", true);
		}
		else
			dataMap.put("isSucceed", false);
		return SUCCESS;
	}
}
