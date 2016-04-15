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

@RestController
@RequestMapping("/api/logs")
public class LogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);
	
	LogService service;

	@Autowired
	public LogController(LogService service) {
		this.service = service;
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<LogDAO> getAllLogs() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public LogDAO getLogById(@PathVariable("id") String id){
		return service.findById(id);
	}

	@RequestMapping ( method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public LogDAO createNode(@RequestBody @Valid LogDAO node) {
		LOGGER.info("Created Log Entry!");
		return service.create(node);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public LogDAO updateNode(@RequestBody @Valid LogDAO node) {
		LOGGER.info("Updated Log Entry!");
		return service.update(node);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public LogDAO deleteNode(@PathVariable("id") String id) {
		LOGGER.info("Deleted One Log Entry!");
		return service.delete(id);
	}
}
