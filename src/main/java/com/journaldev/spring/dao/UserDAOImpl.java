package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
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
				.createQuery("from User where email=? and password=?")
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
	public Map listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Map map=new HashMap();
		List<User> usersList = session.createQuery("from User where availability='true' order by id desc").setMaxResults(10).list();
		for(User u : usersList){
			logger.info("Person List::"+u);
		}
		//		Collections.reverse(usersList);
		map.put("usersList", usersList);
		int totalCount=session.createQuery("from User where availability='true' order by id desc").list().size();
		map.put("totalCount", totalCount);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map search(User u) {

		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList=null;
		Map map=new HashMap();

		if(u.getBloodgroup()==null&&u.getStatename()==null&&u.getDistrictname()==null&&u.getTalukname()==null){
			usersList = session.createQuery("from User where availability='true'").list();
			map.put("usersList", usersList);
			int totalCount=session.createQuery("from User where availability='true'").list().size();
			map.put("totalCount", totalCount);
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()==null&&u.getDistrictname()==null&&u.getTalukname()==null){
			usersList = session.createQuery("from User where bloodgroup=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.list();
			map.put("usersList", usersList);
			int totalCount=session.createQuery("from User where bloodgroup=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.list().size();
			map.put("totalCount", totalCount);
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()!=null&&u.getDistrictname()==null&&u.getTalukname()==null){
			usersList = session.createQuery("from User where bloodgroup=? and statename=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list();
			map.put("usersList", usersList);
			int totalCount=session.createQuery("from User where bloodgroup=? and statename=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list().size();
			map.put("totalCount", totalCount);
		}
		else if(u.getBloodgroup()!=null&&u.getStatename()!=null&&u.getDistrictname()!=null&&u.getTalukname()==null){
			usersList = session.createQuery("from User where bloodgroup=? and statename=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list();
			map.put("usersList", usersList);
			int totalCount=session.createQuery("from User where bloodgroup=? and statename=? and availability='true'")
					.setParameter(0, u.getBloodgroup())
					.setParameter(1, u.getStatename())
					.list().size();
			map.put("totalCount", totalCount);
		}
		else {
			usersList = session.createQuery("from User")
					.list();
			map.put("usersList", usersList);
			int totalCount=session.createQuery("from User").list().size();
			map.put("totalCount", totalCount);
		}
		for(User user : usersList){
			logger.info("Person List::"+user);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getSearchList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize) {

		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList=null;
		int pageno=Integer.parseInt(pageNo);
		int pagesize=Integer.parseInt(pageSize);

		if(bloodGroup.equals("-1")&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query=session.createSQLQuery("select * from users where availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and districtname=? and availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName!=null){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and districtname=? and cityname=? and availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName)
					.setParameter(3, cityName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}
		else {
			Query query=session.createSQLQuery("select * from users where availability='true' order by id desc limit :limit offset :offset")
					.addEntity(User.class)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			usersList = query.list();
		}

		return usersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getTotalCount(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize) {

		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList=null;

		if(bloodGroup.equals("-1")&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query=session.createSQLQuery("select * from users where availability='true'")
					.addEntity(User.class);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and availability='true'")
					.addEntity(User.class)
					.setParameter(0, bloodGroup);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and availability='true'")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and districtname=? and availability='true'")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName);
			usersList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName!=null){
			Query query = session.createSQLQuery("select * from users where bloodgroup=? and statename=? and districtname=? and cityname=? and availability='true'")
					.addEntity(User.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName)
					.setParameter(3, cityName);
			usersList = query.list();
		}
		else {
			Query query=session.createSQLQuery("select * from users where availability='true'")
					.addEntity(User.class);
			usersList = query.list();
		}

		return new Integer(usersList.size());
	}

	@Override
	public User getUserDetail(String email) {

		User user = null;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select * from users where email=?").addEntity(User.class).setParameter(0, email);
		return (User) query.list().get(0);
	}
}
