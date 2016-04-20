package com.bzcareer.monitord.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bzcareer.monitord.core.model.LogDAO;
import com.bzcareer.monitord.core.services.LogService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/logs")
public class LogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);
	
	LogService service;

	@Autowired
	public LogController(LogService service) {
		this.service = service;
	}

	@ApiOperation(value = "getAllLogs", produces="application/json", 
			notes="Provides list of Logs that monitord has executed or is pending execution")
	@RequestMapping( method = RequestMethod.GET)
	public List<LogDAO> getAllLogs() {
		LOGGER.info("get all logs");
		return service.findAll();
	}

	@ApiOperation(value = "getLogsById", produces="application/json", 
			notes="Query the database for log entry with the id provided in the url path")
	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public LogDAO getLogById(@PathVariable("id") String id){
		LOGGER.info("find log by id: {}",id);
		return service.findById(id);
	}

	@ApiOperation(value = "createLog", produces="application/json", 
			notes="Creates of log entry that monitord has captured")
	@RequestMapping ( method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public LogDAO createLog(@RequestBody @Valid LogDAO log) {
		LOGGER.info("create log entry: {} ", log);
		return service.create(log);
	}

	@ApiOperation(value = "updateLog", produces="application/json", 
			notes="Update of log entry that monitord has captured")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public LogDAO updateLog(@RequestBody @Valid LogDAO log) {
		LOGGER.info("Updated log entry: {} ", log);
		return service.update(log);
	}

	@ApiOperation(value = "deleteLogById", produces="application/json", 
			notes="Delete log from database with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public LogDAO deleteLog(@PathVariable("id") String id) {
		LOGGER.info("deleted one log entry by id: {}",id);
		return service.delete(id);
	}
}
