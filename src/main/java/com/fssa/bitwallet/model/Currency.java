package com.fssa.bitwallet.model;

import java.time.LocalDate;

/**
 * Represents a Currency entity with various attributes.
 */

public class Currency {

	private int id;
	private String name;
	private String symbol;
	private int rank;
	private double price;
	private double marketCap;
	private double totalSupply;
	private double maximumSupply;
	private double volume24h;
	private double allTimeHigh;
	private double allTimeLow;
	private LocalDate creationDate; 
	
	public Currency() {
//		default constructor
	}

	
	 /**
     * Constructs a Currency object with specified attributes.
     *
     * @param id           The unique identifier of the currency.
     * @param name         The name of the currency.
     * @param symbol       The symbol of the currency.
     * @param rank         The ranking of the currency.
     * @param price        The price of the currency.
     * @param marketCap    The market capitalization of the currency.
     * @param totalSupply  The total supply of the currency.
     * @param maximumSupply The maximum supply of the currency.
     * @param volume24h    The 24-hour trading volume of the currency.
     * @param allTimeHigh  The all-time high price of the currency.
     * @param allTimeLow   The all-time low price of the currency.
     * @param creationDate The creation date of the currency.
     */
	
	public  Currency(int id, String name, String symbol, int rank, double price, double marketCap, double totalSupply,
			double maximumSupply, double volume24h, double allTimeHigh, double allTimeLow,LocalDate creationDate) {

		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.rank = rank;
		this.price = price;
		this.marketCap = marketCap;
		this.totalSupply = totalSupply;
		this.maximumSupply = maximumSupply;
		this.volume24h = volume24h;
		this.allTimeHigh = allTimeHigh;
		this.allTimeLow = allTimeLow;
		this.creationDate = creationDate;
	}

	 // Getter and setter methods for each field.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public double getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(double totalSupply) {
		this.totalSupply = totalSupply;
	}

	public double getMaximumSupply() {
		return maximumSupply;
	}

	public void setMaximumSupply(double maximumSupply) {
		this.maximumSupply = maximumSupply;
	}

	public double getVolume24h() {
		return volume24h;
	}

	public void setVolume24h(double volume24h) {
		this.volume24h = volume24h;
	}

	public double getAllTimeHigh() {
		return allTimeHigh;
	}

	public void setAllTimeHigh(double allTimeHigh) {
		this.allTimeHigh = allTimeHigh;
	}

	public double getAllTimeLow() {
		return allTimeLow;
	}

	public void setAllTimeLow(double allTimeLow) {
		this.allTimeLow = allTimeLow;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	

}
