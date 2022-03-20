package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Department;
import com.model.Employee;
import com.repository.EmployeeRepository;
import com.service.DepartmentService;
import com.service.EmployeeService;

@RestController
@RequestMapping("rest/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public EmployeeController(EmployeeService employeeService, DepartmentService departmentService,
			EmployeeRepository employeeRepository) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesByDepartment(@RequestParam(required=false) String department) {	
		return department != null ? employeeService.getEmployeesByDepartment(department) :
			employeeService.getEmployees();
	}

	@RequestMapping(value = "groupby/department",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getDepartmentsWithEmployees() {
		return departmentService.getDepartmentsWithEmployees();
	}
}
 