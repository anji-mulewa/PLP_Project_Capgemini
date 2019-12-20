package com.capgemini.hotelmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;

@Service
public interface AdminEmployeeUserService {

	public AdminEmployeeUserBean getLogin( String email , String password);

}
