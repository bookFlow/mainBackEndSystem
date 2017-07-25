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
import com.wkzhng.service.IBookManage;
import com.wkzhng.service.IPeopleManage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchBookByBookIdAction implements Action{
	@Resource
	private IBookManage bookManage;
	
	@Resource
	private IPeopleManage peopleManage;
	
	private String bid;
	Map<String, Object> dataMap;
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public IPeopleManage getPeopleManage() {
		return peopleManage;
	}
	
	public void setPeopleManage(IPeopleManage peopleManage) {
		this.peopleManage = peopleManage;
	}
	
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
	
	@Override
	public String execute(){
		System.out.println("SearchBooksByBookNameAction is working");
		dataMap = new HashMap<>();
		Book book = bookManage.getBookById(Integer.parseInt(bid));
		dataMap.put("bid", book.getId());
		dataMap.put("name", book.getName());
		PeopleDetails peopleDetails = peopleManage.getPeopleDetailInfo(book.getPeople().getUserName());
		dataMap.put("uname", peopleDetails.getName());
		dataMap.put("uid", peopleDetails.getPeopleUserName());
		dataMap.put("x", book.getX());
		dataMap.put("y", book.getY());
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
		dataMap.put("det", detJson);
		List<Map<String, Object>> comts = new ArrayList<>();
		List<Comment> commentList = bookManage.getComments(Integer.parseInt(bid));
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
		dataMap.put("comt", comtsJson);
		return SUCCESS;
	}
}
