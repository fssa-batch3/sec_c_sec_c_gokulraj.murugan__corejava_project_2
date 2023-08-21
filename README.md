sec_c_sec_c_aakash.balamurugan__corejava_project_2
## MILESTONE 1
# ** CURRENCY MODULE**
Currency Model
Currency Validator
Currency Dao
Currency ServiceLayer
Currency Test cases
** Currency MODULE FEATURES**
-Add Currency -Read all Currency -update Currency -Delete Currency

### Currency Table

This table stores information about various currencies, including their name, symbol, market data, and historical records.

#### Table Schema

| Field          | Data Type    | Constraints           | Description                      |
| -------------- | ------------ | ----------------------| ---------------------------------|
| id             | INT          | NOT NULL, AUTO_INCREMENT, PRIMARY KEY | Unique identifier for each currency |
| name           | VARCHAR(100) | NOT NULL, UNIQUE      | Name of the currency             |
| symbol         | VARCHAR(10)  | NOT NULL, UNIQUE      | Symbol of the currency           |
| ranking        | INT          | NOT NULL, UNIQUE      | Ranking of the currency          |
| price          | DOUBLE       | NOT NULL              | Current price of the currency    |
| market_cap     | DOUBLE       | NOT NULL              | Market capitalization of the currency |
| total_supply   | DOUBLE       | NOT NULL              | Total supply of the currency     |
| maximum_supply | DOUBLE       | NOT NULL              | Maximum supply of the currency   |
| volume_24h     | DOUBLE       | NOT NULL              | 24-hour trading volume of the currency |
| all_time_high  | DOUBLE       | NOT NULL              | All-time high price of the currency |
| all_time_low   | DOUBLE       | NOT NULL              | All-time low price of the currency |
| creationdate   | DATE         | NOT NULL              | Date of record creation          |
