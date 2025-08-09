package com.nit.repository;

import java.sql.SQLException;
import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> desigs(String deg1,String deg2,String deg3) throws SQLException;
	public int insert(Employee emp) throws SQLException ;
}
