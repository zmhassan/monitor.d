package com.bzcareer.monitord.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bzcareer.monitord.core.model.Users;
import com.bzcareer.monitord.core.repository.UserRepository;

/**
 * User Controller
 * 
 * Adding users to web console. To be replaced with Ldap or something better. Only for demo purposes
 * @author Zak Hassan 
 */
@RestController("/api/users")
public class UserController {

	@Autowired
	UserRepository repo;
 
	@RequestMapping(method=RequestMethod.GET)
	public List<Users> getAllUsers(){
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Users getUser( Users user){
		return repo.save(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Users  updateUser(Users user){
		return repo.save(user);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") String id){
	    repo.delete(id);
	}
	 
}
