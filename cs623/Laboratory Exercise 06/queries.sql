CREATE TABLE sales_info (
customer_number     NUMBER (2),
day_of_week         VARCHAR2 (10),
hour_of_purchase    NUMBER (2),	
item	            VARCHAR2 (20),
price               DECIMAL (3, 2),
CONSTRAINT customer_number_pk PRIMARY KEY (customer_number));

INSERT INTO sales_info VALUES (1, 'Saturday', 10, 'bread', 2.49);
INSERT INTO sales_info VALUES (2, 'Friday', 14, 'milk', 1.99);
INSERT INTO sales_info VALUES (3, 'Monday', 9, 'water', 0.99);
INSERT INTO sales_info VALUES (4, 'Tuesday', 18, 'cookies', 1.49);
INSERT INTO sales_info VALUES (5, 'Friday', 17, 'strawberries', 1.99);
INSERT INTO sales_info VALUES (6, 'Wednesday', 11, 'grapes', 1.99);
INSERT INTO sales_info VALUES (7, 'Wednesday', 10, 'bananas', 0.89);
INSERT INTO sales_info VALUES (8, 'Monday', 13, 'potatoes', 2.99);
INSERT INTO sales_info VALUES (9, 'Tuesday', 15, 'chocolate', 2.49);
INSERT INTO sales_info VALUES (10, 'Thursday', 11, 'orange', 1.39);
INSERT INTO sales_info VALUES (11, 'Friday', 20, 'lemon', 1.29);
INSERT INTO sales_info VALUES (12, 'Saturday', 19, 'garlic', 1.89);
INSERT INTO sales_info VALUES (13, 'Sunday', 12, 'onion', 1.89);
INSERT INTO sales_info VALUES (14, 'Tuesday', 14, 'lettuce', 2.29);
INSERT INTO sales_info VALUES (15, 'Monday', 11, 'apples', 1.59);
INSERT INTO sales_info VALUES (16, 'Thurday', 9, 'avocado', 1.49);
INSERT INTO sales_info VALUES (17, 'Friday', 17, 'orange juice', 3.49);
INSERT INTO sales_info VALUES (18, 'Sunday', 16, 'lemonade', 2.99);
INSERT INTO sales_info VALUES (19, 'Wednesday', 18, 'yogurt', 0.99);
INSERT INTO sales_info VALUES (20, 'Saturday', 14, 'cupcake', 3.89);


SELECT * FROM sales_info;

SELECT 
    day_of_week,
    item,
    SUM (price)
FROM sales_info
GROUP BY CUBE ( 
    day_of_week,
    item);

SELECT 
    day_of_week,
    hour_of_purchase,
    item,
    SUM (price)
FROM sales_info
GROUP BY ROLLUP ( 
    day_of_week,
    hour_of_purchase,
    item);