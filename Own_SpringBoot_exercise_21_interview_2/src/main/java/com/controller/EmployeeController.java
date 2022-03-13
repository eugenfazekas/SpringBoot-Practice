package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Department;
import com.model.Employee;
import com.service.BindEmployeeService;
import com.service.ManageEmployeeService;

@RestController
@RequestMapping("rest/employees")
public class EmployeeController {
	
	private ManageEmployeeService manageEmployeeService;
	private BindEmployeeService bindEmployeeService;
	


	public EmployeeController(ManageEmployeeService manageEmployeeService, BindEmployeeService bindEmployeeService) {
		super();
		this.manageEmployeeService = manageEmployeeService;
		this.bindEmployeeService = bindEmployeeService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesByName() {
		return manageEmployeeService.getEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesByDepartment(@RequestParam("department") String department) {		
		return manageEmployeeService.getEmployeesByDepartment(department);
	}

	@RequestMapping(value = "groupby/department",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getDepartmentsWithEmployees() {
		return manageEmployeeService.getDepartmentsWithEmployees();
	}
	
	@RequestMapping(value = "initFileRead",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int initFileRead() {
		return bindEmployeeService.initFileRead();
	}
}
 