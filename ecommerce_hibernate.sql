drop database if exists ECommerce;
create database ECommerce;
use ECommerce;

SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';

DROP table IF EXISTS User;
DROP table IF EXISTS Cart;
DROP table IF EXISTS Product;
create table Product(
productId integer not null primary key,
productName varchar(255),
category varchar(255),
price double,
productQuantity double
);
insert into product (productId, productName, category, price, productQuantity) VALUES (1, "Samsung S21", "mobile phone", 800, 22);
insert into product (productId, productName, category, price, productQuantity) VALUES (2, "SmartTV", "tv", 500, 32);
insert into product (productId, productName, category, price, productQuantity) VALUES (3, "Refrigerator", "home", 550, 34);
insert into product (productId, productName, category, price, productQuantity) VALUES (4, "Laptop", "office", 1100, 15);

SELECT @@global.time_zone, @@session.time_zone;
SELECT * FROM User;
SELECT * FROM Product;
SELECT * FROM Cart;
SELECT * FROM cart_product;
SELECT * FROM hibernate_sequence;
delete from User where userId between 0 and 1000;