create database coffee_shipping;

use coffee_shipping;

create table coffees(
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    `description` VARCHAR(255),
    price DECIMAL(10,2),
    PRIMARY KEY (id)
);

create table toppings(
	id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    `description` VARCHAR(255),
    price DECIMAL(10,2),
    PRIMARY KEY (id)
);

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  user_role ENUM('CUSTOMER', 'ADMIN', 'CASHIER') NOT NULL,
  PRIMARY KEY (id)
  );

Create table orders(
	  id INT NOT NULL AUTO_INCREMENT,
      user_id INT,
      topping_id INT,
      coffee_id INT,
      order_status enum('OPENED', 'PREPARING','DONE','CLOSED'),
      price decimal(10,2),
      primary key(id),
      foreign key(user_id) references users(id),
      foreign key(coffee_id) references coffees(id),
      foreign key(topping_id) references toppings(id)
);


INSERT INTO users(id, first_name, last_name, email, `password`, user_role) VALUES
(1, 'ADMIN', 'ADMIN', 'ADMIN@admin', 'admin', 'ADMIN');
