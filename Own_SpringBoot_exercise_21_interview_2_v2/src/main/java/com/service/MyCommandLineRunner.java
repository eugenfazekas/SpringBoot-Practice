package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private BindEmployeeService bindEmployeeService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public MyCommandLineRunner(EmployeeService employeeService, DepartmentService departmentService,
			BindEmployeeService bindEmployeeService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
		this.bindEmployeeService = bindEmployeeService;
	}

	@Override
	public void run(String... args) throws Exception {

		initFileRead();
	}
	
	/**
	Loading the xml file when the "initFileRead" controller endpoit triggered
	*/
	public void initFileRead() {
				
		String filteredEmptyStringRawEmployees[] = bindEmployeeService.filterEmptyString(bindEmployeeService.rawEmployees());
		for(String u : filteredEmptyStringRawEmployees) 
			employeeService.addEmployee(bindEmployeeService.bindEmployee(u)); 
		departmentService.initDepartments();
		log.debug("MyCommandLineRunner initFileRead getEmployees().size() is: "+employeeService.getEmployees().size());
		}

}
