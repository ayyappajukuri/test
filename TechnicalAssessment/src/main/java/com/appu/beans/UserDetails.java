package com.appu.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

	
	
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String userPassword;
	private String userFullName;
	private int phoneNumber;
	
	
	public UserDetails(int id, String userName, String userPassword, String userFullName, int phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFullName = userFullName;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public UserDetails() {
		super();
	}
	
	public UserDetails(int id, String userName, String userFullName) {
		super();
		this.id = id;
		this.userName = userName;
		this.userFullName = userFullName;
	}
	public UserDetails(String userName, String userFullName) {
		super();
		this.userName = userName;
		this.userFullName = userFullName;
	}

	
}
