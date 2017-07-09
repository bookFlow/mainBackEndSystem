package com.wkzhng.service;

public interface IUserManage {
	public String check_user_login(String userName, String password);
	public String add_user_register(String userName, String password);
}
