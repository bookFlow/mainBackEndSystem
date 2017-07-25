package com.wkzhng.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.BookDetails;
import com.wkzhng.entity.Comment;
import com.wkzhng.entity.PeopleDetails;
import com.wkzhng.entity.Record;
import com.wkzhng.service.IBookManage;
import com.wkzhng.service.IPeopleManage;
import com.wkzhng.service.IRecordManage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchBooksByRecordAction implements Action{
	
	@Resource
	private IRecordManage recordManage;
	
	@Resource
	private IPeopleManage peopleManage;
	
	@Resource
	private IBookManage bookManage;
	
	private String uid;
	private String type;
	private Map<String, Object> dataMap;
	
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
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	@Override
	public String execute(){
		System.out.println("SearchBooksByRecordAction is working");
		dataMap = new HashMap<>();
		List<Book> resultBooks = new ArrayList<>();
		List<Date> resultTime = new ArrayList<>();
		if(type.equals("1")){
			List<Record> records = recordManage.getBuyedBooks(uid);
			for(Record record: records){
				resultBooks.add(bookManage.getBookById(record.getBookid()));
				resultTime.add(new Date(record.getDateOk().getTime()));
			}
		}
		else if(type.equals("2")){
			List<Book> hasBooks = peopleManage.getBooks(uid);
			for(Book book: hasBooks){
				if(book.getStatus() == 2){
					resultBooks.add(book);
				}
			}
		}
		else if(type.equals("3")){
			List<Book> hasBooks = peopleManage.getBooks(uid);
			for(Book book: hasBooks){
				if(book.getStatus() != 2){
					resultBooks.add(book);
				}
			}
		}
		else if(type.equals("4")){
			List<Record> records = recordManage.getBuyingBooks(uid);
			for(Record record: records){
				resultBooks.add(bookManage.getBookById(record.getBookid()));
				resultTime.add(new Date(record.getDateOk().getTime()));
			}
		}
		
		List<Map<String, Object>> bookMaps = new ArrayList<>();
		for(Book book: resultBooks){
			Map<String, Object> bookMap = new HashMap<>();
			bookMap.put("bid", book.getId());
			bookMap.put("name", book.getName());
			PeopleDetails peopleDetails = peopleManage.getPeopleDetailInfo(book.getPeople().getUserName());
			bookMap.put("uname", peopleDetails.getName());
			bookMap.put("uid", peopleDetails.getPeopleUserName());
			if(type.equals("1")){
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String sTime = dateFormat.format(resultTime.get(resultBooks.indexOf(book)));
				bookMap.put("time", sTime);
			}
			bookMap.put("x", book.getX());
			bookMap.put("y", book.getY());
			BookDetails bookDetails = bookManage.getBookDetailsInfo(book.getId());
			Map<String, Object> det = new HashMap<>();
			det.put("des", bookDetails.getDescription());
			det.put("productor", bookDetails.getEditor());
			det.put("company", bookDetails.getPublishingCompany());
			det.put("price", bookDetails.getPrice());
			det.put("images", bookDetails.getImages());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			det.put("date", dateFormat.format(new Date(book.getDate().getTime())));
			JSONObject detJson = JSONObject.fromObject(det);
			bookMap.put("det", detJson);
			List<Map<String, Object>> comts = new ArrayList<>();
			List<Comment> commentList = bookManage.getComments(book.getId());
			for(Comment comment: commentList){
				Map<String, Object> commentMap = new HashMap<>();
				String commentUserName = comment.getId().getPeople().getUserName();
				PeopleDetails commentPeopleDetails = peopleManage.getPeopleDetailInfo(commentUserName);
				commentMap.put("uid", commentUserName);
				commentMap.put("uname", commentPeopleDetails.getName());
				commentMap.put("content", comment.getComment());
				comts.add(commentMap);
			}
			JSONArray comtsJson = JSONArray.fromObject(comts);
			bookMap.put("comt", comtsJson);
			bookMaps.add(bookMap);
		}
		JSONArray bookMapsJson = JSONArray.fromObject(bookMaps);
		dataMap.put("list", bookMapsJson);
		return SUCCESS;
	}
}
