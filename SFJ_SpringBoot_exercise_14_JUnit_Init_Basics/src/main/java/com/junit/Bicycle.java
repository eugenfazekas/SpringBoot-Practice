package com.junit;

public class Bicycle {
	
	DataBaseConnection dbCon;
	
	public Bicycle() {
	}

	public Bicycle(DataBaseConnection dbCon) {

		this.dbCon = dbCon;
	}

	public int sum(int a ,int b, int c ) {
		return a+b+c;
	}
	
	public Integer sum2(String user, String password, int a, int b ,int c) {
	
		boolean checkUser = dbCon.checkUserPass(user, password);
		if(checkUser)
			return a+b+c;
		
		return null;
	}
}
