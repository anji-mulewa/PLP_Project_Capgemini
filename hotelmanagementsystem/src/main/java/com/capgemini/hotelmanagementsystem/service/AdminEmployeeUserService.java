package com.capgemini.hotelmanagementsystem.service;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;

public interface AdminEmployeeUserService {

	public AdminEmployeeUserBean getLogin( String email , String password);
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean userBean);
}
