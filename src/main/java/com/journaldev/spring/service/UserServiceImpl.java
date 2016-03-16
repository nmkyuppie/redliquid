package com.journaldev.spring.service;

import java.util.List;
import java.util.Map;

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
	public Map listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public Map search(User u) {
		return this.userDAO.search(u);
	}

	@Override
	@Transactional
	public List<User> getSearchList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize) {

		return  this.userDAO.getSearchList(bloodGroup,stateName,districtName,cityName,pageNo,pageSize);
	}

	@Override
	@Transactional
	public Integer getTotalCount(String bloodGroup, String stateName, String districtName,
			String cityName, String pageNo, String pageSize) {
		return this.userDAO.getTotalCount(bloodGroup,stateName,districtName,cityName,pageNo,pageSize);
	}

	@Override
	@Transactional
	public User getUserDetail(String email) {
		return this.userDAO.getUserDetail(email);
	}

}
