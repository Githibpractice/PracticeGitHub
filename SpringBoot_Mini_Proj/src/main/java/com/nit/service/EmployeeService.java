package com.nit.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repository.EmployeeOracleDAO;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeOracleDAO eDAO;
	
	public List<Employee> empDesig(String deg1,String deg2,String deg3) throws SQLException{
		deg1.toUpperCase();
		deg2.toUpperCase();
		deg3.toUpperCase();
		List<Employee> list = eDAO.desigs(deg1, deg2, deg3);
		
		list.forEach(emp->{emp.setNetSal(emp.getSal()-(emp.getSal()*0.2));
		emp.setGrossSal(emp.getSal()+(emp.getSal()*0.2));
		});
		return list;
	}
	public void  insert(Employee emp) throws SQLException {
		
		int insert = eDAO.insert(emp);
		if(insert>0) {
			System.out.println("Inserted Succesful");
		}
		
	}
	
}
