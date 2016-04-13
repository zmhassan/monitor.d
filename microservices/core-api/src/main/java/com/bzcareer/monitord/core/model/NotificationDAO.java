package com.bzcareer.monitord.core.model;

public class NotificationDAO {
	private String id;
	private String notification_type;
	private String from;
	private String message;

	
	public NotificationDAO(String notification_type, String from, String message) {
		super();
		this.notification_type = notification_type;
		this.from = from;
		this.message = message;
	}

	public NotificationDAO(Notification inbox) {
		id = inbox.getId();
		notification_type = inbox.getNotification_type();
		from = inbox.getFrom();
		message = inbox.getMessage();
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

}
