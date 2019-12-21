package com.capgemini.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.beans.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystem;
import com.capgemini.hotelmanagementsystem.service.AdminEmployeeUserService;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" , allowCredentials = "true")
public class AdminEmployeeUserController {

	@Autowired
	private AdminEmployeeUserService adminEmployeeUserService;

	@GetMapping(path = "/adminEmployeeUserLogin")
	public HotelManagementResponse getLogin(@RequestParam String email, @RequestParam String password) {
		HotelManagementResponse response = new HotelManagementResponse();
		
		try {
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
		} catch (HotelManagementSystem e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	@PutMapping(path = "/userRegister" , produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public HotelManagementResponse userRegister(@RequestBody AdminEmployeeUserBean userBean) {
		HotelManagementResponse response = new HotelManagementResponse();
		userBean.setType("user");
		AdminEmployeeUserBean userRegisterBean = adminEmployeeUserService.userRegister(userBean);
		if(userRegisterBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User registered successfully");
			response.setAdminEmployeeUserBean(userRegisterBean);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Unable to register");
		}
		return response;
	}
}
