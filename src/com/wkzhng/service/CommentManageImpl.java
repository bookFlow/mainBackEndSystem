package com.wkzhng.service;

import javax.annotation.Resource;

import com.wkzhng.dao.ICommentDao;

public class CommentManageImpl implements ICommentManage{
	
	@Resource 
	ICommentDao commentDao;
	
	public ICommentDao getCommentDao() {
		return commentDao;
	}
	
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public String addComment(String userName, int bookId, String comment){
		System.out.println("CommentManageImpl is working...addComment");
		return commentDao.addComment(userName, bookId, comment);
	}
}
