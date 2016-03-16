package com.journaldev.spring.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Request;

@Repository
public class RequestDAOImpl implements RequestDAO{

	private static final Logger logger = LoggerFactory.getLogger(RequestDAOImpl.class);

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


	@Override
	public Object getRequestsList(String bloodGroup, String stateName,
			String districtName, String cityName, String pageNo, String pageSize) {

		Session session = this.sessionFactory.getCurrentSession();
		List<Request> requestsList=null;
		int pageno=Integer.parseInt(pageNo);
		int pagesize=Integer.parseInt(pageSize);

		if(bloodGroup.equals("-1")&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query=session.createSQLQuery("select * from bloodrequest order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		else if(bloodGroup!=null&&stateName.equals("-1")&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from bloodrequest where bloodgroup=? order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter(0, bloodGroup)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName.equals("-1")&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from bloodrequest where bloodgroup=? and statename=? order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName.equals("-1")){
			Query query = session.createSQLQuery("select * from bloodrequest where bloodgroup=? and statename=? and districtname=? order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		else if(bloodGroup!=null&&stateName!=null&&districtName!=null&&cityName!=null){
			Query query = session.createSQLQuery("select * from bloodrequest where bloodgroup=? and statename=? and districtname=? and cityname=? order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter(0, bloodGroup)
					.setParameter(1, stateName)
					.setParameter(2, districtName)
					.setParameter(3, cityName)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		else {
			Query query=session.createSQLQuery("select * from bloodrequest order by code desc limit :limit offset :offset")
					.addEntity(Request.class)
					.setParameter("limit", pagesize)
					.setParameter("offset", (pageno-1)*10);
			requestsList = query.list();
		}
		
		System.out.println(" Req "+requestsList.size());

		return requestsList;
	}

}
