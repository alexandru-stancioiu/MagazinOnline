create database if not exists store;

drop table if exists user;
drop table if exists product;

create table user
(
id int NOT NULL AUTO_INCREMENT,
username varchar(50) NOT NULL,
password varchar(50) NOT NULL,
role enum('USER', 'ADMIN') NOT NULL,
PRIMARY KEY (id)
);

create table product
(
id int NOT NULL AUTO_INCREMENT,
name varchar(50) NOT NULL,
description varchar(200),
price float(5, 2) NOT NULL,
quantity int NOT NULL,
PRIMARY KEY (id)
);

insert into user values (1, "admin", "admin", 'ADMIN');

insert into product values (1, "Pringels", "Chipsuri cu sare", 3.44, 100);
insert into product values (2, "Coca-cola", "Bautura racoritoare carbogazoasa", 1.19, 150);
insert into product values (3, "Orbit", "Guma de mestecat", 1.79, 320);
insert into product values (4, "Milka", "Ciocolata cu alune si lapte", 2.50, 85);
