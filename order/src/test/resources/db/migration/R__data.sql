insert into customer (id, first_name, last_name, email, password, street, city, state_province, postal_code, country,
                      type, number, expiration_month, expiration_year)
values (1001, 'John', 'Doe', 'john.doe@gmail.com', 'secret', 'Bahnhofstrasse 1', 'Zürich', 'ZH', 8000, 'Switzerland',
        'VISA', '4111111111111111', 01, 2024);

insert into salesorder (id, date, status, amount, street, city, state_province, postal_code, country,
                        type, number, expiration_month, expiration_year, customer_id)
values (10001, '2021-01-12', 'SHIPPED', 49.40, 'Bahnhofstrasse 1', 'Zürich', 'ZH', 8000, 'Switzerland',
        'VISA', '4111111111111111', 01, 2020, 1001);

insert into order_item (id, isbn, title, authors, price, quantity, order_id)
values (100001, '9781484228074', 'Spring Boot 2', 'Michael Simons', 39.24, 1, 10001);
