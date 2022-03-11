package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.EmployeeDetails;

@Repository
public class EmployeeRepository {

	private List<EmployeeDetails> employees = new ArrayList<>();
	private List<Department> departments = new ArrayList<>();

	public List<EmployeeDetails> getEmployeeDetails() {
		return employees;
	}
	public List<Department> getDepartments() {
		return departments;
	}	
	
	public String addEmployee(EmployeeDetails employee) {
		employees.add(employee);
			return "addEmployees";
	}
	
	public String addDepartment(Department department) {
		departments.add(department);
			return "addDepartment";
	}
}
