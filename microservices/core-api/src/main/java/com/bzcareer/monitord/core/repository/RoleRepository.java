package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bzcareer.monitord.core.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	void delete(Role data);

	List<Role> findAll();

	Role findOne(String id);

	Role save(Role data);

}
