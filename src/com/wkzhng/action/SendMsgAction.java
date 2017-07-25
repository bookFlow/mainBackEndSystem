package com.wkzhng.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.IMessageManage;

public class SendMsgAction implements Action{
	@Resource
	private IMessageManage messageManage;
	
	private String msg; //��Ϣ����
	private String uid; //�û�id
	private String rid; //��¼id
	private String type;//��ͨ��Ϣ 0 ������Ϣ 1
	private String class_; //ʱ����Ϣ �ص���Ϣ
	private String x;    //�ص�����x ����
	private String y;    //�ص�����y γ��
	private String pname; //�ص�����
	private String time; //ʱ��
	private String btime;
	private Map<String, Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public String getBtime() {
		return btime;
	}
	
	public void setBtime(String btime) {
		this.btime = btime;
	}
	
	public String getRid() {
		return rid;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getClass_() {
		return class_;
	}
	
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
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
	
	public String getX() {
		return x;
	}
	
	public void setX(String x) {
		this.x = x;
	}
	
	public String getY() {
		return y;
	}
	
	public void setY(String y) {
		this.y = y;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public IMessageManage getMessageManage() {
		return messageManage;
	}
	
	public void setMessageManage(IMessageManage messageManage) {
		this.messageManage = messageManage;
	}
	
	@Override
	public String execute() throws ParseException{
		System.out.println("SendMsgAction is working...");
		dataMap = new HashMap<>();
		
		if(class_ == null)
			class_ = "-1";
		
		if(x == null)
			x = "-1";
		
		if(y == null)
			y = "-1";
		
		if(pname == null)
			pname = "";
		
		if(btime == null)
			btime = "1970-01-01 00:00:00";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		//Date date = dateFormat.parse(time);
		Date bdate = dateFormat.parse(btime);
		
		String result = messageManage.addMessage(msg, Integer.parseInt(rid), uid, Integer.parseInt(type), 
				Integer.parseInt(class_), date.getTime(), Double.parseDouble(x), Double.parseDouble(y), 
				pname, bdate.getTime());
		
		if(result.equals(Const.SUCCEED)){
			dataMap.put("isSucceed", true);
		}
		else{
			dataMap.put("isSucceed", false);
		}
		
		return SUCCESS;
	}
}
