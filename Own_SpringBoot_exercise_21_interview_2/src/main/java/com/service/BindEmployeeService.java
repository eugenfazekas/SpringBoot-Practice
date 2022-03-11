package com.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.model.Department;
import com.model.EmployeeDetails;
import com.model.Employee;

@Service
public class BindEmployeeService {

	private InputStringService inputStringService;
	private ManageEmployeeService manageEmployeeService;

	public BindEmployeeService(InputStringService inputStringService, ManageEmployeeService manageEmployeeService) {
		this.inputStringService = inputStringService;
		this.manageEmployeeService = manageEmployeeService;
		
		/*
		String filteredEmptyStringRawEmployees[] = filterEmptyString(rawEmployees());
			for(String u : filteredEmptyStringRawEmployees) 
				manageEmployeeService.addEmployee(bindEmployee(u)); 
			for (Employee  e :  manageEmployeeService.getEmployees())
				System.out.println(e.toString());	
			manageEmployeeService.initDepartments();
			for ( Department d : manageEmployeeService.getDepartmentsWithEmployees())
				System.out.println(d);
				*/
	}
	
	String[] rawEmployees() {
		
		String inputFileString = inputStringService.rawString("static//employee.xml");
		String headerCuttedString = createSubString(inputFileString, 39, inputFileString.length());
		String rawEmployees[] = splitElements(headerCuttedString, "<list>|<employee>|<\\/employee>|<\\/list>|\\r|\\n");			
		String filteredRawEmployees[] =	filterEmptyString(rawEmployees);
		return filteredRawEmployees;
	}
	
	EmployeeDetails bindEmployee(String input) {	
		
		System.out.println("bindEmployee input: "+input);
		String substr = createSubString(input,6,input.length());
		String employeeSplit[] = splitElements(substr, "</name>");
		String split_firstName_lastName[] = splitElements(employeeSplit[0]," ");
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails
				.setEmployeeFirstName(split_firstName_lastName[0])
				.setEmployeeLastName(split_firstName_lastName[1])
				.setDepartment(splitDepartments(employeeSplit[1]));
			return employeeDetails;
	}
	
	String createSubString(String input, int start, int end) {			
		String substr = input.substring(start, end); //39 - length
			return substr;
	}
	
	
	String[] splitElements(String input, String regex) {
		String split [] = input.split(regex);
			return split;
	}

	
	String[] filterEmptyString( String[] input ) {		
		String[] departments = Arrays.stream(input)
                .filter(value ->
                        value != "" && value.length() > 0
                )
                .toArray(size -> new String[size]);
		return departments;
	}
	
	
	String[] splitDepartments(String input) {
		String[] temp_department = splitElements(input, "<department>|<\\/department>");
			return filterEmptyString(temp_department);
	} 
}