package com.bzcareer.monitord.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.services.NodeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeController.class);

	NodeService service;

	@Autowired
	public NodeController(NodeService service) {
		this.service = service;
	}

	@ApiOperation(value = "getAllNodes", produces="application/json", 
			notes="Provides list of nodes that monitord is managing")
	@RequestMapping( method = RequestMethod.GET)
	public List<NodeDAO> getAllNodes() {
		LOGGER.info("get all nodes");
		return service.findAll();
	}

	@ApiOperation(value = "getNodeById", produces="application/json", 
			notes="Query the database for job entry with the id provided in the url path")
	@RequestMapping(value = "{id}",method= RequestMethod.GET)
	public NodeDAO getNodeById(@PathVariable("id") String id){
		LOGGER.info("find node by id: {}",id);
		return service.findById(id);
	}

	@ApiOperation(value = "createNode", produces="application/json", consumes = "application/json",
			notes="Inserts a new Node entry in the database")
	@RequestMapping( method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.CREATED)
	public NodeDAO createNode(@RequestBody @Valid NodeDAO node) {
		LOGGER.info("create node entry: {} ", node);
		return service.create(node);
	}

	@ApiOperation(value = "updateNodeById", produces="application/json", 
			notes="Update node entry with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public NodeDAO updateNode(@RequestBody @Valid NodeDAO node) {
		LOGGER.info("update node entry {}", node);
		return service.update(node);
	}

	@ApiOperation(value = "deleteNodeById", produces="application/json", 
			notes="Delete node from database with the id provided in the url")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public NodeDAO deleteNode(@PathVariable("id") String id) {
		LOGGER.info("delete node entry with id: {}", id);
		return service.delete(id);
	}

}
