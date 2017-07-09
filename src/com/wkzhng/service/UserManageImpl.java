package com.wkzhng.service;

import javax.annotation.Resource;

import com.wkzhng.constv.Const;
import com.wkzhng.dao.IPeopleDao;

public class UserManageImpl implements IUserManage{
	@Resource
	private IPeopleDao peopleDao;
	
	public IPeopleDao getPeopleDao() {
		return peopleDao;
	}
	
	public void setPeopleDao(IPeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	@Override
	public String check_user_login(String userName, String password){
		System.out.println("UserManageImpl is working...check_user_login");
		String userNameExisted = peopleDao.check_userName(userName);
		if(userNameExisted.equals(Const.EXSITED)){
			String result = peopleDao.check_userName_password(userName, password);
			return result;
		}
		else{
			return Const.FAIL;
		}
	}
	
	@Override
	public String add_user_register(String userName, String password){
		System.out.println("UserManageImpl is working...add_user_register");
		String userNameExisted = peopleDao.check_userName(userName);
		if(userNameExisted.equals(Const.EXSITED)){
			return Const.FAIL;
		}
		else{
			String result = peopleDao.add_userName_password(userName, password);
			return result;
		}
	}
}
