package com.wkzhng.action;

import java.util.ArrayList;
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

public class SearchBooksByPositionAction implements Action{
	
	@Resource
	private IBookManage bookManage;
	
	@Resource
	private IPeopleManage peopleManage;
	
	private String x;
	private String y;
	private String scop;
	private Map<String, Object> dataMap;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public String getScop() {
		return scop;
	}
	
	public void setScop(String scop) {
		this.scop = scop;
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
	
	@Override
	public String execute(){
		System.out.println("SearchBooksByPositionAction is working");
		dataMap = new HashMap<>();
		List<Book> books = bookManage.getBooks(Double.parseDouble(x), Double.parseDouble(y),
				Double.parseDouble(scop));
		List<Map<String, Object>> bookMaps = new ArrayList<>();
		for(Book book: books){
			Map<String, Object> bookMap = new HashMap<>();
			bookMap.put("bid", book.getId());
			bookMap.put("name", book.getName());
			PeopleDetails peopleDetails = peopleManage.getPeopleDetailInfo(book.getPeople().getUserName());
			bookMap.put("uname", peopleDetails.getName());
			bookMap.put("uid", peopleDetails.getPeopleUserName());
			bookMap.put("x", book.getX());
			bookMap.put("y", book.getY());
			BookDetails bookDetails = bookManage.getBookDetailsInfo(book.getId());
			Map<String, Object> det = new HashMap<>();
			det.put("des", bookDetails.getDescription());
			det.put("productor", bookDetails.getEditor());
			det.put("company", bookDetails.getPublishingCompany());
			det.put("price", bookDetails.getPrice());
			//det.put("image", bookDetails.getImages());
			det.put("images", JSONArray.fromObject(new ArrayList<Map<String, Object>>()));
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
