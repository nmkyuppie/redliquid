package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Pincode;

public interface PincodeService {

	public List<Pincode> listStates();

	public List<Pincode> getDistrict(String state);

	public List<Pincode> getCity(String district);
}
