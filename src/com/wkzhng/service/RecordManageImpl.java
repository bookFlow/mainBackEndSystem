package com.wkzhng.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.wkzhng.constv.Const;
import com.wkzhng.dao.IBookDao;
import com.wkzhng.dao.IRecordDao;
import com.wkzhng.entity.Record;

public class RecordManageImpl implements IRecordManage{
	
	@Resource
	IRecordDao recordDao;
	
	@Resource
	IBookDao bookDao;
	
	public IBookDao getBookDao() {
		return bookDao;
	}
	
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public IRecordDao getRecordDao() {
		return recordDao;
	}
	
	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	@Override
	public String addRecord(String userName, int bookId, long time, double x, double y, String pname){
		System.out.println("RecordManageImpl is working...addRecord");
				bookDao.change_book_status(bookId, 2);
		return recordDao.addRecord(userName, bookId, time, x, y, pname);
	}
	
	@Override
	public List<Record> getBuyedBooks(String userName){
		System.out.println("RecordManageImpl is working...getBuyedBooks");
		List<Record> records = recordDao.getBuyedBooks(userName);
		return records;
	}
	
	@Override
	public List<Record> getBuyingBooks(String userName){
		System.out.println("RecordManageImpl is working...getBuyingBooks");
		List<Record> records = recordDao.getBuyingBooks(userName);
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
			else if(dealed == 1){
				
				records.addAll(recordDao.getBuyerRecord(uid, 5));
			}
			else{
				records.addAll(recordDao.getBuyerRecord(uid, 4));
			}
		}
		else{
			if(dealed == -1){
				records.addAll(recordDao.getSellerRecord(uid, 0));
				records.addAll(recordDao.getSellerRecord(uid, 1));
				records.addAll(recordDao.getSellerRecord(uid, 2));
				records.addAll(recordDao.getSellerRecord(uid, 3));
			}
			else if(dealed == 1){
				
				records.addAll(recordDao.getSellerRecord(uid, 5));
			}
			else{
				records.addAll(recordDao.getSellerRecord(uid, 4));
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
			else if(type == 1){
				result = recordDao.whereSet(rid);
			}
			else if(type == 2){
				result = recordDao.confirmBuy(rid);
				bookDao.change_book_status(recordDao.getRecord(rid).getBookid(), 1);
			}
			else if(type == 3){
				result = recordDao.reBook(rid);
				bookDao.change_book_status(recordDao.getRecord(rid).getBookid(), 2);
			}
		}
		else{
			if(type == 0){
				result = recordDao.whenDel(rid);
			}
			else if(type == 1){
				result = recordDao.whereDel(rid);
			}
			else if(type == 2){
				result = recordDao.confirmNotBuy(rid);
				bookDao.change_book_status(recordDao.getRecord(rid).getBookid(), 0);
			}
		}
		return result;
	}
	
	@Override
	public Record getRecordByBookIdAndBid(String uid, int bid){
		System.out.println("RecordManageImpl is working...getRecordByBookIdAndBid");
		return recordDao.getRecordByBookIdAndBid(uid, bid);
	}
}
