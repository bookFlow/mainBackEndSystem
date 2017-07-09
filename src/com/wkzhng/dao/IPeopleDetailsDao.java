package com.wkzhng.dao;

import java.util.List;

import com.wkzhng.entity.PeopleDetails;

public interface IPeopleDetailsDao {
	public PeopleDetails getPeopleDetailsInfo(String userName);
	public String addPeopleDetailsInfo(PeopleDetails peopleDetails);
	public List<PeopleDetails> search_people_by_name(String searchInfo);
	public String decreaseMoney(String userName, Double money);
	public Double getMoney(String userName);
}
