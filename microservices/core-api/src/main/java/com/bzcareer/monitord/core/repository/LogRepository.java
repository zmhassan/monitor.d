package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bzcareer.monitord.core.model.Log;

@Repository
public interface LogRepository extends MongoRepository<Log, String>{
	void delete(Log log);

	List<Log> findAll();

	Log findOne(String id);

	Log save(Log log);

}
