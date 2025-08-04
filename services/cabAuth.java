package com.uberLLD.demo.services;

import com.uberLLD.demo.servicesAbstraction.authAbstraction;
import com.uberLLD.demo.repo.cabRepo;


public class cabAuth  extends authAbstraction{
	
	cabRepo cabrepo;
	
	public cabAuth(cabRepo cabrepo)
	{
		this.cabrepo = cabrepo;
	}
	
	@Override
	public int login(String userName , String passWord)
	{
		if(userName.length() == 0 && passWord.length() == 0 ) 
		{
			System.out.println("Enter userName and Password");
			return -1;
		}

		int cabId = cabrepo.isUser(userName, passWord);

		if( cabId != -1)
		{
			System.out.println("User Logged in");
			return cabId;
		}
		
		System.out.println("User not found");

		return -1;
	}

}
