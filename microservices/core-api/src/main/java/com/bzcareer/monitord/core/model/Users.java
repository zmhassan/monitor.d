package com.bzcareer.monitord.core.model;

import org.springframework.data.annotation.Id;

public class Users {

	@Id
	private String id;
	private String username;
	private String password;
	private String team;

	public Users(String username, String password, String team) {
		this.username = username;
		this.password = password;
		this.team = team;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", team=" + team + "]";
	}

}
