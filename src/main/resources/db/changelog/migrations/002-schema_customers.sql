create table if not exists customers_table
(
    id           serial      NOT NULL,
    name         VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    age          integer CHECK (age > 0),
    phone_number VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

create INDEX index_customers
    on customers_table (id);