package com.uberLLD.demo.services;

import com.uberLLD.demo.repo.customerRepo;
import com.uberLLD.demo.servicesAbstraction.authAbstraction;

public class customerAuth extends authAbstraction{
	
	customerRepo cusRepo;
	
	public customerAuth(customerRepo cusRepo)
	{
		this.cusRepo = cusRepo;
	}
	
	@Override
	public int login(String userName , String passWord)
	{
		if(userName.length() == 0 && passWord.length() == 0 ) 
		{
			System.out.println("Enter userName and Password");
			System.exit(0);
		}
		int customerId = cusRepo.isUser(userName, passWord);

		if( customerId != -1)
		{
			System.out.println("User Logged in");
			return customerId;
		}
		
		System.out.println("User not found");
		System.exit(0);

		return -1;

	}
	
	@Override
	public void createUser(String userName , String passWord)
	{
		if(userName.length() == 0 && passWord.length() == 0 ) 
		{
			System.out.println("Enter userName and Password");
			System.exit(0);

		}
		
		boolean isUserCreated = cusRepo.createUser(userName , passWord);
		
		if(isUserCreated)
		{
			System.out.println("User Created");
		}
		else
		{
			System.out.println("User already found");
			System.exit(0);

		}
			
	}

}
