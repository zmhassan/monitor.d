package com.bzcareer.monitord.core.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzcareer.monitord.core.model.Log;
import com.bzcareer.monitord.core.model.LogDAO;
import com.bzcareer.monitord.core.repository.LogRepository;

@Service
public class MongoLogService implements LogService{

	@Autowired
	LogRepository repo;
	
	@Override
	public LogDAO create(LogDAO logDAO) {
		Log log = new Log();
		log.setAppName(logDAO.getAppName());
		log.setStart(logDAO.getStart());
		log.setEnd(logDAO.getEnd());
		Log saved = repo.save(log);
		return new LogDAO(saved);
	}

	@Override
	public LogDAO delete(String id) {
		Log log =  repo.findOne(id);
		return new LogDAO(log);
	}
 

	@Override
	public List<LogDAO> findAll() {
		return repo.findAll().stream().map(this::daoConverter).collect(toList());

	}

	private LogDAO daoConverter(Log log) {
		return convertToDAO(log);
	}

	private LogDAO convertToDAO(Log log) {
		return new LogDAO(log);
	}

	@Override
	public LogDAO findById(String id) {
		Log log = repo.findOne(id);
		return convertToDAO(log);
	}

	@Override
	public LogDAO update(LogDAO logDao) {
		Log log = repo.findOne(logDao.getId());
		log.update(logDao);
		repo.save(log);
		return new LogDAO(log);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public void delete(LogDAO logDao) {
		Log log = repo.findOne(logDao.getId());
		repo.delete(log);
	}

}
