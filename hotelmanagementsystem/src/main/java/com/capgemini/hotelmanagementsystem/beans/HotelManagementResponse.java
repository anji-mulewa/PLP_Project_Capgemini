package com.capgemini.hotelmanagementsystem.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelManagementResponse {
	private int statusCode;
	private String description;
	private String message;
	private AdminEmployeeUserBean adminEmployeeUserBean;
	private HotelInformationBean hotelInformationBean;
	private List<HotelInformationBean> hotelList;
	private RoomInformationBean roomInformationBean;
	private List<RoomInformationBean> roomList;
	private EmployeeInformationBean employeeBean;
	private List<EmployeeInformationBean> employeeList;

	public List<EmployeeInformationBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeInformationBean> employeeList) {
		this.employeeList = employeeList;
	}

	public EmployeeInformationBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeInformationBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public List<RoomInformationBean> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomInformationBean> roomList) {
		this.roomList = roomList;
	}

	public RoomInformationBean getRoomInformationBean() {
		return roomInformationBean;
	}

	public void setRoomInformationBean(RoomInformationBean roomInformationBean) {
		this.roomInformationBean = roomInformationBean;
	}

	public List<HotelInformationBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelInformationBean> hotelList) {
		this.hotelList = hotelList;
	}

	public HotelInformationBean getHotelInformationBean() {
		return hotelInformationBean;
	}

	public void setHotelInformationBean(HotelInformationBean hotelInformationBean) {
		this.hotelInformationBean = hotelInformationBean;
	}

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
