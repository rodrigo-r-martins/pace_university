-- In order to drop or create users:
alter session set "_oracle_script"=true;
DROP USER U100;
DROP USER U101;
DROP USER U102;
DROP USER U103;
DROP USER U104;

-- Creating users
CREATE USER U100 IDENTIFIED BY 123456;
CREATE USER U101 IDENTIFIED BY 123456;
CREATE USER U102 IDENTIFIED BY 123456;
CREATE USER U103 IDENTIFIED BY 123456;
CREATE USER U104 IDENTIFIED BY 123456;

-- Selecting privileges for user U100
GRANT SELECT, INSERT, DELETE, UPDATE ON ASSIGN TO U100 WITH GRANT OPTION;
GRANT SELECT, INSERT, DELETE, UPDATE ON WORKER TO U100 WITH GRANT OPTION;
GRANT SELECT, INSERT, DELETE, UPDATE ON PROJECT TO U100 WITH GRANT OPTION;
GRANT SELECT, INSERT, DELETE, UPDATE ON DEPT TO U100 WITH GRANT OPTION;
    
-- Granting create session to U100 and U101
GRANT CREATE SESSION TO U100;
GRANT CREATE SESSION TO U101;

-- Selecting privileges for users U101 and U102 given by user U100
GRANT SELECT 
	ON RMART.DEPT
    TO U101, U102
    WITH GRANT OPTION;

GRANT SELECT 
	ON RMART.WORKER
    TO U101, U102
    WITH GRANT OPTION;
    
GRANT SELECT 
	ON RMART.ASSIGN
    TO U101, U102
    WITH GRANT OPTION;

GRANT SELECT 
	ON RMART.PROJECT
    TO U101, U102
    WITH GRANT OPTION;

-- Selecting privileges for users U103 and U104 given by users U101 and U101
GRANT SELECT 
	ON RMART.WORKER 
    TO U103, U104;
    
-- Revoking privileges from user U101 using user U100
REVOKE SELECT 
	ON RMART.DEPT 
    FROM U101;

REVOKE SELECT 
	ON RMART.WORKER
    FROM U101;

REVOKE SELECT 
	ON RMART.ASSIGN
    FROM U101;

REVOKE SELECT 
	ON RMART.PROJECT
    FROM U101;

-- Showing all privileges
SELECT 
    GRANTEE, 
    GRANTOR, 
    PRIVILEGE, 
    table_name, 
    GRANTABLE 
FROM DBA_TAB_PRIVS 
WHERE grantee IN ('U100', 'U101', 'U102', 'U103', 'U104')
ORDER BY grantee;