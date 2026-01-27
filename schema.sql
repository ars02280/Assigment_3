CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          price NUMERIC CHECK (price > 0),
                          type VARCHAR(10) NOT NULL,
                          category_id INT NOT NULL,
                          FOREIGN KEY (category_id)
                              REFERENCES categories(id)
                              ON DELETE RESTRICT
);

INSERT INTO categories (name) VALUES ('Games');
INSERT INTO categories (name) VALUES ('Utilities');
