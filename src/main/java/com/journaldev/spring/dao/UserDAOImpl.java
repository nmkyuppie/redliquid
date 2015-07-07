package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("user saved successfully, user Details="+u);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean validate(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean isSuccess;
		//		isSuccess=session.createQuery("from Person").getMaxResults()
		//		System.out.println(""+session.contains(u));

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
				.createQuery("from User where name=? and password=?")
				.setParameter(0, u.getUsername()).setParameter(1, u.getPassword())
				.list();

		if (users.size() > 0) {
			isSuccess=true;
		} else {
			isSuccess=false;
		}
		return isSuccess;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for(User u : usersList){
			logger.info("Person List::"+u);
		}
		Collections.reverse(usersList);
		return usersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> search(User u) {
		System.out.println("Hi "+u.getStatename());

		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList=null;

		/*
		List<User> usersList = session.createQuery("from User where bloodgroup=? and statename=? and districtname=? and talukname=?")
				.setParameter(0, u.getBloodgroup())
				.setParameter(1, u.getStatename())
				.setParameter(2, u.getDistrictname())
				.setParameter(3, u.getTalukname()).list();
		 */
		if(u.getBloodgroup()==null&&u.getStatename()==null&&u.getDistrictname()==null&&u.getTalukname()==null){
			System.out.println("yes");
			usersList = session.createQuery("from User").list();
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()==null&&u.getDistrictname()==null&&u.getTalukname()==null){
			System.out.println("yes1");
			usersList = session.createQuery("from User where bloodgroup=?")
					.setParameter(0, u.getBloodgroup())
					.list();
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()!=null&&u.getDistrictname()==null&&u.getTalukname()==null){
			System.out.println("yes1");
			usersList = session.createQuery("from User where bloodgroup=? and statename=?")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list();
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()!=null&&u.getDistrictname()!=null&&u.getTalukname()==null){
			System.out.println("yes1");
			usersList = session.createQuery("from User where bloodgroup=? and statename=?")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list();
		}
		else {
			System.out.println("yes2");
			usersList = session.createQuery("from User")
					.list();
		}
		for(User user : usersList){
			logger.info("Person List::"+user);
		}
		return usersList;
	}

}
