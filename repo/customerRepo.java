package repo;

import models.customer;
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
	
	public boolean createUser(customer user)
	{
		int client = user.getCustomerId();
		
		if(customerDB.containsKey(client)) return false;
		
		customerDB.put(user.getCustomerId(), user);
		
		return true;
	}
	
	public boolean isUser(String name , String password)
	{
		for(customer currCustomer : customerDB.values())
		{
			if(currCustomer.getCustomerName().equals(name) && currCustomer.getCustomerPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
	

}
