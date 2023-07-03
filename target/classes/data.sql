
-- Inserir dados
INSERT INTO package (id, name, price) VALUES (1, 'prints', 5);
INSERT INTO package (id, name, price) VALUES (2, 'panoramas', 7);
INSERT INTO package (id, name, price) VALUES (3, 'strips', 5);

INSERT INTO customer (id, name) VALUES (1, 'customer01');
INSERT INTO customer (id, name) VALUES (2, 'customer02');
INSERT INTO customer (id, name) VALUES (3, 'customer03');
INSERT INTO customer (id, name) VALUES (4, 'customer04');
INSERT INTO customer (id, name) VALUES (5, 'customer05');
INSERT INTO customer (id, name) VALUES (6, 'customer06');
INSERT INTO customer (id, name) VALUES (7, 'customer07');
INSERT INTO customer (id, name) VALUES (8, 'customer08');
INSERT INTO customer (id, name) VALUES (9, 'customer09');
INSERT INTO customer (id, name) VALUES (10, 'customer10');


INSERT INTO booth (id, name) VALUES (1, 'booth01');
INSERT INTO booth (id, name) VALUES (2, 'booth02');
INSERT INTO booth (id, name) VALUES (3, 'booth03');

INSERT INTO sell (id, booth_id, price, date) VALUES (1, 1, '300','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (2, 1, '23.43','2023-01-02');
INSERT INTO sell (id, booth_id, price, date) VALUES (3, 1, '12.50','2023-01-10');
INSERT INTO sell (id, booth_id, price, date) VALUES (4, 1, '20.50','2023-01-11');
INSERT INTO sell (id, booth_id, price, date) VALUES (5, 1, '500.50','2023-01-23');

INSERT INTO sell (id, booth_id, price, date) VALUES (6, 2, '500.50','2023-02-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (7, 2, '200.50','2023-02-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (8, 2, '2000.73','2023-02-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (9, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (10, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (11, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (12, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (13, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (14, 2, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (15, 2, '200.50','2023-01-01');

INSERT INTO sell (id, booth_id, price, date) VALUES (16, 3, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (17, 3, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (18, 3, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (19, 3, '200.50','2023-01-01');
INSERT INTO sell (id, booth_id, price, date) VALUES (20, 3, '200.50','2023-01-01');



