DROP TABLE IF EXISTS customer_product;
DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;

CREATE TABLE customer (
	c_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(200) UNIQUE NOT NULL,
	password VARCHAR(200) NOT NULL
	);
	
CREATE TABLE product (
	p_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200),
	store VARCHAR(200),
	product_id VARCHAR(200),
	image_url VARCHAR(200)
	);
	
CREATE TABLE customer_product (
	c_id INTEGER,
	p_id INTEGER,
	PRIMARY KEY(c_id, p_id),
	CONSTRAINT fk_cp_customer FOREIGN KEY (c_id) REFERENCES customer(c_id),
	CONSTRAINT fk_cp_product FOREIGN KEY (p_id) REFERENCES product (p_id)
	);
	
CREATE TABLE price (
	pr_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	p_id INTEGER,
	price_time TIMESTAMP,
	amount DOUBLE,
	shipping DOUBLE,
	CONSTRAINT fk_price_product FOREIGN KEY (p_id) REFERENCES product(p_id)
	);

INSERT INTO customer(c_id, username, password) VALUES (1, 'user1','password1');
INSERT INTO customer(c_id, username, password) VALUES (2, 'user2','password2');

INSERT INTO product(p_id, title, store, product_id, image_url) VALUES (1, 'Elite Gourmet ECT-3100 Maxi-Matic 4 Slice Long Toaster with Extra Wide 1.5" Slot for Bread, Bagels, Croissants, and Buns, Reheat, Cancel and Defrost, 6 Adjustable Toast Settings, Stainless Steel', 'amazon','B07HYW76FK', 'https://images-na.ssl-images-amazon.com/images/I/81Em0hlUeJL._AC_SX522_.jpg');
INSERT INTO product(p_id, title, store, product_id, image_url) VALUES (2, 'NEW Nespresso VertuoPlus Deluxe Coffee and Espresso Machine by De Longhi, Titan','ebay','193612652792', 'https://i.ebayimg.com/images/g/4I0AAOSwVRdfKgjV/s-l300.jpg');

INSERT INTO price(pr_id, p_id, price_time, amount, shipping) VALUES (1, 1, '2020-11-02 13:33:45.623',39.99, 0.0);
INSERT INTO price(pr_id, p_id, price_time, amount, shipping) VALUES (2, 2, '2020-11-02 13:33:51.932',121.00, 0.0);

INSERT INTO customer_product(c_id,p_id) VALUES (1,1);
INSERT INTO customer_product(c_id,p_id) VALUES (2,2);

--ALTER TABLE customer ADD CONSTRAINT fk_customer_customer_product FOREIGN KEY (c_id) REFERENCES customer_product (c_id) ON DELETE CASCADE;
--ALTER TABLE customer_product ADD CONSTRAINT fk_customer_product_product FOREIGN KEY (p_id) REFERENCES product (p_id) ON DELETE CASCADE;
--ALTER TABLE product ADD CONSTRAINT fk_product_sale FOREIGN KEY (s_id) REFERENCES store (s_id) ON DELETE CASCADE;
--ALTER TABLE product ADD CONSTRAINT fk_product_price FOREIGN KEY (pr_id) REFERENCES price (pr_id) ON DELETE CASCADE;
---- ALTER TABLE price ADD CONSTRAINT FOREIGN KEY (p_id) REFERENCES product (p_id);
---- ALTER TABLE customer_product ADD CONSTRAINT FOREIGN KEY (c_id) REFERENCES customer (c_id);
---- ALTER TABLE customer_product ADD CONSTRAINT FOREIGN KEY (p_id) REFERENCES product (p_id);
--
--ALTER TABLE customer DROP CONSTRAINT fk_customer_customer_product;
--ALTER TABLE product DROP CONSTRAINT fk_product_customer_product;
--ALTER TABLE product DROP CONSTRAINT fk_product_sale;
--ALTER TABLE product DROP CONSTRAINT fk_product_price;
