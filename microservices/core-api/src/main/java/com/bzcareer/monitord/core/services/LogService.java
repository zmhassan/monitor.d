package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.LogDAO;

public interface LogService {

	LogDAO create(LogDAO node);

	LogDAO delete(String id);

	List<LogDAO> findAll();

	LogDAO findById(String id);

	LogDAO update(LogDAO log);

	void deleteAll();

	void delete(LogDAO node);

}
