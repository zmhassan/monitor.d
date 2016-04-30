package com.bzcareer.monitord.core.services;

import java.util.List;

import com.bzcareer.monitord.core.model.DockerContainer;
import com.bzcareer.monitord.core.model.JobDAO;

public interface DockerService {

	void createContainer();
	void startContainer(String id);
	void stopContainer(String id);
	List<DockerContainer> ps();
	DockerContainer startById(String id);
	DockerContainer startByName(String name);
	
}
