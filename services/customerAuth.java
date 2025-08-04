package services;

import repo.customerRepo;
import servicesAbstraction.authAbstraction;

public class customerAuth extends authAbstraction{
	
	customerRepo cusRepo;
	
	public customerAuth(customerRepo cusRepo)
	{
		this.cusRepo = cusRepo;
	}
	
	@Override
	public void login(String userName , String passWord)
	{
		if(userName.length() == 0 && passWord.length() == 0 ) 
		{
			System.out.println("Enter userName and Password");
			System.exit(0);
		}
		
		if(cusRepo.isUser(userName, passWord))
		{
			System.out.println("User Logged in");
			return;
		}
		
		System.out.println("User not found");
		System.exit(0);

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
