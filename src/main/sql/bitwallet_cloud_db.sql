use gokulraj_murugan_corejava_project;


create table currency(
	id int not null auto_increment primary key,
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

select * from currency;				
describe currency;
drop table currency;
truncate currency;

DELETE FROM currency WHERE name = 'Tether';

update currency SET symbol = 'BW' WHERE name = 'Tether';

insert into currency(name, symbol, ranking, price, market_cap, total_supply, maximum_supply, volume_24h, all_time_high, all_time_low, creationdate) 
values("Dogecoin", "DTC", 10, 1.0, 1, 1, 1, 1, 1, 2,'1996-01-01');

 
