package com.bzcareer.monitord.core.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzcareer.monitord.core.model.Job;
import com.bzcareer.monitord.core.model.JobDAO;
import com.bzcareer.monitord.core.repository.JobRepository;

@Service
public class MongoDBJobService implements JobService {
	@Autowired
	JobRepository repo;

	@Override
	public JobDAO create(JobDAO jobDao) {
		// Should use builder pattern arguments too much
		Job job = new Job(jobDao.getName(), jobDao.getStatus(),
				jobDao.getStart(), jobDao.getEnd(), jobDao.getType());
		Job saved = repo.save(job);
		return new JobDAO(saved);
	}

	@Override
	public JobDAO delete(String id) {
		Job node = repo.findOne(id);
		return new JobDAO(node);
	}

 

	@Override
	public List<JobDAO> findAll() {
		return repo.findAll().stream().map(this::daoConverter).collect(toList());

	}

	private JobDAO daoConverter(Job job) {
		return convertToDAO(job);
	}

	private JobDAO convertToDAO(Job job) {
		return new JobDAO(job);
	}

	@Override
	public JobDAO findById(String id) {
		Job job = repo.findOne(id);
		return convertToDAO(job);
	}

	@Override
	public JobDAO update(JobDAO jobDao) {
		Job job = repo.findOne(jobDao.getId());
		job.update(jobDao);
		repo.save(job);
		return new JobDAO(job);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public void delete(JobDAO jobDao) {
		Job job = repo.findOne(jobDao.getId());
		repo.delete(job);
	}
	
}
