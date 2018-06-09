package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RECORD_CANDIDATE")
public class RecordCandidate {
	
	@Id
	@SequenceGenerator(name = "id_ge", sequenceName = "candidate_pk_seq")
	@GeneratedValue(generator = "id_ge", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "CREATED_TIME")
	private String createdTime;

	@Column(name = "LAST_ACCESS")
	private String lastAccess;
	
	
	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private User user;
	
	
	 @OneToMany
	 @JoinColumn(name="JOB_TITLE")
	 private Set<Jobs> jobs = new HashSet<>();
	 
	 @Column(name="CONTENT")
	 private String content;
	 
	 @Column(name="STATUS")
	 private int status;
	 
	 @Column(name="CV_LINK")
	 private String cvLink;

}
