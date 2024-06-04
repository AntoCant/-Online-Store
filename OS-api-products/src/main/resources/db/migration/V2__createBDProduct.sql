SET search_path TO "api_product";

CREATE TABLE IF NOT EXISTS api_product.brand (
    id_brand SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL,
    date_removed TIMESTAMP
);

CREATE TABLE IF NOT EXISTS api_product.product_type (
    id_product_type SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL,
    date_removed TIMESTAMP
);

CREATE TABLE api_product.product (
    id_product SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    date_removed DATE,
    id_brand INTEGER NOT NULL,
    id_product_type INTEGER NOT NULL,
    FOREIGN KEY (id_brand) REFERENCES api_product.brand(id_brand),
    FOREIGN KEY (id_product_type) REFERENCES api_product.product_type(id_product_type)
);

CREATE TABLE api_product.user_favorite_product (
    id_favorite SERIAL PRIMARY KEY,
    id_product INTEGER NOT NULL,
    id_user INTEGER NOT NULL,
    FOREIGN KEY (id_product) REFERENCES api_product.product(id_product)
);

CREATE TABLE IF NOT EXISTS api_product.image (
  id_image SERIAL PRIMARY KEY,
  id_product INTEGER NOT NULL,
  url VARCHAR NOT NULL,
  date_added TIMESTAMP,
  date_removed TIMESTAMP,
  FOREIGN KEY (id_product) REFERENCES api_product.product(id_product)
);




