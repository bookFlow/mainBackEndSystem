package com.wkzhng.service;

import java.util.List;

import javax.annotation.Resource;

import com.wkzhng.constv.Const;
import com.wkzhng.dao.IPeopleDao;
import com.wkzhng.dao.IPeopleDetailsDao;
import com.wkzhng.entity.Book;
import com.wkzhng.entity.PeopleDetails;

public class PeopleManageImpl implements IPeopleManage{
	@Resource(name="peopleDao")
	private IPeopleDao peopleDao;
	
	@Resource(name="peopleDetailsDao")
	private IPeopleDetailsDao peopleDetailsDao;
	
	public IPeopleDao getPeopleDao() {
		return peopleDao;
	}
	
	public void setPeopleDao(IPeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public IPeopleDetailsDao getPeopleDetailsDao() {
		return peopleDetailsDao;
	}
	
	public void setPeopleDetailsDao(IPeopleDetailsDao peopleDetailsDao) {
		this.peopleDetailsDao = peopleDetailsDao;
	}
	
	@Override
	public PeopleDetails getPeopleDetailInfo(String userName){
		System.out.println("peopleManageImpl is working...getPeopleDetailInfo");
		PeopleDetails peopleDetails = peopleDetailsDao.getPeopleDetailsInfo(userName);
		return peopleDetails;
	}
	
	@Override
	public List<PeopleDetails> getPeopleDetails(String peopleName){
		System.out.println("peopleManageImpl is working...getPeopleDetails");
		List<PeopleDetails> peopleDetails = peopleDetailsDao.search_people_by_name(peopleName);
		return peopleDetails;
	}
	
	@Override
	public String modifyMoney(String type, String userName, Double money){
		System.out.println("peopleManageImpl is working...modifyMoney");
		if(type.equals("+")){
			return Const.SUCCEED;
		}
		else if(type.equals("-")){
			return peopleDetailsDao.decreaseMoney(userName, money);
		}
		else
			return Const.FAIL;
	}
	
	@Override
	public Double getMoney(String userName){
		System.out.println("peopleManageImpl is working...getMoney");
		return peopleDetailsDao.getMoney(userName);
	}
	
	@Override
	public List<Book> getBooks(String userName){
		System.out.println("peopleManageImpl is working...getBooks");
		List<Book> resultList = peopleDao.getBookListByUserName(userName);
		return resultList;
	}
	
	@Override
	public String addPeople(String userName){
		System.out.println("peopleManageImpl is working...addPeople");
		PeopleDetails peopleDetails = new PeopleDetails(userName, "", true, 0, 100, 0.0);
		return peopleDetailsDao.addPeopleDetailsInfo(peopleDetails);
	}
}
