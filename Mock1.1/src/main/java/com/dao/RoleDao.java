package com.dao;

import java.util.List;

import com.entity.Role;



public interface RoleDao {
	void add(Role ro);

	void edit(Role ro);

	void delete(Role ro);

	Role getById(Long id);

	List<Role> getAll();
}
