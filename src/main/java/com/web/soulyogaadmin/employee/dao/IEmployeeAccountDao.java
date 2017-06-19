package com.web.soulyogaadmin.employee.dao;

import com.web.soulyogaadmin.entity.EmployeeAccountEntry;

/**
 * EmployeeAccount Dao Interface
 * @author Shawn xiao
 * @version 2017-06-15
 */
public interface IEmployeeAccountDao {

	public boolean employeeAccountLogin(String userName, String password);
	public String forgetPassword(String userName);
	public boolean resetPassword(String userName,String password);
	public boolean employeeAccountCreateOne(EmployeeAccountEntry entry);
	public EmployeeAccountEntry getEmployeeAccount(String userName);
	public boolean employeeAccountDeleteOne(String userName);
}
