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

import com.bzcareer.monitord.core.model.JobDAO;
import com.bzcareer.monitord.core.services.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);
	
	JobService service;

	@Autowired
	public JobController(JobService service) {
		this.service = service;
	}

	@RequestMapping(path="/",method = RequestMethod.GET)
	public List<JobDAO> getAllLogs() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public JobDAO getLogById(@PathVariable("id") String id){
		return service.findById(id);
	}

	@RequestMapping(path="/",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public JobDAO createNode(@RequestBody @Valid JobDAO job) {
		LOGGER.info("Created job Entry!");
		return service.create(job);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public JobDAO updateNode(@RequestBody @Valid JobDAO job) {
		LOGGER.info("Updated Job Entry!");
		return service.update(job);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public JobDAO deleteNode(@PathVariable("id") String id) {
		LOGGER.info("Deleted One Job Entry!");
		return service.delete(id);
	}
}
