package com.brunolima.quarkus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;

	private String userName;

	private String password;

	private String role;
	
	public Integer getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		this.role = (userName.equals("admin")) ? "admin" : "user";
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
