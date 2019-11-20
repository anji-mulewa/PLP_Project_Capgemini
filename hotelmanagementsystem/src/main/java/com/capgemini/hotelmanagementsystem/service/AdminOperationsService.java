package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.beans.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.beans.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.beans.RoomInformationBean;

public interface AdminOperationsService {
	public HotelInformationBean addHotel(HotelInformationBean hotelBean);
	public List<HotelInformationBean> getHotelList();
	public boolean updateHotelInformation(HotelInformationBean hotelBean);
	public boolean deleteHotelInformation(int hotelId);
	public boolean licenseNumberPresent(String licenseNumber);

	
	//room crud operations
	public RoomInformationBean addRoom (RoomInformationBean roomBean);
	public boolean deleteRoomInformation(int roomId);
	public List<RoomInformationBean> getRoomList();
	public boolean updateRoomInformation(RoomInformationBean roomBean);
	
	//employee crud operations
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeBean);
	public List<EmployeeInformationBean> getEmployeeList();
	public boolean deleteEmployeeInformation(int employeeId);
	public boolean updateEmployeeInformation(EmployeeInformationBean employeeBean);

}
