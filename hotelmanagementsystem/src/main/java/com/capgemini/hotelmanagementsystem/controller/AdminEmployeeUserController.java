package com.capgemini.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.beans.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.AdminEmployeeUserService;

@RestController
public class AdminEmployeeUserController {

	@Autowired
	private AdminEmployeeUserService adminEmployeeUserService;

	@GetMapping(path = "/adminEmployeeUserLogin")
	public HotelManagementResponse getLogin(@RequestParam String email, @RequestParam String password) {
		HotelManagementResponse response = new HotelManagementResponse();
		AdminEmployeeUserBean adminEmployeeUserBean = adminEmployeeUserService.getLogin(email, password);
		if (adminEmployeeUserBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Logged in successfully");
			response.setAdminEmployeeUserBean(adminEmployeeUserBean);
		} else {
			response.setStatusCode(400);
			response.setMessage("failed");
			response.setDescription("Unable to login");
		}
		return response;
	}
}
