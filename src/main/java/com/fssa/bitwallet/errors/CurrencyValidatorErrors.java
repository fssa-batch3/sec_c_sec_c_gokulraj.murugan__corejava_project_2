package com.fssa.bitwallet.errors;

public interface CurrencyValidatorErrors {

	public static final String INVALID_CURRENCY_NULL = "Currency Can't be null";

	public static final String INVALID_CURRENCY_EMPTY = "Currency Can't be Empty";

	public static final String INVALID_ID = "Id Can't be less than zero";

	public static final String INVALID_NAME = "Name Can't be null or empty";

	public static final String INVALID_NAME_PATTERN = "Name should contain atleast 2 character and lesser than 20 characters";
	
	public static final String INVALID_SYMBOL= "Symbol Can't be null or empty";

	public static final String INVALID_SYMBOL_PATTERN = "Symbol should contain atleast 1 character and lesser than 10 characters";

	public static final String INVALID_RANK = "Rank Can't be less than zero";

	public static final String INVALID_PRICE = "Price Can't be less than zero";

	public static final String INVALID_MARKET_CAP = "Market cap Can't be less than zero";

	public static final String INVALID_TOTAL_SUPPLY = "Total Supply Can't be less than zero";

	public static final String INVALID_MAXIMUM_SUPPLY = "Maximum Supply Can't be less than zero";

	public static final String INVALID_VOLUME_24H = "Volume 24h Supply Can't be less than zero";

	public static final String INVALID_All_TIME_HIGH = "High Can't be less than zero";

	public static final String INVALID_All_TIME_LOW = "Low Can't be less than zero";
	
	public static final String INVALID_DATE_NULL = "Date can't be null";
	
	public static final String INVALID_DATE_FORMAT = "Creation Date can't be in future";

}