package com.util;

import java.util.Comparator;

import com.model.User;

public class UserFirstNameComparator  implements Comparator <User> {

	@Override
	public int compare(User a , User b ) {

		int firstNameComapre = a.getFirstName().compareTo(b.getFirstName());
		
		int lastnameCompare = a.getLastName().compareTo(b.getLastName());
		
			return firstNameComapre == 0 ? lastnameCompare : firstNameComapre;		
	}
}
