DROP SCHEMA IF EXISTS tracking;
CREATE SCHEMA tracking;
USE tracking;

CREATE TABLE customer
(
    customer_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45)       NOT NULL,
    PRIMARY KEY (customer_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE shipment
(
    shipment_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    title       VARCHAR(45)       NOT NULL,
    customer_id SMALLINT UNSIGNED,
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    PRIMARY KEY (shipment_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE status
(
    status_id   SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    shipment_id SMALLINT UNSIGNED,
    type        VARCHAR(45),
    date        DATE              NOT NULL,
    FOREIGN KEY (shipment_id) REFERENCES shipment (shipment_id),
    PRIMARY KEY (status_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO customer (customer_id, name)
VALUES (1, 'Mustermann'),
       (2, 'Petrov'),
       (3, 'Ivanova'),
       (4, 'Sokolov');

INSERT INTO shipment (shipment_id, title, customer_id)
VALUES (1, 'Packet', 1),
       (2, 'ExpressPacket', 4),
       (3, 'Packet', 3),
       (4, 'Packet', 4),
       (5, 'Packet', 2);

INSERT INTO status (status_id, shipment_id, type, date)
VALUES (1, 4, 'initial', '2020-03-14'),
       (2, 1, 'initial', '2020-03-16'),
       (3, 3, 'initial', '2020-03-16'),
       (4, 2, 'initial', '2020-03-16'),
       (5, 4, 'shipped', '2020-03-16'),
       (6, 5, 'initial', '2020-03-16'),
       (7, 4, 'delivered', '2020-03-17'),
       (8, 2, 'returned', '2020-03-18'),
       (9, 5, 'cancelled', '2020-03-18'),
       (10, 3, 'shipped', '2020-03-21');
