ALTER TABLE customer
    ADD COLUMN email VARCHAR(45) NOT NULL;


UPDATE customer
SET email = 'mustermann@google.com'
WHERE customer_id = 1;

UPDATE customer
SET email = 'petrov@mail.ru'
WHERE customer_id = 2;

UPDATE customer
SET email = 'ivanova@gmail.com'
WHERE customer_id = 3;

UPDATE customer
SET email = 'sokolov@mail.ru'
WHERE customer_id = 4;


