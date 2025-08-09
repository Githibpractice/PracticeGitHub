package com.nit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository
public class EmployeeOracleDAO implements IEmployeeDAO {
	@Autowired
	private DataSource ds;
	private final String SELECT_QUERY = "select eid,ename,ejob,sal from emp where ejob in(?,?,?)";
	private final String INSERT_QUERY = "insert into emp(eid,ename,ejob,sal) values(mysqnce.nextval,?,?,?)";

	@Override
	public List<Employee> desigs(String deg1, String deg2, String deg3) throws SQLException {

		List<Employee> lst = new ArrayList<Employee>();
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_QUERY)) {
			ps.setString(1, deg1);
			ps.setString(2, deg2);
			ps.setString(3, deg3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ResultSet");
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getDouble(4));
				lst.add(emp);
			}
		}
		return lst;
	}

	@Override
	public int insert(Employee emp) throws SQLException {
		int c = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_QUERY);) {
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSal());
			c = ps.executeUpdate();
		}
		return c;
	}

}
