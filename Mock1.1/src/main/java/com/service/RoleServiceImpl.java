package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RoleDao;
import com.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	
	
	@Override
	@Transactional
	public void add(Role ro) {
		roleDao.add(ro);

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
