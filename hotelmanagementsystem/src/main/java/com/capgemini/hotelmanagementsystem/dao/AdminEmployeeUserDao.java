package com.capgemini.hotelmanagementsystem.dao;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;

public interface AdminEmployeeUserDao {

	public AdminEmployeeUserBean getLogin( String email , String password);
	
}
