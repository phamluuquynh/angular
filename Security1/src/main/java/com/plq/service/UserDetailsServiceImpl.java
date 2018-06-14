package com.plq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plq.dao.AppRoleDao;
import com.plq.dao.AppUserDao;
import com.plq.entity.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppRoleDao appRoleDao;
	@Autowired
	private AppUserDao appUserDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser appUser = appUserDao.findUserAccount(userName);
		
		  if (appUser == null) {
	            System.out.println("User not found! " + userName);
	            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
	        }
		  
		  System.out.println("Found User: " + appUser);
		  
		   // [ROLE_USER, ROLE_ADMIN,..]
		  List<String> roleNames = this.appRoleDao.getRoleNames(appUser.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<>();
		  if (roleNames != null) {
	            for (String role : roleNames) {
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority(role);
	                grantList.add(authority);
	            }
	        }
		

		
		  UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
	                appUser.getEncrytedPassword(), grantList);
		  return userDetails;
	}

}
