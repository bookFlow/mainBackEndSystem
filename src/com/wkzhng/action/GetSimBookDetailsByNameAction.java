package com.wkzhng.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.BookDetails;
import com.wkzhng.service.IBookManage;

import net.sf.json.JSONArray;

public class GetSimBookDetailsByNameAction implements Action{
	@Resource
	private IBookManage bookManage;
	
	private String name;
	Map<String, Object> dataMap;
	
	public IBookManage getBookManage() {
		return bookManage;
	}
	
	public void setBookManage(IBookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public String execute(){
		System.out.println("GetSimBookDetailsByNameAction is working");
		dataMap = new HashMap<>();
		List<Book> books = bookManage.getBooks(name);
		List<Map<String, Object>> bookMaps = new ArrayList<>();
		for(Book book: books){
			Map<String, Object> bookMap = new HashMap<>();
			BookDetails bookDetails = bookManage.getBookDetailsInfo(book.getId());
			bookMap.put("des", bookDetails.getDescription());
			bookMap.put("productor", bookDetails.getEditor());
			bookMap.put("company", bookDetails.getPublishingCompany());
			bookMap.put("price", bookDetails.getPrice());
			//bookMap.put("image", bookDetails.getImages());
			bookMap.put("images", JSONArray.fromObject(new ArrayList<Map<String, Object>>()));
			bookMaps.add(bookMap);
		}
		JSONArray bookMapsJson = JSONArray.fromObject(bookMaps);
		dataMap.put("list", bookMapsJson);
		return SUCCESS;
	}
}
