package com.journaldev.spring.dao;

import java.awt.Window;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Pincode;

@Repository
public class PincodeDAOImpl implements PincodeDAO{
	private static final Logger logger = LoggerFactory.getLogger(PincodeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Pincode> listStates() {
		Session session = this.sessionFactory.getCurrentSession();

//		List<Pincode> statesList = session.createQuery("from Pincode where statename='TAMIL NADU'").list();
		List<Pincode> statesList = session.createSQLQuery("select distinct statename from Pincode and statename <> ''").list();
		Set<Pincode> uList=new HashSet<Pincode>(statesList);
		

				
		//		List<Pincode> statesList = cr.list();
		
		
//		Criteria crit = session.createCriteria(Pincode.class)
//				.setProjection(Projections.projectionList().add(Projections.property("statename"), "statename"));
//		crit.setResultTransformer( DistinctRootEntityResultTransformer.INSTANCE );
//		List<Pincode> statesList = crit.list();
	/*	logger.info("states List::"+statesList.size()+"\n state "+statesList.get(0));
		for(int i=0;i<statesList.size();i++){
		logger.info("::"+statesList.get(i));
	}
//		for(Pincode p : statesList){
//			logger.info("states List::"+p);
//		}
		logger.info("ulis::"+uList.size());*/
		return statesList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Pincode> getDistrict(String state) {
		Session session = this.sessionFactory.getCurrentSession();

		List<Pincode> districtList = session.createSQLQuery("select distinct districtname from Pincode where statename=? and districtname <> ''").setParameter(0, state).list();
//		@SuppressWarnings("unchecked")
//		List<Pincode> districtList = session.createQuery("from Pincode where statename=?").setParameter(0, state).set.list();
		TreeSet<Pincode> set = new TreeSet<Pincode>(districtList);
		
		List<Pincode> sortedList=new ArrayList<Pincode>(set);
		
		logger.info("uniq::"+districtList.size());
		return sortedList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Pincode> getCity(String district) {
		Session session = this.sessionFactory.getCurrentSession();

		List<Pincode> cityList = session.createSQLQuery("select distinct taluk from Pincode where districtname=? and taluk <> ''").setParameter(0, district.trim()).list();
		System.out.println("quey "+cityList.size());
//		@SuppressWarnings("unchecked")
//		List<Pincode> districtList = session.createQuery("from Pincode where statename=?").setParameter(0, state).set.list();
		TreeSet<Pincode> set = new TreeSet<Pincode>(cityList);
		
		List<Pincode> sortedList=new ArrayList<Pincode>(set);
		

		logger.info("check it : : "+sortedList.toString());
		return sortedList;
	}

}
