package com.plq.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.plq.model.Insurance;
import com.plq.model.Insurance_Car;
import com.plq.util.HibernateUtil;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	SessionFactory sessionFactory;
	
	

	public InsuranceServiceImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> getAllInsurance() {
		List<Insurance> insList= null;
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			String hql = "from Insurance";
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery(hql);
			insList = query.list();
			
			
			currentSession.getTransaction().commit();
			currentSession.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return insList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> getAvaiInsurance() {
		List<Insurance> insAvaiList = null;
		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			String hql ="from Insurance where name not in (select ci.insurance.name from Insurance_Car ci inner join ci.insurance)";
		

			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery(hql);
			insAvaiList = query.list();
			
			currentSession.getTransaction().commit();
			currentSession.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return insAvaiList;
	}

	@Override
	public String addIns(Insurance insurance) {
		String t="";
		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			t = (String) currentSession.save(insurance);
			
			currentSession.getTransaction().commit();
			currentSession.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return t;
	}

	@Override
	public Insurance editIns(String insName, String insType) {
		Insurance currentInsurance= null;
		
		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			currentInsurance = currentSession.find(Insurance.class, insName);
			currentInsurance.setType(insType);
			currentSession.update(currentInsurance);
			
			currentSession.getTransaction().commit();
			currentSession.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return currentInsurance;
	}

	@Override
	public Insurance delete(String insName) {
		Insurance currentInsurance= null;
		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			currentInsurance = currentSession.find(Insurance.class, insName);
			currentInsurance.setName(insName);
			currentSession.remove(currentInsurance);
			
			currentSession.getTransaction().commit();
			currentSession.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return currentInsurance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance_Car> getAllIns_Car() {
		List<Insurance_Car> insCarList = null;
		
		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			
			String hql ="from Insurance_Car";
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery(hql);
			insCarList = query.list();
			
			currentSession.getTransaction().commit();
			currentSession.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return insCarList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> getInsByType(String type) {
		List<Insurance> insListForSelling = null;

		try{
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			String hql="from Insurance ins WHERE (ins.name not in (select ci.insurance.name from Insurance_Car ci inner join ci.insurance)) AND ins.type= :type";
		
			@SuppressWarnings("rawtypes")
			Query<Insurance> query = currentSession.createQuery(hql);
			query.setParameter("type", type);
			insListForSelling = query.list();
			
			currentSession.getTransaction().commit();
			currentSession.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return insListForSelling;
	}

}
