package com.nit.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.EmployeeService;
@Controller
public class EmployeeDegnController {
	@Autowired
	private EmployeeService eSer;
	
	public List<Employee> DesgnControl(String deg1,String deg2,String deg3) throws SQLException{
		return eSer.empDesig(deg1, deg2, deg3);
	}
	public void insert(Employee emp)throws SQLException {
		eSer.insert(emp);
	}

}
