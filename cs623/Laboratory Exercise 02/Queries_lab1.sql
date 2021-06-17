select firstName, lastName from Customer where state='NY';
select itemName, unitPrice from Item where itemName like 'Iphone%';
select firstName, lastName, phoneNumber from Customer where lastName='Able' OR lastName='Hows';
select street, city, state, postalCode from Supplier where supName='Treutel Inc';
select distinct c.firstName, o.orderDate, o.totalAmount from Customer c, Orders o where c.custId=o.custId and o.totalAmount > 1000;