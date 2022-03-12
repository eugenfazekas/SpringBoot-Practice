package com.model;

import java.util.Arrays;
import java.util.Objects;

public class EmployeeDetails extends Employee {

	private String department[];
		
	public EmployeeDetails() {
	}
	
	public String getEmployeeFirstName() {
		return getFirstName();
	}

	public EmployeeDetails setEmployeeFirstName(String firstName) {
		super.setFirstName(firstName);
			return this;
	}

	public String getEmployeeLastName() {
		return getLastName();
	}

	public EmployeeDetails setEmployeeLastName(String lastName) {
		super.setLastName(lastName);
			return this;
	}

	public String[] getDepartment() {
		return department;
	}
	
	public EmployeeDetails setDepartment(String[] department) {
		this.department = department;
		return this;
	}



	@Override
	public int hashCode() {
		return Objects.hash(getEmployeeFirstName(), getEmployeeLastName());
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
				+ Arrays.toString(department) + "]";
	}
}
