create table sales(
month	varchar2(8),
store	number(2),
dept	varchar2(8),	
amount	number(5),
constraint sales_mon_st_dept_pk PRIMARY KEY (month, store, dept));

insert into sales values('June',1,'pharmacy',120);
insert into sales values('June',2,'pharmacy',185);
insert into sales values('June',3,'pharmacy',253);
insert into sales values('June',1,'grocery',131);
insert into sales values('June',2,'grocery',47);
insert into sales values('June',3,'grocery',150);
insert into sales values('June',1,'produce',88);
insert into sales values('June',2,'produce',59);
insert into sales values('June',3,'produce',160);
insert into sales values('June',1,'dairy',120);
insert into sales values('June',2,'dairy',45);
insert into sales values('June',3,'dairy',73);

insert into sales values('July',1,'pharmacy',110);
insert into sales values('July',2,'pharmacy',175);
insert into sales values('July',3,'pharmacy',256);
insert into sales values('July',1,'grocery',138);
insert into sales values('July',2,'grocery',40);
insert into sales values('July',3,'grocery',143);
insert into sales values('July',1,'produce',90);
insert into sales values('July',2,'produce',55);
insert into sales values('July',3,'produce',168);
insert into sales values('July',1,'dairy',123);
insert into sales values('July',2,'dairy',49);
insert into sales values('July',3,'dairy',70);

insert into sales values('August',1,'pharmacy',135);
insert into sales values('August',2,'pharmacy',198);
insert into sales values('August',3,'pharmacy',247);
insert into sales values('August',1,'grocery',134);
insert into sales values('August',2,'grocery',52);
insert into sales values('August',3,'grocery',157);
insert into sales values('August',1,'produce',88);
insert into sales values('August',2,'produce',70);
insert into sales values('August',3,'produce',165);
insert into sales values('August',1,'dairy',110);
insert into sales values('August',2,'dairy',43);
insert into sales values('August',3,'dairy',75);

select * from sales;

select dept, store, month, sum(amount)
from sales
group by cube(dept, store, month);

select dept,store, month, sum(amount)
from sales
group by rollup(dept, store, month);