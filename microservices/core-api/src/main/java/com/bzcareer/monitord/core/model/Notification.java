package com.bzcareer.monitord.core.model;

import org.springframework.data.annotation.Id;

public class Notification {

	@Id
	private String id;
	private String notification_type;
	private String from;
	private String message;

 
	public Notification(String notification_type, String from, String message) {
		this.notification_type = notification_type;
		this.from = from;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public String getNotification_type() {
		return notification_type;
	}

	public String getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNotification_type(String notification_type) {
		this.notification_type = notification_type;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void update(NotificationDAO inboxDAO) {
		this.id = inboxDAO.getId();
		this.notification_type = inboxDAO.getNotification_type();
		this.from = inboxDAO.getFrom();
		this.message = inboxDAO.getMessage();
	}

}
