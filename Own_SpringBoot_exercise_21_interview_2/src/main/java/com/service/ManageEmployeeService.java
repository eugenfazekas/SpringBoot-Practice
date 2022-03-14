package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.model.Department;
import com.model.Employee;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.DepartmentNameComparator;
import com.util.EmployeeFirstNameComparator;

@Service
public class ManageEmployeeService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private EmployeeRepository employeeRepository;
			
	public ManageEmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	/**
	The registerEmployee function will insert EmployeeDetails objects to db;
	*/
	public String registerEmployee(EmployeeDetails employeeDetails) {
		String addEmployees = null;
		
			for (int i = 0; i < employeeDetails.getDepartment().length;i++) {
			if (employeeExist(employeeDetails) == 0) {
				addEmployees =	employeeRepository.registerEmployee(employeeDetails, employeeDetails.getDepartment()[i]);
			}
		}
		return addEmployees;
	}

	/**
	The employeeExist function chech if Employee already registered to db;;
	*/
	public int employeeExist(EmployeeDetails employee) {		
		int employeeCheck = 0 ;

		for (int i = 0 ; i < employee.getDepartment().length; i++) {
			employeeCheck = employeeRepository.employeeDetailsExistCheck(employee,employee.getDepartment()[i]);
		}
		log.debug("ManageEmployeeService employeeExist: ",employeeCheck);
		return employeeCheck;
	}

	/**
	The getEmployees function request all employees from db;
	*/
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>(new HashSet<>(employeeRepository.getEmployees()));;
			Collections.sort(employees, new EmployeeFirstNameComparator());
		return employees;
	}
	
	/**
	The getEmployeesByDepartment function request all employees from specified department from db;
	*/
	public List<Employee> getEmployeesByDepartment(String departmentName) {
		List<Employee> employees = employeeRepository.getEmployeesByDepartment(departmentName);
		Collections.sort(employees, new EmployeeFirstNameComparator());
		return employees;
	}
	
	/**
	The createDepartment function create a Department object with the employees;
	*/
	public Department createDepartment(String departmentName) {
		
		Department department = new Department();
		department.setDepartmentName(departmentName);
		List<Employee> employees = employeeRepository.getEmployeesByDepartment(departmentName);
		Collections.sort(employees, new EmployeeFirstNameComparator());
		department.setEmployees(employees);
		return department;
	}
	
	/**
	The getDepartmentsWithEmployees function create a List of Departments with the employees;
	*/
	public List<Department> getDepartmentsWithEmployees() {
		
		List<Department> departments = new ArrayList<Department>();
		List<String> departmentNames = 
				new ArrayList<>(new HashSet<>(employeeRepository.getDepartments()));;
				
		for (String d :departmentNames) {
			departments.add(createDepartment(d));
		}
		
		Collections.sort(departments, new DepartmentNameComparator());
		return departments;
	}
}
