package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.RequestDAO;
import com.journaldev.spring.model.Request;

@Service
public class RequestServiceImpl implements RequestService	{

	private RequestDAO requestDAO;

	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}
	
	@Override
	@Transactional
	public void addRequest(Request r) {
		this.requestDAO.addRequest(r);
	}

	@Override
	@Transactional
	public List<Request> listRequests() {
		return this.requestDAO.listRequests();
	}

	@Override
	@Transactional
	public Object getRequestsList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize) {
		return this.requestDAO.getRequestsList(bloodGroup.trim(),stateName.trim(),districtName.trim(),cityName.trim(),pageNo,pageSize);
	}

}
