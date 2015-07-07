package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.User;

public interface UserService {

	public void addUser(User u);

	public boolean validate(User ud);

	public List<User> listUsers();

	public List<User> search(User u);
}
