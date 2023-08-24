
CREATE TABLE currency(
	id int auto_increment primary key,
    name varchar(100) not null unique,
    symbol varchar(10) not null unique,
    ranking int not null unique,
    price double not null,
    market_cap double not null,
    total_supply double not null,
    maximum_supply double not null,
    volume_24h double not null,
    all_time_high double not null,
    all_time_low double not null,
	creationdate date not null
);

