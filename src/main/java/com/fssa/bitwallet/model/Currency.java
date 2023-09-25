package com.fssa.bitwallet.model;

import java.time.LocalDateTime;

/**
 * Represents a Currency entity with various attributes.
 */

public class Currency {

	private int id;
	private String name;
	private String symbol;
	private String logo;
	private LocalDateTime creationDateTime;
	private LocalDateTime modifiedDateTime;

	/**
	 * Constructs a Currency object with specified attributes.
	 *
	 * @param id            The unique identifier of the currency.
	 * @param name          The name of the currency.
	 * @param symbol        The symbol of the currency.
	 * @param rank          The ranking of the currency.
	 * @param price         The price of the currency.
	 * @param marketCap     The market capitalization of the currency.
	 * @param totalSupply   The total supply of the currency.
	 * @param maximumSupply The maximum supply of the currency.
	 * @param volume24h     The 24-hour trading volume of the currency.
	 * @param allTimeHigh   The all-time high price of the currency.
	 * @param allTimeLow    The all-time low price of the currency.
	 * @param creationDate  The creation date of the currency.
	 */

	public Currency(int id ,String name, String symbol,String logo) {

		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.logo = logo;

	}
	
	
	public Currency(String name, String symbol,String logo) {

		this.name = name;
		this.symbol = symbol;
		this.logo = logo;

	}

	public Currency() {
		//
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
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDateTime;
	}

}
