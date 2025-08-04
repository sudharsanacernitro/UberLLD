package com.uberLLD.demo.services;

import com.uberLLD.demo.models.historyModel;
import com.uberLLD.demo.repo.historyRepo;

import com.uberLLD.demo.servicesAbstraction.historyAbstraction;

import java.util.List;



public class adminHistoryService implements  historyAbstraction {

    historyRepo history;

    public adminHistoryService(historyRepo history)
    {
        this.history = history;
    }

    @Override
    public void getHistory(int id)
    {
        List<historyModel> transactions = history.getRecords();

        int amount = 0;

        System.out.println("cabId | customerId | source | destination | cost");
        System.out.println("------------------------------------");

        for(historyModel record : transactions)
        {

                System.out.println( record.getCabId()+" | "+record.getCustomerId()+" | "+record.getSource()+" | "+record.getDestination()+" | "+record.getCost());
                System.out.println("----------------------------------");

        }


    }

}
