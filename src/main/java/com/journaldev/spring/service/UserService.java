package com.journaldev.spring.service;

import java.util.List;
import java.util.Map;

import com.journaldev.spring.model.User;

public interface UserService {

	public void addUser(User u);

	public boolean validate(User ud);

	public Map listUsers();

	public Map search(User u);

	public Object getSearchList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize);

	public Integer getTotalCount(String trim, String trim2, String trim3,
			String trim4, String pageNo, String pageSize);

	public User getUserDetail(String email);
}
