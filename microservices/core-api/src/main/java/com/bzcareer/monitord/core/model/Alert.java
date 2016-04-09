package com.bzcareer.monitord.core.model;

public class Alert {
	private String alertName;
	private String alertType;
	private String alertDate;

	public String getAlertName() {
		return alertName;
	}

	public String getAlertType() {
		return alertType;
	}

	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	@Override
	public String toString() {
		return "Alert [alertName=" + alertName + ", alertType=" + alertType + ", alertDate=" + alertDate + "]";
	}

	public Alert(String alertName, String alertType, String alertDate) {
		super();
		this.alertName = alertName;
		this.alertType = alertType;
		this.alertDate = alertDate;
	}

}
