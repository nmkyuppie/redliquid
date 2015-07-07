package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.User;

public interface UserDAO {
	public void addUser(User u);

	public boolean validate(User u);

	public List<User> listUsers();

	public List<User> search(User u);
}
