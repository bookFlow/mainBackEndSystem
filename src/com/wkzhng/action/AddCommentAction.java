package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.ICommentManage;

public class AddCommentAction implements Action{
	
	@Resource
	ICommentManage commentManage;
	
	private String uid;
	private String bid;
	private String comment;
	private Map<String, Object> dataMap;
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public ICommentManage getCommentManage() {
		return commentManage;
	}
	
	public void setCommentManage(ICommentManage commentManage) {
		this.commentManage = commentManage;
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
		System.out.println("AddCommentAction is working");
		dataMap = new HashMap<>();
		String result = commentManage.addComment(uid, Integer.parseInt(bid), comment);
		if(result.equals(Const.SUCCEED))
			dataMap.put("isSucceed", true);
		else
			dataMap.put("isSucceed", false);
		return SUCCESS;
	}
}
