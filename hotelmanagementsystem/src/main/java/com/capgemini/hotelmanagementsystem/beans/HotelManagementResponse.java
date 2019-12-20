package com.capgemini.hotelmanagementsystem.beans;

public class HotelManagementResponse {
	private int statusCode;
	private String description;
	private String message;
	private AdminEmployeeUserBean adminEmployeeUserBean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminEmployeeUserBean getAdminEmployeeUserBean() {
		return adminEmployeeUserBean;
	}

	public void setAdminEmployeeUserBean(AdminEmployeeUserBean adminEmployeeUserBean) {
		this.adminEmployeeUserBean = adminEmployeeUserBean;
	}

}
