package com.cg.goa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "user_data")
public class Userdata implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "user_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "user_Name")
	private String userName;

	@Column(name = "user_Type")
	private String userType;

	@Column(name = "user_Password")
	private String userPassword;
	/*
	 * A default Constructor with no implementation
	 */

	public Userdata() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public Userdata(String userName, Integer userId, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return String.format("Userdata [userId=%s, userName=%s, userType=%s, userPassword=%s]", userId, userName,
				userType, userPassword);
	}

}
