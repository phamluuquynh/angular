package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS")
public class News {

	@Id
	@SequenceGenerator(name = "id_ge", sequenceName = "news_pk_seq")
	@GeneratedValue(generator = "id_ge", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "CREATED_TIME")
	private String createdTime;

	@Column(name = "LAST_ACCESS")
	private String lastAccess;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	
	@Column(name="SUMMARY")
	private String summary;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="IMAGE_URL")
	private String imageUrl;
	
	@Column(name="STATUS")
	private int status;
	
}
