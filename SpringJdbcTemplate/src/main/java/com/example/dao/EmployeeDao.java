package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.model.Employee;

public class EmployeeDao {

	///Fetching the data from database using jdbc template
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	/*
	 * public void setNamedJdbcTemplate(NamedParameterJdbcTemplate
	 * namedJdbcTemplate) { this.namedJdbcTemplate=namedJdbcTemplate; }
	 */
	public void saveEmpUsingNamedParam(Employee e) {
		String query= "insert into Employee_Details values(:id,:name,:age,:salary)";
		
		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("id", e.getId());
		paramMap.put("name",e.getName());
		paramMap.put("age", e.getAge());
		paramMap.put("salary",e.getSalary());
		
		namedJdbcTemplate.execute(query, paramMap, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}
		});
	}
	
	public int saveEmployee(Employee e) {
		
		String query= "insert into Employee_Details values("+e.getId()+", '"+e.getName()+" ' ,"+e.getAge()+","+e.getSalary()+")";
				
		return jdbcTemplate.update(query);
	}
	
	public List<Employee> getEmployeesResultSetExtractor() {
		
		String query= "select * from employee_details";
				
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Employee>>() {

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Employee> empList= new ArrayList<Employee>();
				while(rs.next()) {
					Employee e= new Employee();
					e.setId(rs.getInt("emp_id"));
					e.setName(rs.getString("emp_name"));
					e.setAge(rs.getInt("age"));
					e.setSalary(rs.getLong("salary"));
					empList.add(e);
				}
				return empList;
			}
		});
	}
	
	public List<Employee> getAllEmployeesByRowMapper(){
		String query="select * from employee_details";
		return jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee e= new Employee();
				e.setId(rs.getInt("emp_id"));
				e.setName(rs.getString("emp_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getLong("salary"));
				return e;
			}
		});
	}
	
	public Boolean saveEmployeeByPreparedStatement(final Employee e) {
			
			String query= "insert into Employee_Details values(?,?,?,?)";
					
			return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
	
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					ps.setInt(1, e.getId());
					ps.setString(2, e.getName());
					ps.setInt(3, e.getAge());
					ps.setLong(4, e.getSalary());
					return ps.execute();
				}
			});
		}
	
	public Boolean updateEmployeeByPreparedStatement(final Employee e) {
		
		String query= "update Employee_Details set emp_name=? where emp_id=?";
				
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, e.getName());
				ps.setInt(2, e.getId());
				return ps.execute();
			}
		});
	}
	
public Boolean deleteEmployeeByPreparedStatement(final Employee e) {
		
		String query= "delete from Employee_Details where emp_id=?";
				
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				return ps.execute();
			}
		});
	}
}
