package com.model;

import java.util.List;
import java.util.Objects;

public class Department {

	private String departmentName;
	private List<Employee> employees;
	
	public Department() {}

	public Department(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Department(String departmentName, List<Employee> employees) {
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	@Override
	public int hashCode() {
		return Objects.hash(departmentName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentName, other.departmentName);
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", employees=" + employees + "]";
	}
}
