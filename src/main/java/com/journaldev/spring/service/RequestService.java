package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Request;

public interface RequestService {

	void addRequest(Request r);

	List<Request> listRequests();

}
