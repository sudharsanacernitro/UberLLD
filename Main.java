package com.uberLLD.demo;

import java.util.*;

import com.uberLLD.demo.servicesAbstraction.authAbstraction;
import com.uberLLD.demo.servicesAbstraction.bookingInterface;

import com.uberLLD.demo.repo.customerRepo;
import com.uberLLD.demo.repo.cabRepo;
import com.uberLLD.demo.repo.historyRepo;


import com.uberLLD.demo.services.customerAuth;
import com.uberLLD.demo.services.cabAuth;

import com.uberLLD.demo.services.bookingService;


class Main
{
	static Scanner sc = new Scanner(System.in);
	static int userLoggedIn = -1;
	static int userId = -1;
	
    public static void main()
    {
		System.out.println("started");
    	
    	customerRepo cusRepo = new customerRepo();
    	cabRepo cabrepo = new cabRepo();
		historyRepo history = new historyRepo();
    	
    	customerAuth customerAuthenticationService = new customerAuth(cusRepo);
    	cabAuth cabAuthentication = new cabAuth(cabrepo);
    	bookingService booking = new bookingService(cabrepo , cusRepo , history);
    	
    	    	
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
    		userId = authService.login(userName, passWord);
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
		
		booking.bookCab(source, destination , userId);
    }
}