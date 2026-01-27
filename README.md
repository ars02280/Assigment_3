README.md
A. Project Overview

This project is a simple store console app that manages products (apps and games).
It supports CRUD operations and stores data in PostgreSQL using JDBC.

Entities:

Category

Product (abstract)

App (Product)

Game (Product)

Relationships:

Category 1..* Product

B. OOP Design

Product is abstract

App and Game extend Product

Product contains Category (composition)

Polymorphism: list of Product stores both App and Game

UML:

Category
Product (abstract)
 App
 Game

C. Database

Schema:

CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  price NUMERIC NOT NULL,
  type VARCHAR(20) NOT NULL,
  category_id INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);


Sample data:

INSERT INTO categories(name) VALUES('Apps'), ('Games');

INSERT INTO products(name, price, type, category_id)
VALUES('Notion', 5, 'APP', 1),
      ('CS2', 0, 'GAME', 2);

D. Controller (CRUD)

Create: add product

Read: list all products

Update: change product price

Delete: remove product

Example output:

[App{id=2, name='Notion', price=5.0}, Game{id=3, name='CS2', price=0.0}]

E. Compile and Run
javac -cp "lib/postgresql-42.7.9.jar" -d out src/**/*.java
java -cp "out;lib/postgresql-42.7.9.jar" Main
G. Reflection

Learned:

JDBC, SQL, and layered architecture
Challenges:

SQL constraints and inheritance
Benefits:

Clear structure and easier maintenance
