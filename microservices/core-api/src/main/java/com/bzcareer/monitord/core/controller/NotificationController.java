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

import com.bzcareer.monitord.core.model.NotificationDAO;
import com.bzcareer.monitord.core.services.NotificationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
	
	NotificationService service;
	
	@Autowired
	public NotificationController(NotificationService service) {
		this.service=service;
	}

	@ApiOperation(value = "getAllNotifications", produces="application/json", 
			notes="Provides list of notifications that monitord is managing")
	@RequestMapping(method = RequestMethod.GET)
	public List<NotificationDAO> getAllNotifications() {
		LOGGER.info("get all users");
		return service.findAll();
	}

	@ApiOperation(value = "getNotificationById", produces="application/json", 
			notes="Query the database for notification entry with the id provided in the url path")
	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public NotificationDAO getNotificationById(@PathVariable("id") String id){
		LOGGER.info("find notification by id: {}",id);
		return service.findById(id);
	}

	@ApiOperation(value = "createNotification", produces="application/json", consumes = "application/json",
			notes="Inserts a new notification entry in the database")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public NotificationDAO createNotification(@RequestBody @Valid NotificationDAO notification) {
		LOGGER.info("Created notification Entry: {}" ,notification);
		return service.create(notification);
	}

	@ApiOperation(value = "updateNotificationById", produces="application/json", 
			notes="Update notification entry with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public NotificationDAO updateNotification(@RequestBody @Valid NotificationDAO notification) {
		LOGGER.info("Updated notification entry: {}",notification);
		return service.update(notification);
	}

	@ApiOperation(value = "deleteNotificationById", produces="application/json", 
			notes="Delete notification from database with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public NotificationDAO deleteNotification(@PathVariable("id") String id) {
		LOGGER.info("Deleted notification entry: {}",id);
		return service.delete(id);
	}

}
