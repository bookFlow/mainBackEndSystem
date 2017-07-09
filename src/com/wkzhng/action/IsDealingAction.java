package com.wkzhng.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IRecordManage;

public class IsDealingAction implements Action{
	
	@Resource
	IRecordManage recordManage;
	
	String bid;
	
	Map<String, Object> dataMap;
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
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
		System.out.println("IsDealingAction is working...");
		dataMap = new HashMap<>();
		int status = 0;
		Record record = recordManage.getRecordById(Integer.parseInt(bid));
		if(record == null){
			dataMap.put("candeal", true);
			dataMap.put("isInYourDeal", false);
		}
		else{
		status = record.getStatus();
			if(status == 4){
				dataMap.put("candeal", true);
				dataMap.put("isInYourDeal", false);
			}
			else if(status == 5){
				dataMap.put("candeal", false);
				dataMap.put("isInYourDeal", false);
			}
			else{
				dataMap.put("candeal", false);
				dataMap.put("isInYourDeal", true);
			}
		}
		return SUCCESS;
	}
}
