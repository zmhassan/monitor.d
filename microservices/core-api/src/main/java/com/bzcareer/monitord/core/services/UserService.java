package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.Users;

public interface UserService {
	Users create(Users user);

	Users delete(String id);

	List<Users> findAll();

	Users findById(String id);

	Users update(Users users);

}
