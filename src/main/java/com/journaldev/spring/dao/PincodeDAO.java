package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Pincode;

public interface PincodeDAO {

	public List<Pincode> listStates();

	public List<Pincode> getDistrict(String state);

	public List<Pincode> getCity(String district);

}
