CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_number VARCHAR(255) DEFAULT NULL,
    sku_code VARCHAR(255),
    quantity INT,
    price DECIMAL(19, 2),
    PRIMARY KEY (id)
);