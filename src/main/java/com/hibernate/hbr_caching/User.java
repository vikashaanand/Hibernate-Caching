package com.hibernate.hbr_caching;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private int userId;
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userPassword = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + "]";
	}

}
