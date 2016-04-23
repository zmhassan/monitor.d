package com.bzcareer.monitord.core.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NodeDAO {

	private String id;
	@Size( min=5)
	@NotNull
	private String serverName;
 	@NotNull
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

	@Override
	public String toString() {
		return "NodeDAO [id=" + id + ", serverName=" + serverName + ", serverIp=" + serverIp + "]";
	}
	
	
}
