package com.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "JUZERS")
public class User {

	@NotNull
	@Column(unique=true)
	@Id
	private String userid;
	
	@NotNull
	@Column(unique=true)
	private String username;
	
	@NotNull
	@Column(unique=true)
	private String email;
	
	private int age;
	private String gender;
	private int orderscount;
	
	
	public User() {
	}

	public User(String userid, String username, String email, int age, String gender, int orderscount) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.orderscount = orderscount;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getOrderscount() {
		return orderscount;
	}

	public void setOrderscount(int orderscount) {
		this.orderscount = orderscount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userid, other.userid);
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", orderscount=" + orderscount + "]";
	}
}
