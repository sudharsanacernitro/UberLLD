package com.uberLLD.demo.services;

import java.util.List;

import com.uberLLD.demo.models.historyModel;
import com.uberLLD.demo.repo.historyRepo;

public class customerHistoryService {

    historyRepo history;

    public customerHistoryService(historyRepo history)
    {
        this.history = history;
    }

    public void getHistory(int customerId)
    {
        List<historyModel> transactions = history.getRecords();

        int amount = 0;

        System.out.println("cabId | source | destination | cost");
        System.out.println("------------------------------------");

        for(historyModel record : transactions)
        {
            if(record.getCustomerId() == customerId)
            {
                System.out.println( record.getCabId()+" | "+record.getSource()+" | "+record.getDestination()+" | "+record.getCost());
                System.out.println("----------------------------------");
            }
        }


    }


}
