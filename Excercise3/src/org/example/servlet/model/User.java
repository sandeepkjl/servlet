package org.example.servlet.model;

public class User {
	
	private String userId;
	private String password;
	private String username;
	private String userAddress;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String userId, String password, String username, String userAddress) {
		super();
		this.userId = userId;
		this.password = password;
		this.username = username;
		this.userAddress = userAddress;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", username=" + username + ", userAddress="
				+ userAddress + "]";
	}
	
	
	
	

}
