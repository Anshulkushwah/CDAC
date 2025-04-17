-- 1. Create a trigger after insert statement for emp table to insert the value into table only if join date is not older than 40 .
DELIMITER //
create trigger trg_after_insert_emp
after insert on emp
for each row
begin
    if datediff(CURDATE(), new.joindate) <= 40 * 365 then
        insert into another_table (empcode, empname, birthdate, joindate)
        VALUES (NEW.empcode, NEW.empname, NEW.birthdate, NEW.joindate);
    END IF;
END//

-- 2. Insert a value to activate the trigger check
INSERT INTO emp (empcode,empname, birthdate, joindate)
VALUES (1, 'John Doe', '1993-05-15', '2020-04-17');

-- 3. Create a table average_age, Insert the average age of the employee into this table.
create table average_age (
    avg_age DECIMAL(5,2)
);
INSERT INTO average_age (avg_age)
SELECT AVG(TIMESTAMPDIFF(YEAR, birthdate, CURDATE())) FROM emp;

-- 4. Create an AFTER INSERT trigger on the emp table to update the average_age table after insert
DELIMITER //
CREATE TRIGGER trg_after_insert_update_avg_age
AFTER INSERT ON emp
FOR EACH ROW
BEGIN
    UPDATE average_age
    SET avg_age = (SELECT AVG(TIMESTAMPDIFF(YEAR, birthdate, CURDATE())) FROM emp);
END//

-- 5. Insert a value to activates the trigger check:
INSERT INTO emp (empcode, empname, birthdate, joindate)
VALUES (2, 'Jane Smith', '1995-08-22', '2021-05-12');

-- 6. Add a BEFORE UPDATE trigger to the emp table to check the age value (age should be more than 18) before inserting data into the emp table
delimiter //
CREATE TRIGGER trg_before_update_check_age
BEFORE UPDATE ON emp
FOR EACH ROW
BEGIN
    IF TIMESTAMPDIFF(YEAR, NEW.birthdate, CURDATE()) < 18 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Age must be greater than 18';
    END IF;
ENd//

-- 7. Updating an existing value activates the trigger check
UPDATE emp
SET birthdate = '2008-05-15'
WHERE empcode = 1;

-- 8. Create a table called emp_archive with same columns as emp table.

CREATE TABLE emp_archive (
    empcode INT PRIMARY KEY,
    empname VARCHAR(100),
    birthdate DATE,
    joindate DATE
);

-- 9. Insert a new (which is does not exist in emp table) record into emp table
INSERT INTO emp (empcode, empname, birthdate, joindate)
VALUES (3, 'Jane Smith', '1995-08-22', '2021-05-12');

-- 10. Create a BEFORE DELETE trigger on the table emp and insert the values into the emp_archive table
delimiter //
CREATE TRIGGER trg_before_delete_emp
BEFORE DELETE ON emp
FOR EACH ROW
BEGIN
    INSERT INTO emp_archive (empcode, empname, birthdate, joindate)
    VALUES (OLD.empcode, OLD.empname, OLD.birthdate, OLD.joindate);
END//
-- 11. Delete the record inserted at step no 9
DELETE FROM emp
WHERE empcode = 3; 

-- 12. Display emp_archive table to check the trigger before delete
SELECT * FROM emp_archive;
-- 13. Create an AFTER DELETE trigger on the table emp to update the average_age table with the new information (i.e whenever you delete a record from emp table, average_age should get updated)
delimiter //
CREATE TRIGGER trg_after_delete_update_avg_age
AFTER DELETE ON emp
FOR EACH ROW
BEGIN
    UPDATE average_age
    SET avg_age = (SELECT AVG(TIMESTAMPDIFF(YEAR, birthdate, CURDATE())) FROM emp);
END//

-- 14. Delete a value to check the above trigger
DELETE FROM emp
WHERE empcode = 2;
