package com.bzcareer.monitord.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bzcareer.monitord.core.model.Alert;

public interface AlertRepository extends MongoRepository<Alert, String> {

}
