CREATE SEQUENCE IF NOT EXISTS users_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE users
(
    id         BIGINT NOT NULL DEFAULT NOT NULL default nextval('users_seq'),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255) UNIQUE,
    password   VARCHAR(255),
    address    VARCHAR(255),
    city       VARCHAR(255),
    state      VARCHAR(255),
    zip_code   VARCHAR(255),
    country    VARCHAR(255),
    telephone  VARCHAR(255),
    is_active  BOOLEAN         DEFAULT TRUE,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS credit_cards_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE credit_cards
(
    id                          BIGINT NOT NULL default nextval('credit_cards_seq'),
    created_at                  TIMESTAMP WITH TIME ZONE,
    updated_at                  TIMESTAMP WITH TIME ZONE,
    credit_card_number          VARCHAR(255),
    credit_card_expiration_date VARCHAR(255),
    CONSTRAINT pk_credit_cards PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS categories_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE categories
(
    id          BIGINT                   NOT NULL default nextval('categories_seq'),
    description VARCHAR(255),
    is_active   BOOLEAN,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS products_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE products
(
    id          BIGINT                   NOT NULL default nextval('products_seq'),
    name        VARCHAR(255),
    description VARCHAR(255),
    price       DECIMAL(10, 2)           NOT NULL,
    image       VARCHAR,
    quantity    BIGINT                   NOT NULL,
    category_id BIGINT                   NOT NULL,
    user_id     BIGINT                   NOT NULL,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS discounts_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE discounts
(
    id               BIGINT NOT NULL default nextval('discounts_seq'),
    created_at       TIMESTAMP WITH TIME ZONE,
    updated_at       TIMESTAMP WITH TIME ZONE,
    name             VARCHAR(255),
    description      VARCHAR(255),
    discount_percent INTEGER,
    is_active        BOOLEAN,
    CONSTRAINT pk_discounts PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS carts_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE carts
(
    id         BIGINT                   NOT NULL default nextval('carts_seq'),
    user_id    BIGINT                   NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_carts PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS carts_items_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE cart_items
(
    id         BIGINT                   NOT NULL default nextval('carts_items_seq'),
    product_id BIGINT                   NOT NULL,
    cart_id    BIGINT                   NOT NULL,
    quantity   INTEGER                  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_cart_items PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS orders_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE orders
(
    id           BIGINT                   NOT NULL default nextval('orders_seq'),
    user_id      BIGINT                   NOT NULL,
    total_amount DECIMAL                  NOT NULL,
    status       VARCHAR(255)             NOT NULL,
    created_at   TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at   TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS order_items_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE order_items
(
    id         BIGINT                   NOT NULL default nextval('order_items_seq'),
    order_id   BIGINT                   NOT NULL,
    product_id BIGINT                   NOT NULL,
    quantity   INTEGER                  NOT NULL,
    price      DECIMAL                  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT pk_order_items PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS payments_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE payments
(
    id         BIGINT NOT NULL default nextval('payments_seq'),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    order_id   BIGINT,
    amount     BIGINT,
    status     VARCHAR(255),
    CONSTRAINT pk_payments PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS category_product
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL
);