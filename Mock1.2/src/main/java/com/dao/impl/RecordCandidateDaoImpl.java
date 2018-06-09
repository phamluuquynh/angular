package com.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RecordCandidateDao;
import com.entity.RecordCandidate;

@Repository
public class RecordCandidateDaoImpl implements RecordCandidateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(RecordCandidate candidate) {
		sessionFactory.getCurrentSession().save(candidate);
	}

	@Override
	public void edit(RecordCandidate candidate) {
		sessionFactory.getCurrentSession().update(candidate);
	}

	@Override
	public void update(RecordCandidate candidate) {
		sessionFactory.getCurrentSession().delete(candidate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordCandidate> getAllRecordCandidate() {
		TypedQuery<RecordCandidate> query = sessionFactory.getCurrentSession().createQuery("from RecordCandidate");
		return query.getResultList();
	}

	@Override
	public RecordCandidate getRecordCandidateById(long id) {
		return sessionFactory.getCurrentSession().find(RecordCandidate.class, id);
	}

}
