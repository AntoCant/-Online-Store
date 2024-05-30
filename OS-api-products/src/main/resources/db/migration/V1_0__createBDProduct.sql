SET search_path TO "api_product";


CREATE TABLE IF NOT EXISTS brand (
    id_brand SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL,
    date_removed TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS product_type (
    id_product_type SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL,
    date_removed TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS product (
    id_product SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    date_removed TIMESTAMP NOT NULL,
    id_brand INTEGER NOT NULL,
    id_product_type INTEGER NOT NULL,
    FOREIGN KEY(id_brand) REFERENCES brand(id_brand),
    FOREIGN KEY(id_product_type) REFERENCES product_type(id_product_type)
);


CREATE TABLE IF NOT EXISTS image (
  id_image serial PRIMARY KEY,
  id_product INTEGER NOT NULL,
  url VARCHAR NOT NULL,
  date_added TIMESTAMP NOT NULL,
  date_removed TIMESTAMP,
  FOREIGN KEY (id_product) REFERENCES product(id_product)
);