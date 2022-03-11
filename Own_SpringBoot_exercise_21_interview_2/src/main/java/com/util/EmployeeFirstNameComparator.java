package com.util;

import java.util.Comparator;

import com.model.Employee;

public class EmployeeFirstNameComparator  implements Comparator <Employee> {

	@Override
	public int compare(Employee a , Employee b ) {

		int firstNameComapre = a.getFirstName().compareTo(b.getFirstName());
			
			return firstNameComapre;		
	}
}
