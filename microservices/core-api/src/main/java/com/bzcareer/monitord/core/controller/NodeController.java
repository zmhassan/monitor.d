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

import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.services.NodeService;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeController.class);

	NodeService service;

	@Autowired
	public NodeController(NodeService service) {
		this.service = service;
	}

	@RequestMapping(path="/",method = RequestMethod.GET)
	public List<NodeDAO> getAllNodes() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public NodeDAO getNodeById(@PathVariable("id") String id){
		return service.findById(id);
	}

	@RequestMapping(path="/",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public NodeDAO createNode(@RequestBody @Valid NodeDAO node) {
		LOGGER.info("Created Node!");
		return service.create(node);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public NodeDAO updateNode(@RequestBody @Valid NodeDAO node) {
		LOGGER.info("Updated Node!");
		return service.update(node);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public NodeDAO deleteNode(@PathVariable("id") String id) {
		LOGGER.info("Deleted One Node!");
		return service.delete(id);
	}

}
