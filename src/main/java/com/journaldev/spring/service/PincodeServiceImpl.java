package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PincodeDAO;
import com.journaldev.spring.model.Pincode;

@Service
public class PincodeServiceImpl implements PincodeService{
	
	
	private PincodeDAO pincodeDAO;
	
	public void setPincodeDAO(PincodeDAO pincodeDAO) {
		this.pincodeDAO = pincodeDAO;
	}

	@Override
	@Transactional
	public List<Pincode> listStates() {
		return this.pincodeDAO.listStates();
	}

	@Override
	@Transactional
	public List<Pincode> getDistrict(String state) {
		return this.pincodeDAO.getDistrict(state);
	}

	@Override
	@Transactional
	public List<Pincode> getCity(String district) {
		return this.pincodeDAO.getCity(district);
	}

}
