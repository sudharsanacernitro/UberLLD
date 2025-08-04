package services;

import java.util.List;

import repo.cabRepo;
import repo.customerRepo;

import models.cab;
import java.util.Scanner;

import servicesAbstraction.bookingInterface;

public class bookingService implements bookingInterface {
	
	cabRepo cab;
	customerRepo customer;
	private int amountPerKilometer = 10;
	Scanner sc = new Scanner(System.in);
	
	public bookingService(cabRepo cab , customerRepo customer)
	{
		this.cab = cab;
		this.customer = customer;
	}
	
	public boolean bookCab(int source , int destination)
	{
		
		int distance = Math.abs(source-destination);
		
		int amount = distance * amountPerKilometer;
		
		displayAvailableCabs();
		System.out.println("Amount for the ride: "+amount);
		System.out.println("Press enter to confirm");
		sc.nextLine();
		
		if( allocateCab(source , destination) )
		{
			System.out.println("Cab ordered");
			return true;
		}
		
		System.out.println("No Cabs Available");
		
		return false;
		
	}
	
	private void displayAvailableCabs()
	{
		List<cab> cabs = cab.getListOfCabs();
		
		System.out.println(" -----------------------------------");
		System.out.println("| Available Cabs | Current Location |");
		System.out.println(" -----------------------------------");
		
		for(cab currCab : cabs)
		{
			if(currCab.isAvailable())
			{
				System.out.println("|     "+currCab.getId()+"       |    "+currCab.getCurrLocation()+"      |");
				System.out.println(" -----------------------------------");
			}
		}
		
		System.out.println();
	
	}
	
	private boolean allocateCab(int source , int destination)
	{
		List<cab> cabs = cab.getListOfCabs();
		
		int minDistance = Integer.MAX_VALUE;
		cab selectedCab = null;
		
		for(cab currCab : cabs)
		{
			if(Math.abs( source - currCab.getCurrLocation() ) < minDistance && currCab.isAvailable())
			{
				selectedCab = currCab;
				minDistance = Math.abs( source - currCab.getCurrLocation() ) ;
			}
		}
		
		if(selectedCab != null)
		{
			cab.updateLocation(selectedCab.getId(), destination );
			return true;
		}
		
		return false;
			
	}

}
