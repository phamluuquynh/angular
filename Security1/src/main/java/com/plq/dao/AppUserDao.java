package com.plq.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plq.entity.AppUser;

@Repository
@Transactional
public class AppUserDao {
	
	@Autowired
	private EntityManager entityManager;
	
	public AppUser findUserAccount(String userName){
		try{
			String sql ="select e from" + AppUser.class.getName()+ "e"
					+"where e.userName=:userName";
			
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("userName", userName);
					
			return (AppUser)query.getSingleResult();
		}catch(NoResultException ex){
			return null;
		}
	}

}
