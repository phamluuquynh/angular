package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Jobs {

	@Id
	@SequenceGenerator(name = "id_ge", sequenceName = "jobs_pk_seq")
	@GeneratedValue(generator = "id_ge", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "CREATED_TIME")
	private String createdTime;

	@Column(name = "LAST_ACCESS")
	private String lastAccess;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CITY")
	private String city;

	@Column(name = "SALARY")
	private double salary;
	
	@Column(name="SUMMARY")
	private String summary;
	
	@Column(name="JOB_DESC")
	private String jobDesc;
	
}
