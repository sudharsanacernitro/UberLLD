package com.uberLLD.demo.services;

import java.util.List;

import com.uberLLD.demo.repo.cabRepo;
import com.uberLLD.demo.repo.customerRepo;
import com.uberLLD.demo.repo.historyRepo;

import com.uberLLD.demo.models.cab;
import com.uberLLD.demo.models.historyModel;

import java.util.Scanner;

import com.uberLLD.demo.servicesAbstraction.bookingInterface;

public class bookingService implements bookingInterface {
	
	cabRepo cab;
	customerRepo customer;
	historyRepo history;

	private int amountPerKilometer = 10;
	Scanner sc = new Scanner(System.in);
	
	public bookingService(cabRepo cab , customerRepo customer , historyRepo history)
	{
		this.cab = cab;
		this.customer = customer;
		this.history = history;
	}

	@Override
	public boolean bookCab(int source, int destination , int customerId) {

		int distance = Math.abs(source-destination);

		int amount = distance * amountPerKilometer;

		displayAvailableCabs();
		System.out.println("Amount for the ride: "+amount);
		System.out.println("Press enter to confirm");
		sc.nextLine();

		if( allocateCab( customerId , source , destination) )
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
	
	private boolean allocateCab(int customerId , int source , int destination)
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

			int cost =  Math.abs(source - destination)*amountPerKilometer ;
			history.addRecord(new historyModel(selectedCab.getId() , customerId ,source , destination , cost , (30/100) *cost  ));
			return true;
		}
		
		return false;
			
	}


}
