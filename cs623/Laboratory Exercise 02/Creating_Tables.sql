create table Customer (
custId integer(10) not null primary key auto_increment,
lastName varchar(40) not null,
firstName varchar(20) not null,
street varchar(40),
city varchar(20),
state varchar(2),
zip integer(5),
areaCode integer(3),
phoneNumber integer(7),
creditLimit integer(10) default 0);


create table Supplier (
supplierNo integer(10) not null primary key auto_increment,
supName varchar(40) not null,
street varchar(40),
city varchar(20),
state varchar(2),
postalCode integer(10),
country varchar(20),
countryCode integer(3),
areaCode integer(3),
phoneNumber integer(7),
contactName varchar(40));


create table Item (
itemNo integer(10) not null primary key auto_increment,
itemName varchar(40) not null,
unitPrice float(20) not null,
qtyOnHand integer(10),
reorderPoint integer(10) default 0,
supplierNo integer(10),
constraint item_sup_fk foreign key (supplierNo) references Supplier(supplierNo));


create table Orders (
orderNo integer(10) not null primary key auto_increment,
orderDate date not null,
tax float(20) not null,
totalAmount float(20) not null,
deliverStreet varchar(40),
deliverCity varchar(20),
deliverState varchar(2),
deliverZip varchar(5),
deliverAreaCode integer(3),
deliverNumber integer(7),
custId integer(10),
itemNo integer(10),
constraint cust_order_fk foreign key (custId) references Customer(custId),
constraint item_order_fk foreign key (itemNo) references Item(itemNo));


create table Supplies (
supplierNo integer(10) not null,
itemNo integer(10) not null,
unitCost float(20) not null,
constraint supNo_fk foreign key (supplierNo) references Supplier(supplierNo),
constraint itNo_fk foreign key (itemNo) references Item(itemNo));


create table Contains (
orderNo integer(10) not null,
itemNo integer(10) not null,
quantity integer(10) not null,
constraint ordNo_fk foreign key (orderNo) references Orders(orderNo),
constraint iteNo_fk foreign key (itemNo) references Item(itemNo));
