package com.uberLLD.demo.models;

public class cab {
	
	private int id;
	private String name;
	private String password;
	private int currLocation;
	private boolean isAvailable;
	
	public cab(int id, String name, String password, int currLocation, boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.currLocation = currLocation;
		this.isAvailable = isAvailable;
	}
	
	
	public String getPassword() { // getting the HashedPasswrod
		return password;
	}
	public void setPassword(String password) {  // Hashing the password
		
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public int getCurrLocation() {
		return currLocation;
	}
	public void setCurrLocation(int currLocation) {
		this.currLocation = currLocation;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
