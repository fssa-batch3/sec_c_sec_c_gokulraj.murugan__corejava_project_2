package com.fssa.bitwallet.errors;

/**
 * The CurrencyValidatorErrors interface defines error messages related to currency validation.
 */
public interface CurrencyValidatorErrors {

    /**
     * Error message indicating that a Currency object is null.
     */
    public static final String INVALID_CURRENCY_NULL = "Currency Can't be null";

    /**
     * Error message indicating that a Currency object is empty.
     */
    public static final String INVALID_CURRENCY_EMPTY = "Currency Can't be Empty";

    /**
     * Error message indicating that an ID is less than zero.
     */
    public static final String INVALID_ID = "Id Can't be less than zero";

    /**
     * Error message indicating that a currency name is null or empty.
     */
    public static final String INVALID_NAME = "Name Can't be null or empty";

    /**
     * Error message indicating that a currency name does not match the required pattern.
     */
    public static final String INVALID_NAME_PATTERN = "Name should contain at least 2 characters and fewer than 20 characters";

    /**
     * Error message indicating that a currency symbol is null or empty.
     */
    public static final String INVALID_SYMBOL = "Symbol Can't be null or empty";

    /**
     * Error message indicating that a currency symbol does not match the required pattern.
     */
    public static final String INVALID_SYMBOL_PATTERN = "Symbol should contain at least 1 character and fewer than 10 characters";

    /**
     * Error message indicating that a currency rank is less than zero.
     */
    public static final String INVALID_RANK = "Rank Can't be less than zero";

    /**
     * Error message indicating that a currency price is less than zero.
     */
    public static final String INVALID_PRICE = "Price Can't be less than zero";

    /**
     * Error message indicating that a currency market cap is less than zero.
     */
    public static final String INVALID_MARKET_CAP = "Market cap Can't be less than zero";

    /**
     * Error message indicating that a currency's total supply is less than zero.
     */
    public static final String INVALID_TOTAL_SUPPLY = "Total Supply Can't be less than zero";

    /**
     * Error message indicating that a currency's maximum supply is less than zero.
     */
    public static final String INVALID_MAXIMUM_SUPPLY = "Maximum Supply Can't be less than zero";

    /**
     * Error message indicating that a currency's 24-hour trading volume is less than zero.
     */
    public static final String INVALID_VOLUME_24H = "Volume 24h Supply Can't be less than zero";

    /**
     * Error message indicating that a currency's all-time high price is less than zero.
     */
    public static final String INVALID_All_TIME_HIGH = "High Can't be less than zero";

    /**
     * Error message indicating that a currency's all-time low price is less than zero.
     */
    public static final String INVALID_All_TIME_LOW = "Low Can't be less than zero";

    /**
     * Error message indicating that a date is null.
     */
    public static final String INVALID_DATE_NULL = "Date can't be null";

    /**
     * Error message indicating that a creation date is in the future.
     */
    public static final String INVALID_DATE_FORMAT = "Creation Date can't be in the future";
    
    
    public static final String  INVALID_LOGO_NULL = "Url can't be null or empty";
}
