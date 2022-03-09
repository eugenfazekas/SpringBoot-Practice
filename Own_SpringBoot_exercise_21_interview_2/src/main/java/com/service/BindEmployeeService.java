package com.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.model.Employee;
import com.model.User;

@Service
public class BindEmployeeService {

	private InputStringService inputStringService;
	private ManageEmployeeService manageEmployeeService;

	public BindEmployeeService(InputStringService inputStringService,
								ManageEmployeeService manageEmployeeService) {
		this.inputStringService = inputStringService;
		this.manageEmployeeService = manageEmployeeService;
		String filteredEmptyStringRawUsers[] = filterEmptyString(rawUsers());
			for(String u : filteredEmptyStringRawUsers) 
				manageEmployeeService.addEmployees(bindedUser(u)); 
			for (User  e :  manageEmployeeService.getEmployees())
				System.out.println(e.toString());			
	}
	
	private String[] rawUsers() {
		
		String inputFileString = inputStringService.rawString();
		String headerCuttedString = createSubString(inputFileString, 39, inputFileString.length());
		String rawUsers[] = splitElements(headerCuttedString, "<list>|<employee>|<\\/employee>|<\\/list>");
			
		return rawUsers;
	}
	
	private Employee bindedUser(String input) {	
		
		String substr = createSubString(input,6,input.length());
		String userSplit[] = splitElements(substr, "</name>");
		String split_firstName_lastName[] = splitElements(userSplit[0]," ");
		
		Employee employee = new Employee();
		employee
				.setEmployeeFirstName(split_firstName_lastName[0])
				.setEmployeeLastName(split_firstName_lastName[1])
				.setDepartment(departments(userSplit[1]));
			return employee;
	}
	
	public String createSubString(String input, int start, int end) {			
		String substr = input.substring(start, end); //39 - length
			return substr;
	}
	
	
	private String[] splitElements(String input, String regex) {
		String split [] = input.split(regex);
			return split;
	}

	
	private String[] filterEmptyString( String[] input ) {		
		String[] departments = Arrays.stream(input)
                .filter(value ->
                        value != "" && value.length() > 0
                )
                .toArray(size -> new String[size]);
		return departments;
	}
	
	private String[] departments(String input) {
		String[] temp_department = splitElements(input, "<department>|<\\/department>");
			return filterEmptyString(temp_department);
	} 
}