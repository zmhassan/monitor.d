package com.bzcareer.monitord.core.model;

import javax.validation.constraints.NotNull;

public class LogDAO {

	private String id;
	@NotNull
	private String appName;
	public LogDAO(){
		
	}
	public LogDAO(String appName, String start, String end) {
 		this.appName = appName;
		this.start = start;
		this.end = end;
	}

	private String start;
	private String end;

	public LogDAO(Log log) {
		id = log.getId();
		appName = log.getAppName();
		start = log.getStart();
		end = log.getEnd();
	}

	public String getId() {
		return id;
	}

	public String getAppName() {
		return appName;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "LogDAO [id=" + id + ", appName=" + appName + ", start=" + start + ", end=" + end + "]";
	}

	
	
}
