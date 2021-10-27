create table orders
(
    id int primary key auto_increment,
    date timestamp    not null default now(),
    customer_id int,
    product_name varchar(225) not null default 'some product',
    amount int not null check ( amount>0 ),
    FOREIGN KEY (customer_id) references customers(id)
);