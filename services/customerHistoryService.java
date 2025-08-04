package com.uberLLD.demo.services;

import java.util.List;

import com.uberLLD.demo.models.historyModel;
import com.uberLLD.demo.repo.historyRepo;

import com.uberLLD.demo.servicesAbstraction.historyAbstraction;


public class customerHistoryService implements historyAbstraction{

    historyRepo history;

    public customerHistoryService(historyRepo history)
    {
        this.history = history;
    }

    public void getHistory(int id)
    {
        List<historyModel> transactions = history.getRecords();

        int amount = 0;

        System.out.println("cabId | source | destination | cost");
        System.out.println("------------------------------------");

        for(historyModel record : transactions)
        {
            if(record.getCustomerId() == id)
            {
                System.out.println( record.getCabId()+" | "+record.getSource()+" | "+record.getDestination()+" | "+record.getCost());
                System.out.println("----------------------------------");
            }
        }


    }


}
