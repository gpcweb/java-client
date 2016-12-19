package com.example;

public class User {
	private String userName;
	private String image;

	public User(String userName, String image) {
		this.userName = userName;
		this.image    = image;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public void setImage(String image){
		this.image = image;
	}

	public String getUserName(){
		return userName;
	}
	
	public String getImage(){
		return image;
	}

	public User() {
	}
}