package com.capgemini.hotelmanagementsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_information")
public class RoomInformationBean {
	@Id
	@Column
	private int roomId;
	@Column
	private String hotelLicense;
	@Column
	private String hotelName;
	@Column
	private int hotelId;
	@Column
	private int roomCount;
	@Column
	private String roomType;
	@Column
	private String roomCapacity;
	@Column
	private int roomAmount;
	@Column
	private String roomStatus;
	@Column
	private String roomImageUrl;
	
	
	public int getRoomAmount() {
		return roomAmount;
	}
	public void setRoomAmount(int roomAmount) {
		this.roomAmount = roomAmount;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomImageUrl() {
		return roomImageUrl;
	}
	public void setRoomImageUrl(String roomImageUrl) {
		this.roomImageUrl = roomImageUrl;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getHotelLicense() {
		return hotelLicense;
	}
	public void setHotelLicense(String hotelLicense) {
		this.hotelLicense = hotelLicense;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(String roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	
	
}
