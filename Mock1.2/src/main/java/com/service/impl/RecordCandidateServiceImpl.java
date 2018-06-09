package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RecordCandidateDao;
import com.entity.RecordCandidate;
import com.service.RecordCandidateService;

@Service
public class RecordCandidateServiceImpl implements RecordCandidateService {
	
	@Autowired
	private RecordCandidateDao recordCandidateDao;

	@Override
	public void add(RecordCandidate candidate) {
		recordCandidateDao.add(candidate);
	}

	@Override
	public void edit(RecordCandidate candidate) {
		recordCandidateDao.edit(candidate);
	}

	@Override
	public void update(RecordCandidate candidate) {
		recordCandidateDao.update(candidate);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RecordCandidate> getAllRecordCandidate() {
		return recordCandidateDao.getAllRecordCandidate();
	}

	@Override
	public RecordCandidate getRecordCandidateById(long id) {
		return recordCandidateDao.getRecordCandidateById(id);
	}
	
}
