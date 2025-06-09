-- Insertar datos en la tabla category
INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Electronics and Gadgets', 'Electronics');

INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Books and Stationery', 'Books');

INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Apparel and Accessories', 'Clothing');

INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Home and Kitchen', 'Home Goods');

INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Sports and Outdoors', 'Sports');

-- Insertar datos en la tabla product asegurándose de usar IDs válidos para category_id
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Smartphone with 6GB RAM and 128GB Storage', 'Smartphone', 100, 299.99,
        (SELECT id FROM category WHERE name = 'Electronics'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Bluetooth Headphones with Noise Cancellation', 'Headphones', 150, 79.99,
        (SELECT id FROM category WHERE name = 'Electronics'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Best-Selling Science Fiction Novel', 'Sci-Fi Book', 50, 15.99,
        (SELECT id FROM category WHERE name = 'Books'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Waterproof Fitness Tracker', 'Fitness Tracker', 80, 49.99,
        (SELECT id FROM category WHERE name = 'Sports'));

INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Stainless Steel Cookware Set', 'Cookware Set', 30, 120.00,
        (SELECT id FROM category WHERE name = 'Home Goods'));
