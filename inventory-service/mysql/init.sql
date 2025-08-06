CREATE DATABASE IF NOT EXISTS inventory_service;

USE inventory_service;
CREATE TABLE inventory_table (
    id BIGINT NOT NULL AUTO_INCREMENT,
    sku_code VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO inventory_table (sku_code, quantity) VALUES
('SKU123', 100),
('SKU456', 200),
('SKU789', 150);