create table customers
(
    id           int AUTO_INCREMENT primary key,
    name         VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    age          integer CHECK (age > 0),
    phone_number VARCHAR(20) NOT NULL
);

create table orders
(
    id int primary key auto_increment,
    date timestamp    not null default now(),
    customer_id int,
    product_name varchar(225) not null default 'some product',
    amount int not null check ( amount>0 ),
    FOREIGN KEY (customer_id) references customers(id)
);

insert into customers(name, surname, age, phone_number)
VALUES ('Alexey', 'D', 24, '89000000000');
insert into customers(name, surname, age, phone_number)
VALUES ('Ian', 'A', 20, '89010000001');
insert into customers(name, surname, age, phone_number)
VALUES ('ALEXEY', 'C', 12, '89020000002');
insert into customers(name, surname, age, phone_number)
VALUES ('aLeXey', 'R', 34, '89030000003');
insert into customers(name, surname, age, phone_number)
VALUES ('Maria', 'H', 32, '89040000004');
insert into customers(name, surname, age, phone_number)
VALUES ('Jhon', 'D', 25, '89050000005');
insert into customers(name, surname, age, phone_number)
VALUES ('Alex', 'Y', 19, '89060000006');
insert into customers(name, surname, age, phone_number)
VALUES ('Filipe', 'G', 29, '89070000007');
insert into customers(name, surname, age, phone_number)
VALUES ('George', 'O', 42, '89080000008');
insert into customers(name, surname, age, phone_number)
VALUES ('Eva', 'W', 16, '89090000009');

insert into orders(product_name, customer_id ,amount)
VALUES ('water', 1, 3);
insert into orders(product_name, customer_id ,amount)
VALUES ('folder', 2, 6);
insert into orders(product_name, customer_id ,amount)
VALUES (default, 3, 8);
insert into orders(product_name, customer_id ,amount)
VALUES ('plant', 4, 1);
insert into orders(product_name, customer_id ,amount)
VALUES ('book', 5, 3);
insert into orders(product_name, customer_id ,amount)
VALUES ('paper bag', 6, 1);
insert into orders(product_name, customer_id ,amount)
VALUES ('lightning', 7, 2);
insert into orders(product_name, customer_id ,amount)
VALUES ('pen', 8, 12);
insert into orders(product_name, customer_id ,amount)
VALUES ('hairbrush', 9, 3);