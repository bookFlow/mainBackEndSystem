package com.wkzhng.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.wkzhng.constv.Const;
import com.wkzhng.dao.IRecordDao;
import com.wkzhng.entity.Record;

public class RecordManageImpl implements IRecordManage{
	
	@Resource
	IRecordDao recordDao;

	public IRecordDao getRecordDao() {
		return recordDao;
	}
	
	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	@Override
	public String addRecord(String userName, int bookId, long time, double x, double y, String pname){
		System.out.println("RecordManageImpl is working...addRecord");
		return recordDao.addRecord(userName, bookId, time, x, y, pname);
	}
	
	@Override
	public List<Record> getBuyedBooks(String userName){
		System.out.println("RecordManageImpl is working...getBuyedBooks");
		List<Record> records = recordDao.getBuyedBooks(userName);
		return records;
	}
	
	@Override
	public List<Record> getRecordsByTypeAndStatus(String uid, int type, int dealed){
		System.out.println("RecordManageImpl is working...getRecordsByTypeAndStatus");
		List<Record> records = new ArrayList<>();
		if(type == 0){
			if(dealed == -1){
				records.addAll(recordDao.getBuyerRecord(uid, 0));
				records.addAll(recordDao.getBuyerRecord(uid, 1));
				records.addAll(recordDao.getBuyerRecord(uid, 2));
				records.addAll(recordDao.getBuyerRecord(uid, 3));
			}
			else{
				records.addAll(recordDao.getBuyerRecord(uid, 4));
				records.addAll(recordDao.getBuyerRecord(uid, 5));
			}
		}
		else{
			if(dealed == -1){
				records.addAll(recordDao.getSellerRecord(uid, 0));
				records.addAll(recordDao.getSellerRecord(uid, 1));
				records.addAll(recordDao.getSellerRecord(uid, 2));
				records.addAll(recordDao.getSellerRecord(uid, 3));
			}
			else{
				records.addAll(recordDao.getSellerRecord(uid, 4));
				records.addAll(recordDao.getSellerRecord(uid, 5));
			}
		}
		return records;
	}
	
	@Override
	public Record getRecordById(int rid){
		System.out.println("RecordManageImpl is working...getRecordById");
		return recordDao.getRecord(rid);
	}
	
	@Override
	public String updateStatus(int rid, int operation, int type){
		System.out.println("RecordManageImpl is working...updateStatus");
		String result = Const.FAIL;
		if(operation == 0){
			if(type == 0){
				result = recordDao.whenSet(rid);
			}
			else{
				result = recordDao.whereSet(rid);
			}
		}
		else{
			if(type == 0){
				result = recordDao.whenDel(rid);
			}
			else{
				result = recordDao.whereDel(rid);
			}
		}
		return result;
	}
}
