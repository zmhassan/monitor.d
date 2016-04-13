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

@RestController
@RequestMapping("/api/alerts")
public class NotificationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);
	
	NotificationService service;
	
	@Autowired
	public NotificationController(NotificationService service) {
		this.service=service;
	}

	@RequestMapping(path="/",method = RequestMethod.GET)
	public List<NotificationDAO> getAllInbox() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public NotificationDAO getNotificationById(@PathVariable("id") String id){
		return service.findById(id);
	}

	@RequestMapping(path="/",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public NotificationDAO createNotification(@RequestBody @Valid NotificationDAO inbox) {
		LOGGER.info("Created alert Entry!");
		return service.create(inbox);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public NotificationDAO updateNotification(@RequestBody @Valid NotificationDAO inbox) {
		LOGGER.info("Updated alert entry!");
		return service.update(inbox);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public NotificationDAO deleteNotification(@PathVariable("id") String id) {
		LOGGER.info("Deleted alert entry!");
		return service.delete(id);
	}

}
