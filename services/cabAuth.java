package services;

import servicesAbstraction.authAbstraction;
import repo.cabRepo;


public class cabAuth  extends authAbstraction{
	
	cabRepo cabrepo;
	
	public cabAuth(cabRepo cabrepo)
	{
		this.cabrepo = cabrepo;
	}
	
	@Override
	public void login(String userName , String passWord)
	{
		if(userName.length() == 0 && passWord.length() == 0 ) 
		{
			System.out.println("Enter userName and Password");
			return;
		}
		
		if(cabrepo.isUser(userName, passWord))
		{
			System.out.println("User Logged in");
			return;
		}
		
		System.out.println("User not found");
	}

}
