package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bzcareer.monitord.core.model.Users;
 
public interface UserRepository extends MongoRepository<Users, String> {

	Users findByUsername(String username);

	List<Users> findByTeam(String team);

	void delete(Users user);

	List<Users> findAll();

	
    Users  findOne(String id);

	Users save(Users user);

}
