use companydb;

-- 1) Retrieve Employee Details by Department: Create a stored procedure that takes a department ID as input and returns all employees belonging to that department.
-- -----------------------assesments------------------------------------

DELIMITER //

CREATE procedure AllEmpFromDep(in ID int)
begin

SELECT first_name, last_name from employees where dept_id = ID;

end//

call AllEmpFromDep(1)//

-- 2) Insert New Employee Record: Write a stored procedure that inserts a new employee record into the emp table, ensuring all mandatory fields are provided.
-- ------------------------------------------------------------------

DELIMITER //

CREATE PROCEDURE insertNewEmp(IN first_name VARCHAR(255), in last_name varchar(255), in mail VARCHAR(100), in hire_date date, in salary DECIMAL(10, 2), in dept_id int)
begin 

	INSERT INTO  Employees (first_name, last_name, email, hire_date, salary, dept_id) VALUES 
     (first_name, last_name, mail, hire_date, salary, dept_id);
end//

call insertNewEmp('Anshul', 'kushwah', 'Anshul.KUMAR@example.com', '2021-11-18', 90000.00, 1);

Select * from employees;

-- 3) Delete Employees by Experience: Implement a stored procedure that removes employees who have less than a given number of years of experience.
-- ------------------------------------------------------------------------------------

DELIMITER //

CREATE PROCEDURE deleteEmployeesByExperience(IN min_years INT)
BEGIN
    DELETE FROM Employees
    WHERE YEAR(CURDATE()) - YEAR(hire_date) < min_years;
END //

DELIMITER ;

SET SQL_SAFE_UPDATES = 0; -- 
CALL deleteEmployeesByExperience(5);
SET SQL_SAFE_UPDATES = 1;

-- 
4) Generate Employee Count Report: Create a stored procedure that returns the total number of employees in each department.
-- -----------------------------------

DELIMITER //

CREATE PROCEDURE generateEmployeeCountReport()
BEGIN
    SELECT dept_id, COUNT(*) AS employee_count
    FROM Employees
    GROUP BY dept_id;
END //

DELIMITER ;

 CALL generateEmployeeCountReport();
 
 
 -- Create a stored procedure that takes a department ID as an IN parameter and returns the number of employees in that department as an OUT parameter.
 -- ---------------------------------------------------------------------------------
 
DELIMITER //

CREATE PROCEDURE getEmployeeCountByDept(IN deptId INT, OUT employeeCount INT)
BEGIN
    SELECT COUNT(*) INTO employeeCount
    FROM Employees
    WHERE dept_id = deptId;
END //

DELIMITER ;
SET @count = 0;
CALL getEmployeeCountByDept(1, @count);
SELECT @count;
 
 -- Develop a stored procedure that accepts a department ID as an IN parameter and returns the total salary expenditure of that department as an OUT parameter.
 -- ---------------------------------------------------------------------------------
 
 DELIMITER //

CREATE PROCEDURE getDepartmentSalaryExpenditure(IN deptId INT,OUT totalSalary DECIMAL(10, 2))
BEGIN
    SELECT SUM(salary) INTO totalSalary FROM Employees WHERE dept_id = deptId;
END //

 CALL getDepartmentSalaryExpenditure(1, @total_salary)//
 
 SELECT @total_salary//
 
 -- Implement a stored procedure that takes a department ID as an IN parameter and returns the highest salary in that department as an OUT parameter.
 -- -----------------------------------------------------------------------------------
 
 DELIMITER //
 
 CREATE procedure highestSalary (in deptID INT, out hSalary DECIMAL(10, 2))
 begin 
	SELECT MAX(salary) INTO hSalary from employees where dept_id=deptID;
 end //
 
call highestSalary(1,@hSalary)//
SELECT @hSalary//

-- Create a stored procedure where the IN parameters are the department ID and percentage increase, and it updates the salary of all employees in that department accordingly.
-- -------------------------------------------------------------------------------------------

 
 DELIMITER //
 
 CREATE procedure updateSalary (in deptID INT, in SalPer double)
 begin 
	update employees set salary =salary + salary*SalPer/100 where dept_id = deptID;
 end //
 
 SET SQL_SAFE_UPDATES = 0; -- 
call updateSalary(1,10)//
SET SQL_SAFE_UPDATES = 1; -- 

select * from employees//

-- Develop a stored procedure that takes an employee ID as an IN parameter and returns their name, salary, and department ID as OUT parameters.
-- --------------------------------------------------------------------------------
 DELIMITER //
 
 DROP PROCEDURE GetAllDetails //

CREATE PROCEDURE GetAllDetails (IN p_employee_id INT,OUT p_first_name VARCHAR(255),OUT p_last_name VARCHAR(255),OUT p_salary DECIMAL(10, 2),OUT p_dept_id INT)
BEGIN
SELECT first_name, last_name, salary, dept_id
    INTO p_first_name, p_last_name, p_salary, p_dept_id
    FROM Employees
    WHERE emp_id = p_employee_id;


END //
 
 CALL GetAllDetails(1, @first_name, @last_name, @salary, @dept_id);
 SELECT @first_name, @last_name, @salary, @dept_id;