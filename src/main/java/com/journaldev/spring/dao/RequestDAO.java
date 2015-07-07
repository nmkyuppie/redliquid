package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Request;

public interface RequestDAO {

	void addRequest(Request r);

	List<Request> listRequests();

}
