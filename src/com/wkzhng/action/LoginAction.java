package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.wkzhng.constv.Const;
import com.wkzhng.entity.PeopleDetails;
import com.wkzhng.service.IPeopleManage;
import com.wkzhng.service.IUserManage;

public class LoginAction implements Action{

	private String uid;
	private String pwd;
	private Map<String, Object> dataMap;
		
	@Resource(name="peopleManage")
	private IPeopleManage peopleManage;
	
	@Resource(name="userManage")
	private IUserManage userManage;
	
	public IUserManage getUserManage(){
		return userManage;
	}
	
	public void setUserManage(IUserManage userManage){
		this.userManage = userManage;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
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

	@Override
	public String execute(){
		System.out.println("LoginAction is working");
		dataMap = new HashMap<>();
		String loginResult = "";
		loginResult = userManage.check_user_login(uid, pwd);
		if(loginResult.equals(Const.SUCCEED)){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("userName", uid);
			dataMap.put("isLogin", true);
			PeopleDetails resultDetails;
			System.out.println(loginResult);
			resultDetails = peopleManage.getPeopleDetailInfo(uid);
			dataMap.put("uname", resultDetails.getName());
			dataMap.put("rank", resultDetails.getReputation());
			dataMap.put("uid", uid);
			dataMap.put("pwd", pwd);
			if(resultDetails.getSex() == true)
				dataMap.put("sex", "1");
			else
				dataMap.put("sex", "2");
			dataMap.put("age", resultDetails.getAge());
			dataMap.put("restMoney", resultDetails.getMoney());
		}
		else{
			dataMap.put("isLogin", false);
		}
		return SUCCESS;
	}
}
