CREATE TABLE currency (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    symbol VARCHAR(10) NOT NULL UNIQUE,
    ranking INT NOT NULL UNIQUE CHECK (ranking > 0),
    price DOUBLE NOT NULL CHECK (price > 0),
    market_cap DOUBLE NOT NULL CHECK (market_cap > 0),
    total_supply DOUBLE NOT NULL CHECK (total_supply > 0),
    maximum_supply DOUBLE NOT NULL CHECK (maximum_supply > 0),
    volume_24h DOUBLE NOT NULL CHECK (volume_24h > 0),
    all_time_high DOUBLE NOT NULL CHECK (all_time_high > 0),
    all_time_low DOUBLE NOT NULL CHECK (all_time_low > 0),
    creation_date_time DATETIME NOT NULL,
    modified_date_time DATETIME
);
