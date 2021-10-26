drop table if exists customers_table, orders cascade;

create table customers_table
(
    id           int AUTO_INCREMENT primary key,
    name         VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    age          integer CHECK (age > 0),
    phone_number VARCHAR(20) NOT NULL
);

create INDEX index_customers
    on customers_table (id);

create table orders
(
    id           serial      NOT NULL primary key,
    date         timestamp   not null default now(),
    customer_id  integer,
    product_name VARCHAR(20) NOT NULL,
    amount       integer CHECK ( amount > 0 ),
    FOREIGN KEY (customer_id) references customers_table(id)
);

