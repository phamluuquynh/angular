package com.service;

import java.util.List;

import com.entity.RecordCandidate;

public interface RecordCandidateService {
	
	/**
	 * Add new {@link RecordCandidate}
	 * @param candidate
	 */
	void add(RecordCandidate candidate);
	void edit(RecordCandidate candidate);
	void update(RecordCandidate candidate);
	List<RecordCandidate> getAllRecordCandidate();
	RecordCandidate getRecordCandidateById(long id);
}
