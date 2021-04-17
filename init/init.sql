-- create database demo if not exists;
use demo;

-- create user 'test'@'localhost' identified by 'asdasd123';
-- grant all on demo.* to 'test'@'localhost';

create table weather(
    city varchar(80) not null,
    temperature integer not null
);
insert into weather(city,temperature) values('Austin',48);
insert into weather(city,temperature) values('Baton Rogue',57);
insert into weather(city,temperature) values('Jackson',50);
insert into weather(city,temperature) values('Montgomery',53);
insert into weather(city,temperature) values('Phoenix',67);
insert into weather(city,temperature) values('Sacramento',66);
insert into weather(city,temperature) values('Santa Fe',27);
insert into weather(city,temperature) values('Tallahassee',59);
-- 其他表结构根据model自动生成


-- mysql -utest -pasdasd123 <init.sql

