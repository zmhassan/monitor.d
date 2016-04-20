package com.bzcareer.monitord.core.model;

public class JobDAO {
	String id;
	String name;
	String status;
	String start;
	String end;
	String type;

	public JobDAO(){}
	public JobDAO(String name, String status, String start, String end, String type) {
 		this.name = name;
		this.status = status;
		this.start = start;
		this.end = end;
		this.type = type;
	}

	public JobDAO(Job job) {
		id = job.getId();
		name = job.getName();
		status = job.getStatus();
		start = job.getStart();
		end = job.getEnd();
		type = job.getType();
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
	@Override
	public String toString() {
		return "JobDAO [id=" + id + ", name=" + name + ", status=" + status + ", start=" + start + ", end=" + end
				+ ", type=" + type + "]";
	}
	
}
