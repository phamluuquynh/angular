package com.plq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="APP_USER", uniqueConstraints = { @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {

	
	@Id
	@GeneratedValue
	@Column(name="USER_ID",nullable=false)
	private Long userId;
	
	
	@Column(name="USER_NAME",length=36,nullable=false)
	private String userName;
	
	@Column(name="ENCRYTED_PASSWORD",length=128,nullable=false)
	private String encrytedPassword;
	
	@Column(name="ENABLED",length=1,nullable=false)
	private int enabled;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
}
