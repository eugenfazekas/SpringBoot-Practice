package com.util;

import java.util.Comparator;

import com.model.Department;

public class DepartmentNameComparator  implements Comparator <Department> {

	@Override
	public int compare(Department a , Department b ) {

		int departmentName = a.getDepartmentName().compareTo(b.getDepartmentName());
	
			return departmentName;		
	}
}
