package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

	@Id
	@Column(name = "AUTHORITY")
	private String authority;

	@Column(name = "CREATED_TIME")
	private String createdTime;

	@Column(name = "LAST_ACCESS")
	private String lastAccess;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private User user;
}
