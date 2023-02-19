CREATE TABLE category (
	id IDENTITY,
	category VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 

);

INSERT INTO category (category, description,image_url,is_active) VALUES ('Cat-1', 'This is description for 1. category!', 'CAT_1.png', true);
INSERT INTO category (category, description,image_url,is_active) VALUES ('Cat-2', 'This is description for 2. category!', 'CAT_2.png', true);
INSERT INTO category (category, description,image_url,is_active) VALUES ('Cat-3', 'This is description for 3. category!', 'CAT_3.png', true);
