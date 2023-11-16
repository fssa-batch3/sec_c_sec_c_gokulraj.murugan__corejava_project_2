package com.fssa.bitwallet.model;

import java.time.LocalDate;

public class Transaction {

	private int id;
	private int userId;
	private int SellerId;
	private String transactionType;
	private int currencyId;
	private double amount;
	private double quantity;
	private String transactionMethod;
	private LocalDate transactionTime;

	public int getTransactionId() {
		return id;
	}

	public void setTransactionId(int transactionId) {
		this.id = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTransactionType() {
		return transactionType;
	}
	
	

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public LocalDate getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDate transactionTime) {
		this.transactionTime = transactionTime;
	}
	

	public String getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public int getSellerId() {
		return SellerId;
	}

	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}

	public Transaction(int userId,int sellerId, int currencyId, double amount,
			double quantity,String transactionMethod) {
		
		this.SellerId = sellerId;
		this.userId = userId;
		this.currencyId = currencyId;
		this.amount = amount;
		this.quantity = quantity;
		this.transactionMethod = transactionMethod;
		
	}

	public Transaction() {
		// Default Transaction
	}
	
	@Override
	public String toString() {
		return "Transaction ID: " + id + "\nUser ID: " + userId + "\nTransaction Type: " + transactionType
				+ "\nCurrency ID: " + currencyId + "\nAmount: " + amount + "\nTransaction Time: " + transactionTime;
	}

}
