package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.ManageEmployeeService;

@RestController
@RequestMapping("rest/employees")
public class EmployeeController {
	
	private ManageEmployeeService manageEmployeeService;
	
	public EmployeeController(ManageEmployeeService manageEmployeeService) {
		this.manageEmployeeService = manageEmployeeService;
	}


	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getEmployeesByName() {
		return manageEmployeeService.getEmployeesList();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> listusersByDepartment(@RequestParam String department) {		
		return manageEmployeeService.getEmployeesByDepartment(department);
	}	
}
