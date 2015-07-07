package com.journaldev.spring.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Request;
import com.journaldev.spring.model.User;

@Repository
public class RequestDAOImpl implements RequestDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addRequest(Request r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Request> listRequests() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Request> requestsList = session.createQuery("from Request").list();
		Collections.reverse(requestsList);
		for(Request u : requestsList){
			logger.info("Person List::"+u.getPatientname());
		}
		return requestsList;
	}

}
