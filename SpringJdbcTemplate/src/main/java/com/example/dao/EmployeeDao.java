package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.Employee;

public class EmployeeDao {

	///Fetching the data from database using jdbc template
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	
	public int saveEmployee(Employee e) {
		
		String query= "insert into Employee_Details values("+e.getId()+", '"+e.getName()+" ' ,"+e.getAge()+","+e.getSalary()+")";
				
		return jdbcTemplate.update(query);
	}
	
	
}
