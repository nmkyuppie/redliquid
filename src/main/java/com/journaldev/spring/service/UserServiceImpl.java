package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.User;

@Service
public class UserServiceImpl implements UserService{

	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public boolean validate(User u) {
		boolean isSuccess=this.userDAO.validate(u);
		return isSuccess;
		
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public List<User> search(User u) {
		return this.userDAO.search(u);
	}

}
