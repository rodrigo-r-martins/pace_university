-- Create an Oracle Object Table consisting of an XMLType object

CREATE TABLE Employees of XMLTYPE;


-- Insert three records into the table using XML format

INSERT INTO Employees VALUES(XMLTYPE(
'<EMPLOYEE TYPE="Full-Time" STATUS="Active">
    <EMPID>1</EMPID>
    <NAME>
    	<FIRSTNAME>John</FIRSTNAME>
    	<LASTNAME>Smith</LASTNAME>
    </NAME>
    <ADDRESS>
        <STREET>10 Main Street</STREET>
        <CITY>New York</CITY>
        <STATE>NY</STATE>
        <ZIP>10001</ZIP>
    </ADDRESS>
    <PHONE>
    	<AREACODE>212</AREACODE>
    	<PHONE_NUMBER>1234567</PHONE_NUMBER>
    </PHONE>
    <JOB_TITLE>Software Engineer</JOB_TITLE>
    <SALARY>90000</SALARY>
</EMPLOYEE>'));

INSERT INTO Employees VALUES(XMLTYPE(
'<EMPLOYEE TYPE="Full-Time" STATUS="Active">
    <EMPID>2</EMPID>
    <NAME>
    	<FIRSTNAME>Bob</FIRSTNAME>
    	<LASTNAME>Carter</LASTNAME>
    </NAME>
    <ADDRESS>
        <STREET>250 Summer Street</STREET>
        <CITY>White Plains</CITY>
        <STATE>NY</STATE>
        <ZIP>10601</ZIP>
    </ADDRESS>
    <PHONE>
    	<AREACODE>914</AREACODE>
    	<PHONE_NUMBER>9876543</PHONE_NUMBER>
    </PHONE>
    <JOB_TITLE>Recruiter</JOB_TITLE>
    <SALARY>60000</SALARY>
</EMPLOYEE>'));

INSERT INTO Employees VALUES(XMLTYPE(
'<EMPLOYEE TYPE="Full-Time" STATUS="Active">
    <EMPID>3</EMPID>
    <NAME>
    	<FIRSTNAME>Sara</FIRSTNAME>
    	<LASTNAME>Lee</LASTNAME>
    </NAME>
    <ADDRESS>
        <STREET>987 Rose Street</STREET>
        <CITY>Stamford</CITY>
        <STATE>CT</STATE>
        <ZIP>06905</ZIP>
    </ADDRESS>
    <PHONE>
    	<AREACODE>203</AREACODE>
    	<PHONE_NUMBER>6549872</PHONE_NUMBER>
    </PHONE>
    <JOB_TITLE>Manager</JOB_TITLE>
    <SALARY>120000</SALARY>
</EMPLOYEE>'));


-- Make up five queries

SELECT object_value FROM Employees;


SELECT EXTRACT(object_value, '/EMPLOYEE/NAME') FROM Employees;


SELECT 
	EXTRACTVALUE(object_value, '/EMPLOYEE/NAME/FIRSTNAME'),
	EXTRACTVALUE(object_value, '/EMPLOYEE/NAME/LASTNAME'), 
	EXTRACTVALUE(object_value, '/EMPLOYEE/ADDRESS/CITY'),
	EXTRACTVALUE(object_value, '/EMPLOYEE/ADDRESS/STATE')
FROM Employees;


SELECT 
	EXTRACTVALUE(object_value, '/EMPLOYEE/NAME/FIRSTNAME'),
	EXTRACTVALUE(object_value, '/EMPLOYEE/NAME/LASTNAME'),
	EXTRACTVALUE(object_value, '/EMPLOYEE/JOB_TITLE'),
	EXTRACTVALUE(object_value, '/EMPLOYEE/SALARY')
FROM Employees
WHERE EXTRACTVALUE(object_value, '/EMPLOYEE/SALARY') > 90000;


SELECT 
	EXTRACTVALUE(object_value, '/EMPLOYEE/JOB_TITLE'), 
	EXTRACTVALUE(object_value, '/EMPLOYEE/SALARY')
FROM Employees
WHERE EXTRACTVALUE(object_value, '/EMPLOYEE/NAME/FIRSTNAME') = 'John';






