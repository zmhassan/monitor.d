package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.JobDAO;

public interface JobService {
	JobDAO create(JobDAO node);

	JobDAO delete(String id);

	List<JobDAO> findAll();

	JobDAO findById(String id);

	JobDAO update(JobDAO job);

	void deleteAll();

	void delete(JobDAO job);
}
