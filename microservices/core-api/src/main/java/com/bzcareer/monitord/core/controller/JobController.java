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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);
	
	JobService service;

	@Autowired
	public JobController(JobService service) {
		this.service = service;
	}

	@ApiOperation(value = "getAllJobs", produces="application/json", 
			notes="Provides list of jobs that monitord has executed or is pending execution")
	@RequestMapping( method = RequestMethod.GET)
	public List<JobDAO> getAllJobs() {
		return service.findAll();
	}


	@ApiOperation(value = "getJobById", produces="application/json", 
			notes="Query the database for job with the id provided in the url path")
	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public JobDAO getJobById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@ApiOperation(value = "createJob", produces="application/json", consumes = "application/json",
			notes="Inserts a new job into the database")
	@RequestMapping( method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public JobDAO createJob(@RequestBody @Valid JobDAO job) {
		LOGGER.info("Created job Entry!");
		return service.create(job);
	}

	@ApiOperation(value = "getJobById", produces="application/json", 
			notes="Query the database for job with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public JobDAO updateJob(@RequestBody @Valid JobDAO job) {
		LOGGER.info("Updated Job Entry! ");
		return service.update(job);
	}

	@ApiOperation(value = "getJobById", produces="application/json", 
			notes="Delete job from database with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public JobDAO deleteJob(@PathVariable("id") String id) {
		LOGGER.info("Deleted One Job Entry!");
		return service.delete(id);
	}
}
