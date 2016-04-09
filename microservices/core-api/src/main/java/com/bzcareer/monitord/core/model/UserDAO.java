package com.bzcareer.monitord.core.model;

/**
 * UserDAO<br>
 * 
 * @author Zak Hassan
 */
public final class UserDAO {
	private String id;
	private String username;
	private String team;
	private String password;
	
	public UserDAO(Users user){
		id=user.getId();
		username=user.getUsername();
		password=user.getPassword();
		team=user.getTeam();
	}
	
	public UserDAO(String username, String team, String password) {
		this.username = username;
		this.team = team;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "UserDAO [username=" + username + ", team=" + team + "]";
	}

	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 
	 
}
