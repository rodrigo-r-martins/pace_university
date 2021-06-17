-- DDL & Inserts for Worker and Project Example chapter 5
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS assign;
DROP TABLE IF EXISTS project;

CREATE TABLE Worker (
empId INT(6) PRIMARY KEY, 
lastName VARCHAR(20) NOT NULL,
firstName VARCHAR(15) NOT NULL, 
deptName VARCHAR(15), 
birthDate DATE, 
hireDate DATE, 
salary DECIMAL(8,2));

CREATE TABLE Dept(
deptName VARCHAR(15),
mgrId INT(6),
CONSTRAINT Dept_deptName_pk PRIMARY KEY (deptName),
CONSTRAINT Dept_mgrId_fk FOREIGN KEY (mgrId) REFERENCES Worker(empId) ON DELETE SET NULL);

ALTER TABLE Worker ADD CONSTRAINT Worker_deptName_fk FOREIGN KEY (deptName) REFERENCES Dept(deptName) ON DELETE SET NULL;

CREATE TABLE Project (
projNo INT(6), 
projName VARCHAR(20), 
projMgrId INT(6),
budget DECIMAL(8,2), 
startDate DATE, 
expectedDurationWeeks INT(4),
CONSTRAINT Project_projNo_pk PRIMARY KEY (projNo),
CONSTRAINT Project_projMgrId_fk FOREIGN KEY(projMgrId) REFERENCES WORKER(empId) ON DELETE SET NULL);
	
CREATE TABLE Assign (
projNo INT(6), 
empId INT(6), 
hoursAssigned INT(3), 
rating INT(1),
CONSTRAINT Assign_projNo_empId_pk PRIMARY KEY (projNo, empId),
CONSTRAINT Assign_projNo_fk FOREIGN KEY(projNo) REFERENCES Project(projNo) ON DELETE CASCADE,
CONSTRAINT Assign_empId_fk FOREIGN KEY(empId) REFERENCES Worker(empId) ON DELETE CASCADE);

ALTER TABLE worker MODIFY COLUMN birthDate VARCHAR(15);
ALTER TABLE worker MODIFY COLUMN hireDate VARCHAR(15);
ALTER TABLE project MODIFY COLUMN startDate VARCHAR(15);

INSERT INTO Dept VALUES ('Accounting',null);
INSERT INTO Dept VALUES ('Research',null);

INSERT INTO Worker VALUES(101,'Smith','Tom', 'Accounting', '01-Feb-1970', '06-Jun-1993',50000);
INSERT INTO Worker VALUES(103,'Jones','Mary','Accounting', '15-Jun-1975', '20-Sep-2005',48000);
INSERT INTO Worker VALUES(105,'Burns','Jane','Accounting', '21-Sep-1980', '12-Jun-2000',39000);
INSERT INTO Worker VALUES(110,'Burns','Michael', 'Research', '05-Apr-1977', '10-Sep-2010',70000);
INSERT INTO Worker VALUES(115,'Chin','Amanda', 'Research', '22-Sep-1980', '19-Jun-2014',60000);

UPDATE Dept SET mgrId = 101 WHERE deptName = 'Accounting';
UPDATE Dept SET mgrId = 110 WHERE deptName = 'Research';	

INSERT INTO Project VALUES (1001, 'Jupiter', 101, 300000, '01-Feb-2014', 50);
INSERT INTO Project VALUES (1005, 'Saturn', 101, 400000, '01-Jun-2014', 35);
INSERT INTO Project VALUES (1019, 'Mercury', 110, 350000, '15-Feb-2014', 40);
INSERT INTO Project VALUES (1025, 'Neptune', 110, 600000, '01-Feb-2015', 45);
INSERT INTO Project VALUES (1030, 'Pluto', 110, 380000, '15-Sep-2014', 50);

INSERT INTO Assign VALUES(1001, 101, 30,null);
INSERT INTO Assign VALUES(1001, 103, 20,5);
INSERT INTO Assign VALUES(1005, 103, 20,null);
INSERT INTO Assign VALUES(1001, 105, 30,null);
INSERT INTO Assign VALUES(1001, 115, 20,4);
INSERT INTO Assign VALUES(1019, 110, 20,5);
INSERT INTO Assign VALUES(1019, 115, 10,4);
INSERT INTO Assign VALUES(1025, 110, 10,null);
INSERT INTO Assign VALUES(1030, 110, 10,null);


