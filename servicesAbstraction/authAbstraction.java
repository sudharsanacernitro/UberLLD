package com.uberLLD.demo.servicesAbstraction;

public abstract class authAbstraction {
	
	public void createUser(String userName , String passWord)
	{
		System.out.println("This methode is not supported for this user");
	}
	
	public abstract int login(String userName , String passWord);
	
}
