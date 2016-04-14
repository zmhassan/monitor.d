package com.bzcareer.monitord.core.model;

import org.springframework.data.annotation.Id;

/** 
 * Job Class<br>
 * 
 * @author Zak Hassan
 */
public class Job {

	@Id
	String id;
	String name;
	String status;
	String start;
	String end;
	String type;
	
	public Job(String name, String status, String start, String end, String type) {
 		this.name = name;
		this.status = status;
		this.start = start;
		this.end = end;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getStatus() {
		return status;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
	public String getType() {
		return type;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void update(JobDAO jobDao) {
		this.name = jobDao.getName();
		this.status = jobDao.getStatus();
		this.start = jobDao.getStart();
		this.end = jobDao.getEnd();
		this.type = jobDao.getType();
	}
	
}
