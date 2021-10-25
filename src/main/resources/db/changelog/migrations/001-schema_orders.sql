create table if not exists orders
(
    id          serial      NOT NULL primary key,
    date         timestamp   not null default now(),
    customer_id  integer,
    product_name VARCHAR(20) NOT NULL,
    amount       integer CHECK ( amount > 0 )
);