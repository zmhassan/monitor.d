package com.bzcareer.monitord.core.model;

import org.springframework.data.annotation.Id;

public class Log {

	@Id
	private String id;
	private String appName;
	private String start;
	private String end;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void update(LogDAO logDao) {
		this.setAppName(logDao.getAppName());
		this.setStart(logDao.getStart());
		this.setEnd(logDao.getEnd());
	}

}
