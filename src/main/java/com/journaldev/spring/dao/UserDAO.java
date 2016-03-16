package com.journaldev.spring.dao;

import java.util.List;
import java.util.Map;

import com.journaldev.spring.model.User;

public interface UserDAO {
	public void addUser(User u);

	public boolean validate(User u);

	public Map listUsers();

	public Map search(User u);

	public List<User> getSearchList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize);

	public Integer getTotalCount(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize);

	public User getUserDetail(String email);
}
