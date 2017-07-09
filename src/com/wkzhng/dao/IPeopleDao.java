package com.wkzhng.dao;

import java.util.List;

import com.wkzhng.entity.Book;

public interface IPeopleDao {
	public String check_userName_password(String userName, String password);
	public String add_userName_password(String newUserName, String newPassword);
	public String check_userName(String userName);
	public String change_password(String userName, String newPassword);
	public List<Book> getBookListByUserName(String userName);
}
