package com.wkzhng.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Message;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IMessageManage;
import com.wkzhng.service.IPeopleManage;
import com.wkzhng.service.IRecordManage;

import net.sf.json.JSONArray;

public class GetConversationDetailAction implements Action{

	@Resource
	IRecordManage recordManage;
	
	@Resource
	IMessageManage messageManage;
	
	@Resource
	IPeopleManage peopleManage;
	
	String rid;
	
	Map<String, Object> dataMap;
	
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
	
	public String getRid() {
		return rid;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	public IMessageManage getMessageManage() {
		return messageManage;
	}
	
	public void setMessageManage(IMessageManage messageManage) {
		this.messageManage = messageManage;
	}
	
	@Override
	public String execute(){
		System.out.println("GetConversationDetailAction is working...");
		dataMap = new HashMap<>();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Record record =  recordManage.getRecordById(Integer.parseInt(rid));
		
		dataMap.put("bid", record.getBid());
		dataMap.put("sid", record.getSid());
		
		dataMap.put("bname", peopleManage.getPeopleDetailInfo(record.getBid()).getName());
		dataMap.put("sname", peopleManage.getPeopleDetailInfo(record.getSid()).getName());
		
		dataMap.put("rStatus", record.getStatus());
		
		Set<Message> messageSet = record.getMessages();
		List<Message> messageList = orderSetToList(messageSet);
		
		List<Map<String, Object>> messageMaps = new ArrayList<>();
		for(Message message: messageList){
			Map<String, Object> messageMap = new HashMap<>();
			messageMap.put("mid", message.getMid());
			String uid = message.getUid();
			messageMap.put("uid", uid);
			messageMap.put("uname", peopleManage.getPeopleDetailInfo(uid).getName());
			messageMap.put("msg", message.getContent());
			messageMap.put("type", message.getType());
			messageMap.put("class_", message.getClass_());
			messageMap.put("operation", message.getOperation());
			messageMap.put("time", dateFormat.format(new Date(message.getTime().getTime())));
			messageMap.put("btime", dateFormat.format(new Date(message.getBtime().getTime())));
			messageMaps.add(messageMap);
		}
		JSONArray jsonArray = JSONArray.fromObject(messageMaps);
		dataMap.put("list", jsonArray);
		
		return SUCCESS;
	}
	private List<Message> orderSetToList(Set<Message> messageSet){
	    
	    List<Message> messageList = new ArrayList<>();
        messageList.addAll(messageSet);
	    Collections.sort((messageList));
	    return messageList;
	}	
}
