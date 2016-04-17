package com.bzcareer.monitord.core.model;

public class NodeDAO {

	private String id;
	private String serverName;
	private String serverIp;

	public NodeDAO() {}
	
	public NodeDAO(String serverName, String serverIp) {

		this.serverName = serverName;
		this.serverIp = serverIp;
	}

	public NodeDAO(Node node) {
		id = node.getId();
		serverName = node.getServerName();
		serverIp = node.getServerIp();
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
}
