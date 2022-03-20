package com.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Department;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.DepartmentNameComparator;

@Service
public class DepartmentService {
	
	private EmployeeRepository employeeRepository;
	private EmployeeService employeeService;

	
	public DepartmentService(EmployeeRepository employeeRepository, EmployeeService employeeService) {
		this.employeeRepository = employeeRepository;
		this.employeeService = employeeService;
	}

	/**
	The DepartmentService initDepartments function 
	create-ing list of Deparment objects by EmployeeDetails Deparment list;
	*/
	public int initDepartments() {
		int initDepartments = 0;
		for(EmployeeDetails e : employeeRepository.getEmployeeDetails()) {
			String departments[] = e.getDepartments();
				for(int i = 0; i < departments.length; i++ ) {
					if(departmentExist(departments[i]) == 0) {
						addDepartment(departments[i]);
						initDepartments++;
					}
				}
		}		
		return initDepartments;
	}
	
	/**
	The DepartmentService addDepartment function, 
	adding Department object to repositoryl
	*/
	public String addDepartment(String department) {
		String addDepartment = null;
		if(departmentExist(department) == 0)
			addDepartment =	employeeRepository.addDepartment(new Department(department,employeeService.getEmployeesByDepartment(department)));
		return addDepartment;
	}
	
	/**
	The DepartmentService departmentExist function chech if Deparment already added to repository;
	*/
	public int departmentExist(String department) {		
		int departmentCheck = 0;
		for (Department d : employeeRepository.getDepartments())
			if(department.equals(d.getDepartmentName()))
				departmentCheck = 1;
		return departmentCheck;
	}
	
	/**
	The DepartmentService getDepartmentsWithEmployees function,
	create a list of Departments called from repository;
	*/
	public List<Department> getDepartmentsWithEmployees() {
		List<Department> departments = employeeRepository.getDepartments();
		Collections.sort(departments, new DepartmentNameComparator());
		return departments;
	}
}
