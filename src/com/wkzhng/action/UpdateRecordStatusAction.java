package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.constv.Const;
import com.wkzhng.service.IRecordManage;

public class UpdateRecordStatusAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	
	String rid;
	String operation;
	String type;
	
	Map<String, Object> dataMap;
	
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getRid() {
		return rid;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
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
	
	@Override
	public String execute(){
		System.out.println("UpdateRecordStatusAction is working...");
		dataMap = new HashMap<>();
		String result = recordManage.updateStatus(Integer.parseInt(rid), Integer.parseInt(operation), 
				Integer.parseInt(type));
		if(result.equals(Const.SUCCEED))
			dataMap.put("isSucceed", true);
		else
			dataMap.put("isSucceed", false);
		dataMap.put("newStatus", recordManage.getRecordById(Integer.parseInt(rid)).getStatus());
		return SUCCESS;
	}
}
