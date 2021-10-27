create table customers
(
    id           int AUTO_INCREMENT primary key,
    name         VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    age          integer CHECK (age > 0),
    phone_number VARCHAR(20) NOT NULL
);