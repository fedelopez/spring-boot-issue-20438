create table orders (
    id serial not null primary key,
    order_name text
);

insert into orders (order_name) values ('order 1');