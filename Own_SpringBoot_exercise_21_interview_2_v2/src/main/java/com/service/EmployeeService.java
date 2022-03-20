package com.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.EmployeeFirstNameComparator;

@Service
public class EmployeeService {
	

	private EmployeeRepository employeeRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
			
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	/**
	The EmployeeService getEmployees function retrive all employees in a list from  employeeRepository;
	*/
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
			for(EmployeeDetails e : employeeRepository.getEmployeeDetails())
				employees.add(new Employee(e.getFirstName(),e.getLastName()));
			Collections.sort(employees, new EmployeeFirstNameComparator());
		return employees;
	}
	
	/**
	The EmployeeService addEmployee function will add or upadte  EmployeeDetails object in  employeeRepository;
	*/
	String  addEmployee(EmployeeDetails employeeDetails) {
		String func = null; 
		int employeeExistDepartment = -1 , employeeExistIndex = employeeExist(employeeDetails);
		log.debug("ManageEmployeeService addEmployee employeeExistIndex: "+employeeExistIndex);
		if(employeeExistIndex == -1) {
			employeeRepository.addEmployee(employeeDetails);
			log.debug("ManageEmployeeService addEmployee Employee added: "+employeeDetails.toString());
			return func = "User added";
		}
		if(employeeExistIndex != -1) {
			employeeExistDepartment = departmentExistForEmployee(employeeDetails.getDepartments()[0],employeeExistIndex);
			log.debug("ManageEmployeeService addEmployee employeeExistDepartment: "+employeeExistDepartment);
		}
		if(employeeExistDepartment != 1) {
			employeeRepository.getEmployeeDetails()
			.get(employeeExistIndex)
					.setDepartments(addDepartmentToEmployee(employeeDetails.getDepartments()[0],employeeExistIndex));
			return func = "department added to user";
		}
		return func;
	}
	
	/**
	The EmployeeService employeeExist function chech if Employee already added to repository;
	*/
	int employeeExist(EmployeeDetails employeeDetails) {
		
		int employeeExist = -1;
		for (EmployeeDetails e :employeeRepository.getEmployeeDetails())
			if(e.getFirstName().equals(employeeDetails.getFirstName()) && 
					e.getLastName().equals(employeeDetails.getLastName()))
				employeeExist = employeeRepository.getEmployeeDetails().indexOf(e);
		log.debug("ManageEmployeeService employeeExist: "+employeeExist);
		return employeeExist;

	}
	
	/**
	The EmployeeService departmentExistForEmployee function chech if EmployeeDetails object
	already have, the department in the departments array;
	*/
	int departmentExistForEmployee(String departmentName , int employeeIndex) {
		
		int employeeDepartment = -1;
		EmployeeDetails e = employeeRepository.getEmployeeDetails().get(employeeIndex);
		for (String d : e.getDepartments())
			if(d.equals(departmentName))
				employeeDepartment = 1;
		log.debug("ManageEmployeeService departmentExistForEmployee: "+employeeDepartment);
				return employeeDepartment;		
	}
	
	/**
	The EmployeeService addDepartmentToEmployee function, 
	add department to departments of an EmployeeDetails;
	*/
	String[] addDepartmentToEmployee(String departmentName , int employeeIndex) {
		EmployeeDetails e = employeeRepository.getEmployeeDetails().get(employeeIndex);
		String oldDeparments[] = e.getDepartments();
		String newDeparments[] = new String[oldDeparments.length+1];
		for(int i = 0; i < oldDeparments.length; i++ )
			newDeparments[i] = oldDeparments[i];
		newDeparments[newDeparments.length-1] = departmentName;
			return newDeparments;
	}
	
	/**
	The EmployeeService getEmployeesByDepartment function 
	create list list of Employee filtered by departmentName;
	*/
	public List<Employee> getEmployeesByDepartment(String departmentName) {
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeDetails e :employeeRepository.getEmployeeDetails() ) {			
			String departments[] = e.getDepartments();		
				for(int i = 0; i < departments.length; i++) {
					String depart = departments[i];
					if(depart.equals(departmentName)) {
						employees.add(new Employee(e.getFirstName(),e.getLastName()));
				 }
			 }				 
		}
		Collections.sort(employees, new EmployeeFirstNameComparator());
		return employees;
	}
}