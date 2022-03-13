package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Employee;
import com.model.EmployeeDetails;

@Repository
public class EmployeeRepository {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
    JdbcTemplate jdbc;

	final RowMapper<Employee> mapper = new RowMapper<Employee>() {

		@Override
		public Employee mapRow(ResultSet rs ,int rowNum) throws SQLException {

			Employee n = new Employee();
			n.setFirstName(rs.getString("firstname"));
			n.setLastName(rs.getString("lastname"));
			
			return n;
		}
	};

	public String registerEmployee(EmployeeDetails employeeDetails, String department) {
		
		String repositoryResponse = null;
		
		final String sql = "INSERT INTO employees (firstname,lastname,department) VALUES (?,?,?)";
		
		try {
			Integer jdbcResponse = jdbc.update(sql,employeeDetails.getEmployeeFirstName(),employeeDetails.getLastName(),department);
			if(jdbcResponse == 1) { 
				repositoryResponse = "EMPLOYEEDETAILS Registered";
				log.debug("EmployeeRepository registerEmployee New EMPLOYEEDETAILS registered "+employeeDetails.toString());
				}
		} catch (DataAccessException e) {
			log.debug("EmployeeRepository registerEmployee  EMPLOYEEDETAILS not registered "+employeeDetails.toString());
		}
		return repositoryResponse;
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		final String  sql = "SELECT * FROM employees";
		try {
			employees = jdbc.query(sql,mapper);
			log.debug("EmployeeRepository getEmployees found "+employees.toString());
		} catch (DataAccessException e) {
			log.debug("EmployeeRepository getEmployees employees not found "+employees.toString());
		}	
		return employees;
	}
	
	public List<String> getDepartments() {
		
		List<String> departments = jdbc.query(
		"SELECT department from employees",
		(resultSet,rowNum) -> {
			String department = new String();
			department = resultSet.getString("department") ;
			return department;
		});
		return departments;
	}

	public Integer employeeDetailsExistCheck(EmployeeDetails employeeDetails,String deparment) {

		Integer repositoryResponse = 0;
		final String  sql = "SELECT COUNT (*)  from employees where firstname = ? and lastname = ? and department = ?";
		try {
				repositoryResponse = jdbc.queryForObject(sql,Integer.class, employeeDetails.getFirstName(),employeeDetails.getLastName(),deparment);
				if(repositoryResponse == 1) { log.debug("EmployeeRepository userExistCheck found "+ employeeDetails.getFirstName()," ",employeeDetails.getLastName()); }
		} catch (DataAccessException e)  {
			log.debug("UserRepository userExistCheck user not found "+ employeeDetails.getFirstName()," ",employeeDetails.getLastName());
		}
		
		return repositoryResponse;
	}
	
	public List<Employee> getEmployeesByDepartment(String department) {
		
		List<Employee> employees = new ArrayList<>();
		final String  sql = "SELECT * FROM employees WHERE department = ?";
		try {
			employees = jdbc.query(sql,mapper,department);
			log.debug("EmployeeRepository findByDepartment employees with department found "+employees.toString());
		} catch (DataAccessException e) {
			log.debug("EmployeeRepository findByDepartment employees with department not found "+employees.toString());
		}	
		return employees;
	}
}
