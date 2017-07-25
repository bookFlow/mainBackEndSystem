package com.wkzhng.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Message;
import com.wkzhng.service.IMessageManage;
import com.wkzhng.service.IPeopleManage;

import net.sf.json.JSONArray;

public class GetMsgFromLastAction implements Action{
	@Resource 
	private IMessageManage messageManage;
	@Resource
	private IPeopleManage peopleManage;
	
	private String rid;
	private String lastTime;
	private int type;
	
	private Map<String, Object> dataMap;
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getRid() {
		return rid;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getLastTime() {
		return lastTime;
	}
	
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	
	public IMessageManage getMessageManage() {
		return messageManage;
	}
	
	public void setMessageManage(IMessageManage messageManage) {
		this.messageManage = messageManage;
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
	
	@Override
	public String execute() throws ParseException{
		System.out.println("GetMsgFromLastAction is working...");
		dataMap = new HashMap<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(lastTime);
		List<Message> messages = new ArrayList<>();
		if(type == 0)
			messages = messageManage.getMessageBefore(Integer.parseInt(rid), 
					date.getTime());
		else
			messages = messageManage.getMessageAfter(Integer.parseInt(rid), 
					date.getTime());
		List<Map<String, Object>> messageMaps = new ArrayList<>();
		for(Message message: messages){
			Map<String, Object> messageMap = new HashMap<>();
			messageMap.put("mid", message.getMid());
			String uid = message.getUid();
			messageMap.put("uid", uid);
			messageMap.put("msg", message.getContent());
			messageMap.put("uname", peopleManage.getPeopleDetailInfo(uid).getName());
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
}
