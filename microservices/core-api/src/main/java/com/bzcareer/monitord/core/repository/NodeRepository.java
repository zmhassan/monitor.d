package com.bzcareer.monitord.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bzcareer.monitord.core.model.Node;

@Repository
public interface NodeRepository extends MongoRepository<Node, String> {

	void delete(Node node);

	List<Node> findAll();

	Node findOne(String id);

	Node save(Node node);

}
