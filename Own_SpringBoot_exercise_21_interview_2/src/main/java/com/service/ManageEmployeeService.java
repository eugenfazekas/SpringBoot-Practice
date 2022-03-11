package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.model.Department;
import com.model.EmployeeDetails;
import com.model.Employee;
import com.repository.EmployeeRepository;
import com.util.DepartmentNameComparator;
import com.util.EmployeeFirstNameComparator;

@Service
public class ManageEmployeeService {
	

	private EmployeeRepository employeeRepository;
			
	public ManageEmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	public String addEmployee(EmployeeDetails employee) {
		String addEmployees = null;
		if (employeeExist(employee) == 0) {
			employeeRepository.addEmployee(employee);
			addEmployees = "addEmployees";
		}
		return addEmployees;
	}

	public String initDepartments() {
		String initDepartments = "initDepartments";
		for(EmployeeDetails e : employeeRepository.getEmployeeDetails()) {
			String departments[] = e.getDepartment();
				for(int i = 0; i < departments.length; i++ ) {
					if(departmentExist(departments[i]) == 0) {
						addDepartment(departments[i]);
					}
				}
		}		
		return initDepartments;
	}
	
	public String addDepartment(String department) {
		String addDepartment = null;
		if(departmentExist(department) == 0)
			employeeRepository.addDepartment(new Department(department,getEmployeesByDepartment(department)));
		return addDepartment;
	}
	
	public int employeeExist(EmployeeDetails employee) {		
		int employeeCheck = 0 ;
		for (EmployeeDetails e : employeeRepository.getEmployeeDetails()) {
			if(e.getEmployeeFirstName().equals(employee.getEmployeeFirstName()) &&
			   e.getEmployeeLastName().equals(employee.getEmployeeLastName()))
				employeeCheck = 1;
		}
		return employeeCheck;
	}
	
	public int departmentExist(String department) {		
		int departmentCheck = 0;
		for (Department d : employeeRepository.getDepartments())
			if(department.equals(d.getDepartmentName()))
				departmentCheck = 1;
		return departmentCheck;
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
			for(EmployeeDetails e : employeeRepository.getEmployeeDetails())
				employees.add(employeeDetailsToEmployee(e));
			Collections.sort(employees, new EmployeeFirstNameComparator());
		return employees;
	}
	
	public List<Employee> getEmployeesByDepartment(String departmentName) {
		Set<Employee> employees = new HashSet<>();
		for(EmployeeDetails e :employeeRepository.getEmployeeDetails() ) {			
			String departments[] = e.getDepartment();		
				for(int i = 0; i < departments.length; i++) {
					String depart = departments[i];
					if(depart.equals(departmentName)) {
						employees.add(employeeDetailsToEmployee(e));
				 }
			 }				 
		}
		return hashSetToList(employees);
	}
	
	public List<Department> getDepartmentsWithEmployees() {
		List<Department> departments = employeeRepository.getDepartments();
		Collections.sort(departments, new DepartmentNameComparator());
		return departments;
	}
	
	public Employee employeeDetailsToEmployee(EmployeeDetails e) {
		Employee employee = new Employee();
		employee.setFirstName(e.getFirstName());
		employee.setLastName(e.getLastName());
		return employee;
	}
	
	public List<Employee> hashSetToList(Set<Employee> set) {			
		List<Employee> newList = new ArrayList<Employee>(set);
		Collections.sort(newList, new EmployeeFirstNameComparator());
			return newList;
	}
}
