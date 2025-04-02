use companydb;

drop function getMaxSal;
DELIMITER //
create function getMaxSal(dno int) returns int
deterministic
begin

	declare psal int default 0;
    
    select max(salary) into psal from employees where dept_id = dno;
    
    return psal;
    
    end//
    
select  getMaxSal(2) as maxisal//

-- ---------------------------------------------
-- Q1. Calculate Total Salary per Department
-- ----------------------------------------------

    SELECT
    dept_id,
    SUM(salary) as TotalSal FROM
    employees group by dept_id;

-- -----------------------------------------------------------------------------------------------------------------
-- Q2. Develop a function that accepts a department ID and returns the total salary of employees in that department.
-- -----------------------------------------------------------------------------------------------------------------

DELIMITER //
CREATE function totalsalOfEmp(deptID int) returns int
deterministic
begin

declare TotalSal int default 0;

SELECT 
    SUM(salary)
INTO TotalSal FROM
    employees where dept_id = deptID;

return TotalSal;

end//

select totalsalOfEmp(1);

-- --------------------------------------------------------------
-- Q3. Find Employee Experience in Years
-- --------------------------------------------------------------

SELECT TIMESTAMPDIFF(YEAR, hire_Date, NOW()) into Experience from employees where emp_id = empID;

-- -----------------------------------------------------------------
DELIMITER //
CREATE function findExp(empID int) RETURNS DOUBLE(10,2)
deterministic
begin

declare Experience double(10,2) default 0;

SELECT TIMESTAMPDIFF(YEAR, hire_Date, NOW()) into Experience from employees where emp_id = empID;

return Experience;

end //

select findExp(1) //

-- -----------------------------------------------------------------------------
-- Retrieve Department Name Using Employee ID
-- ------------------------------------------------------------------------------

SELECT d.dept_name
    as deptName
    FROM employees e
    JOIN departments d ON e.dept_id = d.dept_id
    WHERE e.emp_id = 1;

-- ----------------------------------------------------------------------------------------------------------
--  Write a function that takes an employee ID and returns the name of the department the employee belongs to.
-- ----------------------------------------------------------------------------------------------------------

DELIMITER //
CREATE function findDeptName(empID int) RETURNS varchar(255)
deterministic
begin

declare deptName varchar(225) default "";

SELECT d.dept_name
    into deptName
    FROM employees e
    JOIN departments d ON e.dept_id = d.dept_id
    WHERE e.emp_id = empID;

return deptName;

end //

select findDeptName(1) //

-- --------------------------------------------------------------------------------------------
-- Identify the Highest-Paid Employee in a Department
-- --------------------------------------------------------------------------------------------

select max(salary) as MaxSalary from employees where dept_id = 2;

-- --------------------------------------------------------------------------------------------------------------------
-- Create a function that accepts a department ID and returns the name of the highest-paid employee in that department.
-- --------------------------------------------------------------------------------------------------------------------
drop function HighestPaidEmployee
DELIMITER //
CREATE function HighestPaidEmployee(deptid int) RETURNS varchar(255)
deterministic
begin

declare fname varchar(225) default "";

SELECT e.first_name 
INTO fname
FROM employees e
WHERE e.dept_id = deptid
  AND e.salary = (SELECT MAX(salary)
                  FROM employees
                  WHERE dept_id = deptid);


return fname;

end //

select HighestPaidEmployee(1) //


-- ----------------------------------------------------------------------------------------------------------
-- Count Employees in a Department
-- ----------------------------------------------------------------------------------------------------------


 select dept_id, count(*) from employees group by dept_id
 
 
 
-- ----------------------------------------------------------------------------------------------------------
--  Develop a function that takes a department ID as input and returns the total number of employees working in that department.
-- ----------------------------------------------------------------------------------------------------------
drop function TotalNumEmp
DELIMITER //
CREATE function TotalNumEmp(deptid int) RETURNS int
deterministic
begin

declare empcount int default 0;


 select count(*) into empcount from employees where dept_id = deptid;


return empcount;

end //
