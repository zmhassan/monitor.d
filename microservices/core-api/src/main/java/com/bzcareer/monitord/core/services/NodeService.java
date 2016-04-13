package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.NodeDAO;

public interface NodeService {

	NodeDAO create(NodeDAO node);

	NodeDAO delete(String id);
	List<NodeDAO> findAll();
	NodeDAO findById(String id);
	NodeDAO update(NodeDAO node);
	void deleteAll();
	void delete(NodeDAO node);
}
