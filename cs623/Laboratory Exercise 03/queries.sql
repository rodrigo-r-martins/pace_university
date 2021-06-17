-- Query 1: Find the names of all History majors
SELECT firstName, lastName 
FROM student 
WHERE major='History';

-- Query 2: Find the class number, schedule, and room for all classes that Smith of the History department teaches
SELECT classNumber, schedule, room 
FROM class c
JOIN faculty f 
	ON c.facId=f.facId 
WHERE f.name='Smith' AND f.department='History';

-- Query 3: Find the names of all students who have fewer than average number of credits
SELECT firstName, lastName 
FROM student 
WHERE credits < (SELECT AVG(credits) FROM student);

-- Query 4: Find the names of all the teachers that Ann Chin has, along with all her classes and midterm grades from each
SELECT f.name, c.classNumber, e.grade 
FROM faculty f 
JOIN class c 
	ON f.facId=c.facId
JOIN enroll e 
	ON c.classNumber=e.classNumber 
JOIN student s 
	ON e.stuId=s.stuId
WHERE s.firstName='Ann' AND s.lastName='Chin';

-- Query 5: For each student, find the number of classes he or she is enrolled in
SELECT s.stuId, s.firstName, s.lastName, count(e.classNumber) AS total_classes 
FROM student s 
LEFT JOIN enroll e 
	ON s.stuId=e.stuId 
GROUP BY s.stuId;