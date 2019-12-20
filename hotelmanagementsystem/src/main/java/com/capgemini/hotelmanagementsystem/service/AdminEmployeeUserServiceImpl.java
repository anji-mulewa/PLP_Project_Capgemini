package com.capgemini.hotelmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.dao.AdminEmployeeUserDao;
import com.capgemini.hotelmanagementsystem.validation.UserValidation;
import com.capgemini.hotelmanagementsystem.validation.UserValidationImpl;

public class AdminEmployeeUserServiceImpl implements AdminEmployeeUserService {
	@Autowired
	private AdminEmployeeUserDao adminEmployeeUserDao;
	UserValidation userValid = new UserValidationImpl();

	@Override
	public AdminEmployeeUserBean getLogin(String email, String password) {
		if (userValid.emailValidation(email) && userValid.passwordValidation(password)) {
			return adminEmployeeUserDao.getLogin(email, password);
		} else {
			return null;
		}
	}
}