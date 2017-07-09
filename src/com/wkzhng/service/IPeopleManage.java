package com.wkzhng.service;

import java.util.List;

import com.wkzhng.entity.Book;
import com.wkzhng.entity.PeopleDetails;

public interface IPeopleManage {
	public PeopleDetails getPeopleDetailInfo(String userName);
	public List<PeopleDetails> getPeopleDetails(String peopleName);
	public String modifyMoney(String type, String userName, Double money);
	public Double getMoney(String userName);
	public List<Book> getBooks(String userName);
	public String addPeople(String userName);
}
