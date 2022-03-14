package com.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.model.EmployeeDetails;

@Service
public class BindEmployeeService {

	private InputStringService inputStringService;
	private ManageEmployeeService manageEmployeeService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public BindEmployeeService(InputStringService inputStringService, ManageEmployeeService manageEmployeeService) {
		this.inputStringService = inputStringService;
		this.manageEmployeeService = manageEmployeeService;
	}
	
	
	/**
	The rawEmployees function creating a "RAW" EmployeeDetails array,
	and the "bindEmployee" function will gonna continue to refine
	*/
	String[] rawEmployees() {
		
		String inputFileString = inputStringService.rawString("static/employee.xml");
		String headerCuttedString = createSubString(inputFileString, 38, inputFileString.length());
		String rawEmployees[] = splitElements(headerCuttedString, "<list>|<employee>|<\\/employee>|<\\/list>|\\r|\\n");			
		String filteredRawEmployees[] =	filterEmptyString(rawEmployees);
		log.debug("BindEmployeeService rawEmployees inputFileString: "+ inputFileString);
		return filteredRawEmployees;
	}
	
	
	/**
	The bindEmployee function bind string and string array values to the,
	EmployeeDetails object.
	*/	
	EmployeeDetails bindEmployee(String input) {	
		
		String substr = createSubString(input,6,input.length());
		String employeeSplit[] = splitElements(substr, "</name>");
		String split_firstName_lastName[] = splitElements(employeeSplit[0]," ");
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails
				.setEmployeeFirstName(split_firstName_lastName[0])
				.setEmployeeLastName(split_firstName_lastName[1])
				.setDepartment(splitElements(employeeSplit[1], "<department>|<\\/department>"));
			return employeeDetails;
	}
	
	/**
	This function create a substring,
	and have three args: input string, start char - end char
	*/	
	String createSubString(String input, int start, int end) {			
		String substr = input.substring(start, end); //39 - length
		log.debug("BindEmployeeService createSubString: "+ substr);
			return substr;
	}
	
	
	/**
	The function splitElements is splitting a String object to multiple Strings (Array) with regex
	*/		
	String[] splitElements(String input, String regex) {
		String split [] = input.split(regex);
		log.debug("BindEmployeeService splitElements split 0: "+ split[0].toString());
			return filterEmptyString(split);
	}
	
	/**
	This function filterring the empty strings from the array
	*/
	String[] filterEmptyString( String[] input ) {		
		String[] departments = Arrays.stream(input)
                .filter(value ->
                        value != "" && value.length() > 0
                )
                .toArray(size -> new String[size]);
		return departments;
	}
	
	/**
	Loading the xml file when the "initFileRead" controller endpoit triggered
	*/
	public int initFileRead() {
				
		String filteredEmptyStringRawEmployees[] = filterEmptyString(rawEmployees());
		for(String u : filteredEmptyStringRawEmployees) 
			manageEmployeeService.registerEmployee(bindEmployee(u)); 
		return manageEmployeeService.getEmployees().size();
		}
}