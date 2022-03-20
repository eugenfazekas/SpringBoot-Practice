package com.model;

import java.util.Arrays;
import java.util.Objects;

public class EmployeeDetails extends Employee {

	private String departments[];
		
	public EmployeeDetails() {
	}
	


	public String[] getDepartments() {
		return departments;
	}
	
	public EmployeeDetails setDepartments(String[] department) {
		this.departments = department;
		return this;
	}



	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		return Objects.equals(getFirstName(), other.getFirstName()) && Objects.equals(getLastName(), other.getLastName());
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", department="
				+ Arrays.toString(departments) + "]";
	}
}
