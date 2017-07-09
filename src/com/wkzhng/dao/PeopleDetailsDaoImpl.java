package com.wkzhng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wkzhng.constv.Const;
import com.wkzhng.entity.PeopleDetails;

public class PeopleDetailsDaoImpl implements IPeopleDetailsDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public PeopleDetails getPeopleDetailsInfo(String userName){
		System.out.println("PeopleDetailsDaoImpl is working...getPeopleDetailsInfo");
		Session session = getSessionFactory().getCurrentSession();
		PeopleDetails peopleDetails = (PeopleDetails)session.load(PeopleDetails.class, userName);
		return peopleDetails;
	}
	
	@Override
	public String addPeopleDetailsInfo(PeopleDetails peopleDetails){
		System.out.println("PeopleDetailsDaoImpl is working...addPeopleDetailsInfo");
		Session session = getSessionFactory().getCurrentSession();
		session.save(peopleDetails);
		return Const.SUCCEED;
	}
	
	@Override
	public List<PeopleDetails> search_people_by_name(String searchInfo){
		System.out.println("PeopleDetailsDaoImpl is working...search_people_by_name");
		Session session = getSessionFactory().getCurrentSession();
		String sql = "select * from `people details` where `people details`.name = '" + searchInfo + "'";
		@SuppressWarnings("unchecked")
		List<PeopleDetails> peopleDetails = session.createSQLQuery(sql).addEntity(PeopleDetails.class).list();
		return peopleDetails;
	}
	
	@Override
	public String decreaseMoney(String userName, Double money){
		System.out.println("PeopleDetailsDaoImpl is working...decreaseMoney");
		Session session = getSessionFactory().getCurrentSession();
		PeopleDetails peopleDetails = (PeopleDetails)session.load(PeopleDetails.class, userName);
		if(peopleDetails.getMoney() < money)
			return Const.FAIL;
		else{
			peopleDetails.setMoney(peopleDetails.getMoney() - money);
			session.update(peopleDetails);
			return Const.SUCCEED;
		}
	}
	
	@Override
	public Double getMoney(String userName){
		System.out.println("PeopleDetailsDaoImpl is working...getMoney");
		Session session = sessionFactory.getCurrentSession();
		PeopleDetails peopleDetails = (PeopleDetails)session.load(PeopleDetails.class, userName);
		return peopleDetails.getMoney();
	}
}
