package com.brunolima.quarkus.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@UserDefinition
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;

	@Username
	private String userName;

	@Password
	private String password;

	@Roles
	private String role;
	
	@JsonbTransient
	public Integer getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	@JsonbTransient
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
		this.password = BcryptUtil.bcryptHash(password);
	}

}