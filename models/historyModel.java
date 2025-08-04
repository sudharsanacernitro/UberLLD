package com.uberLLD.demo.models;

public class historyModel {
	
	private int cabId;
	private int customerId;
	private int source;
	private int destination;
	private int cost;
	private int commission;
	
	public historyModel(int cabId, int customerId, int source, int destination, int cost, int commission) {
		super();
		this.cabId = cabId;
		this.customerId = customerId;
		this.source = source;
		this.destination = destination;
		this.cost = cost;
		this.commission = commission;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}
	
	
	
	
	

}
