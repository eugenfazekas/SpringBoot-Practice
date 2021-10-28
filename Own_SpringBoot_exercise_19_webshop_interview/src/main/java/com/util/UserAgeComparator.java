package com.util;

import java.util.Comparator;

import com.model.User;

public class UserAgeComparator  implements Comparator<User> {

	@Override
	public int compare(User a , User b ) {

		return b.getAge() - a.getAge();
	}
}
