package com.uberLLD.demo.repo;

import com.uberLLD.demo.models.customer;
import java.util.HashMap;

public class customerRepo {
	
	HashMap<Integer,customer> customerDB;
	
	public customerRepo()
	{
		customerDB = new HashMap<>();
		
		customerDB.put(1, new customer(1,"Ram","1234"));
		customerDB.put(2, new customer(2,"sam","sam123"));
		customerDB.put(3, new customer(3,"somu","somu123"));
		
	}
	
	public boolean createUser(String userName , String passWord)
	{

		int client = customerDB.size()+1;
		
		if(customerDB.containsKey(client)) return false;
		
		customerDB.put(client, new customer(client ,userName , passWord));
		
		return true;
	}
	
	public int isUser(String name , String password)
	{
		for(customer currCustomer : customerDB.values())
		{
			if(currCustomer.getCustomerName().equals(name) && currCustomer.getCustomerPassword().equals(password))
				return currCustomer.getCustomerId();
		}
		
		return -1;
	}
	
	

}
