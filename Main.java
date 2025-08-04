import java.util.*;

import servicesAbstraction.authAbstraction;
import servicesAbstraction.bookingInterface;

import repo.customerRepo;
import repo.cabRepo;


import services.customerAuth;
import services.cabAuth;

import services.bookingService;


class Main
{
	static Scanner sc = new Scanner(System.in);
	static int userLoggedIn = -1;
	
    public static void main(String[] args)
    {
    	
    	customerRepo cusRepo = new customerRepo();
    	cabRepo cabrepo = new cabRepo();
    	
    	customerAuth customerAuthenticationService = new customerAuth(cusRepo);
    	cabAuth cabAuthentication = new cabAuth(cabrepo);
    	bookingService booking = new bookingService(cabrepo , cusRepo);
    	
    	    	
    	// Authentication
    	
    	System.out.println("Choose a role");
    	System.out.println("1. customer");
    	System.out.println("2. CabDriver");
    	int role = sc.nextInt();
    	
    	if( role == 1)
    	{
    		Auth(customerAuthenticationService);
    		userLoggedIn = 1;
    	}
    	else if( role == 2)
    	{
    		Auth(cabAuthentication);
    		userLoggedIn = 2;
    	}
    	else {
    		System.out.println("Invalid option");
    		System.exit(0);
    	}
    	
    	while (true)
    	{
    		System.out.println("Choose an option");
        	
        	if(role == 1)
        	System.out.println("1. book a cab");
        	
        	int option = sc.nextInt();
        	
        	switch( option )
        	{
        	case 1:
        		book(booking);
     
        	}
        	
    	}
    	
    	
    	
    }
    
    public static void Auth(authAbstraction authService)
    {
    	System.out.println("Choose the option");
    	System.out.println("1. Login");
    	System.out.println("2. SignUp");
    	
    	int methode = sc.nextInt();
    	
    	System.out.println("Enter UserName");
		String userName = sc.next();
		
		System.out.println("Enter Password");
		String passWord = sc.next();
    	
    	if(methode == 1)
    	{
    		authService.login(userName, passWord);
    	}
    	else if(methode == 2)
    	{
    		authService.createUser(userName, passWord);
    	}
    	else
    	{
    		System.out.println("Invalid Option");
    		System.exit(0);
    	}
    }
    
    public static void book(bookingInterface booking)
    {
    	System.out.println("Enter Source");
		int source = sc.nextInt();
		
		System.out.println("Enter Destination");
		int destination = sc.nextInt();
		
		booking.bookCab(source, destination);
    }
}