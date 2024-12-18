CREATE TABLE PRICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,-- Identificador único para cada registro
    BRAND_ID BIGINT NOT NULL,            -- Identificador de la cadena
    START_DATE TIMESTAMP NOT NULL,       -- Fecha de inicio de la tarifa
    END_DATE TIMESTAMP NOT NULL,         -- Fecha de fin de la tarifa
    PRICE_LIST INT NOT NULL,             -- Identificador de la lista de precios
    PRODUCT_ID BIGINT NOT NULL,          -- Identificador del producto
    PRIORITY INT NOT NULL,               -- Prioridad de la tarifa
    PRICE DECIMAL(10, 2) NOT NULL,       -- Precio final de venta
    CURR VARCHAR(3) NOT NULL             -- Código ISO de la moneda
);