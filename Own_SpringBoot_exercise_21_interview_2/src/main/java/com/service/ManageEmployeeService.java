package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.model.Employee;
import com.model.User;
import com.util.UserFirstNameComparator;

@Service
public class ManageEmployeeService {
	
	private Set<User> users;
	private Set<Employee> employees = new HashSet<Employee>();

	
	public void addEmployees(Employee employee) {
		employees.add(employee);
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public List<User> getEmployeesList(){
		users = new HashSet<>();
		
		for(Employee e : employees) {
			User user = new User();
			user.setFirstName(e.getEmployeeFirstName());
			user.setLastName(e.getEmployeeLastName());
			users.add(user);
		}	
		
		List<User> usersList = fromHashSetToArrayList(users);
		Collections.sort(usersList, new UserFirstNameComparator());
			return usersList;
	}
		
	public List<User> getEmployeesByDepartment(String departmentName) {
		String depart = "";
		users = new HashSet<>();
		for(Employee e :employees ) {			
			String departments[] = e.getDepartment();		
				for(int i = 0; i < departments.length; i++) {
					System.out.println("departments[i]: "+departments[i]+" departmentName: "+ departmentName);
					depart = departments[i];
					if(depart.equals(departmentName)) {
						User user = new User();
						user.setFirstName(e.getFirstName());
						user.setLastName(e.getLastName());
						users.add(user);
				 }
			 }				 
		}
		List<User> usersList = fromHashSetToArrayList(users);
		Collections.sort(usersList, new UserFirstNameComparator());
			return usersList;
	}
	
	public Set<String> getDepartment() {		
		Set<String> departments = new HashSet<>();	
		for(Employee e :employees ) {
			String dep[] =  e.getDepartment();
			for(int i = 0; i < dep.length; i++)
				departments.add(dep[i]);
		}
			return departments;
	}
	
	public List<User> fromHashSetToArrayList(Set<User> users) {
		List<User> filtered_users = new ArrayList<>(users);
			return filtered_users;
	}
}
