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

import com.bzcareer.monitord.core.model.UserDAO;
import com.bzcareer.monitord.core.services.UserService;

/**
 * User Controller
 * 
 * Adding users to web console. To be replaced with Ldap or something better.
 * Only for demo purposes
 * 
 * @author Zak Hassan
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDAO> getAllUsers() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public UserDAO getOneUser(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDAO getUser(@RequestBody @Valid UserDAO user) {
		return service.create(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public UserDAO updateUser(@RequestBody @Valid UserDAO user) {
		return service.update(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public UserDAO deleteUser(@PathVariable("id") String id) {
		return service.delete(id);
	}

}
