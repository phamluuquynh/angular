package com.dao;

import java.util.List;

import com.entity.RecordCandidate;

public interface RecordCandidateDao {
	void add(RecordCandidate candidate);
	void edit(RecordCandidate candidate);
	void update(RecordCandidate candidate);
	List<RecordCandidate> getAllRecordCandidate();
	RecordCandidate getRecordCandidateById(long id);
}
