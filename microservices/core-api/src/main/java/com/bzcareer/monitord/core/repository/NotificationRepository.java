package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bzcareer.monitord.core.model.Notification;

@Repository
public interface NotificationRepository  extends MongoRepository<Notification, String> 
{

	void delete(Notification inbox);

	List<Notification> findAll();

	Notification findOne(String id);

	Notification save(Notification inbox);

}
