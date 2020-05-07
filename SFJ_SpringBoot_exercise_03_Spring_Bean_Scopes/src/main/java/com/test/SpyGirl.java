package com.test;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class SpyGirl {

	public String iSaySomething() {
		return "En egy kem vagyok";
	}
	
}
