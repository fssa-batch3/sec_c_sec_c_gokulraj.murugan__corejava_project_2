package com.fssa.bitwallet.model;

public class Balance {

	private int id;
	private int userId;
	private double balance;
	private int currencyId;
	private Currency currency;
	
	public Balance() {
	}
	
	
	public Balance(int userId, double balance, int currencyId) {
		
		
		
		this.userId = userId;
		this.balance = balance;
		this.currencyId = currencyId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {	
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	

}
