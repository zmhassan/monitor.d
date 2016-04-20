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

import io.swagger.annotations.ApiOperation;

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
	
	@ApiOperation(value = "getAllUsers", produces="application/json", 
			notes="Provides list of notifications that monitord is managing")
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDAO> getAllUsers() {
		LOGGER.info("get all users");
		return service.findAll();
	}

	@ApiOperation(value = "getUserById", produces="application/json", 
			notes="Query the database for user entry with the id provided in the url path")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public UserDAO getOneUser(@PathVariable("id") String id) {
		LOGGER.info("find user by id: {}",id);
		return service.findById(id);
	}

	@ApiOperation(value = "createUser", produces="application/json", consumes = "application/json",
			notes="Inserts a new user entry in the database")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDAO getUser(@RequestBody @Valid UserDAO user) {
		LOGGER.info("create user entry: {} ", user);
		return service.create(user);
	}
	
	@ApiOperation(value = "updateUserById", produces="application/json", 
			notes="Update user entry with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public UserDAO updateUser(@RequestBody @Valid UserDAO user) {
		LOGGER.info("update user entry: {}", user);
		return service.update(user);
	}
	
	@ApiOperation(value = "deleteUserById", produces="application/json", 
			notes="Delete user from database with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public UserDAO deleteUser(@PathVariable("id") String id) {
		LOGGER.info("delete user entry with id: {}", id);
		return service.delete(id);
	}

}
