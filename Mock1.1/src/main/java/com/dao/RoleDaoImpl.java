package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Role ro) {
		sessionFactory.getCurrentSession().save(ro);
		
	}

	@Override
	public void edit(Role ro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role ro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
