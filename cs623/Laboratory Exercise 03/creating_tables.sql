CREATE TABLE Student	(
stuId       VARCHAR(6) PRIMARY KEY,
lastName    VARCHAR(20)  NOT NULL, 
firstName   VARCHAR(20)  NOT NULL, 
major       VARCHAR(10),
credits     int(3) DEFAULT 0,
CONSTRAINT Student_credits_cc CHECK ((credits>=0) AND (credits < 150)));

CREATE TABLE Faculty	(
facId       VARCHAR(6),
name	VARCHAR(20)	NOT NULL, 
department	VARCHAR(20),
facRank        VARCHAR(10),
CONSTRAINT Faculty_facId_pk PRIMARY KEY (facId));

CREATE TABLE Class	(
classNumber VARCHAR(8),
facId	VARCHAR(6) REFERENCES Faculty (facId) ON DELETE SET NULL, 
schedule	VARCHAR(8),
room        VARCHAR(6),
CONSTRAINT Class_classNumber_pk PRIMARY KEY (classNumber), 
CONSTRAINT Class_schedule_room_uk UNIQUE (schedule, room));

CREATE TABLE Enroll	(
stuId VARCHAR(6), 
classNumber VARCHAR(8), 
grade       VARCHAR(2),
CONSTRAINT Enroll_classNumber_stuId_pk PRIMARY KEY (classNumber, stuId),
CONSTRAINT Enroll_classNumber_fk FOREIGN KEY (classNumber) REFERENCES Class (classNumber) ON DELETE CASCADE,
CONSTRAINT Enroll_stuId_fk FOREIGN KEY (stuId) REFERENCES Student(stuId) ON DELETE CASCADE);
