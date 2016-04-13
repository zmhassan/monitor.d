package com.bzcareer.monitord.core.model;

import org.springframework.data.annotation.Id;

public class Node {

	@Id
	private String id;
	private String serverName;
	private String serverIp;

	public Node(String id, String serverName, String serverIp) {
		this.id = id;
		this.serverName = serverName;
		this.serverIp = serverIp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public void update(NodeDAO nodeDao) {
		id = nodeDao.getId();
		serverName = nodeDao.getServerName();
		serverIp = nodeDao.getServerIp();

	}
	
	

}
