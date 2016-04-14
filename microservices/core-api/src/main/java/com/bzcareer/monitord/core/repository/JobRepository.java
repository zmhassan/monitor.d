package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bzcareer.monitord.core.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, String>{
	
	void delete(Job job);

	List<Job> findAll();

	Job findOne(String id);

	Job save(Job job);
	
}

