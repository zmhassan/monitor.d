package com.bzcareer.monitord.core.services;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzcareer.monitord.core.model.Node;
import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.repository.NodeRepository;

@Service
public class MongoDBNodeService implements NodeService {

	@Autowired
	NodeRepository repo;

	@Override
	public NodeDAO create(NodeDAO nodeDAO) {
		Node node = new Node();
		node.setServerIp(nodeDAO.getServerIp());
		node.setServerName(nodeDAO.getServerName());
		Node saved = repo.save(node);
		return new NodeDAO(saved);
	}

	@Override
	public NodeDAO delete(String id) {
		Node node = findNodeById(id);
		repo.delete(id);
		return new NodeDAO(node);
	}

	private Node findNodeById(String id) {
		return repo.findOne(id);
	}

	@Override
	public List<NodeDAO> findAll() {
		return repo.findAll().stream().map(this::daoConverter).collect(toList());

	}

	private NodeDAO daoConverter(Node node) {
		return convertToDAO(node);
	}

	private NodeDAO convertToDAO(Node node) {
		return new NodeDAO(node);
	}

	@Override
	public NodeDAO findById(String id) {
		Node node = findNodeById(id);
		return convertToDAO(node);
	}

	@Override
	public NodeDAO update(NodeDAO nodeDao) {
		Node node = findNodeById(nodeDao.getId());
		node.update(nodeDao);
		repo.save(node);
		return new NodeDAO(node);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public void delete(NodeDAO nodeDao) {
		Node node = findNodeById(nodeDao.getId());
		repo.delete(node);
	}

}
