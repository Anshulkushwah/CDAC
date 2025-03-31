-- 1. List employee name, employee code, and designation code
SELECT empname, empcode, desigcode FROM emp;
-- 2. List all departments and their budgets
SELECT deptname, budget FROM dept;
-- 3. List employees and their respective department names
SELECT e.empname, d.deptname
FROM emp e
JOIN dept d ON e.deptcode = d.deptcode;
-- 4. List employees who do not have a superior
SELECT empname FROM emp WHERE supcode IS NULL;
-- 5. Employees working directly under the superior most employee(Assume the superior most employee is the employee who does not have a supervisor)
SELECT empname FROM emp WHERE supcode = (SELECT empcode FROM emp WHERE supcode IS NULL);
-- 6. Senior-most employees
SELECT empname FROM emp WHERE joindate = (SELECT MIN(joindate) FROM emp);
-- 7. Employees retiring next (assuming retirement age is 60)
SELECT empname  FROM emp 
WHERE DATE_ADD(birthdate, INTERVAL 60 YEAR) = (SELECT MIN(DATE_ADD(birthdate, INTERVAL 60 YEAR)) 
    FROM emp WHERE DATE_ADD(birthdate, INTERVAL 60 YEAR) > CURDATE());
-- 8. Departments and respective department managers
select empname as department_manager,deptname from emp,dept where 
emp.deptcode= dept.deptcode and emp.desigcode in 
(select desigcode from emp where desigcode =(select desigcode from desig where designame ='Manager')); 
-- 9. Number of employees in accounts, personal, or purchase departments
SELECT COUNT(*) FROM emp e JOIN dept d ON e.deptcode = d.deptcode
WHERE d.deptname IN ('Accounts', 'Personal', 'Purchase');
-- 10. Employees working for accounts or personal department
select  empname,empcode from emp join dept on 
emp.deptcode=dept.deptcode where dept.deptname in ('Accounts','Personal');
-- 11. List the employees working for ‘accounts’ and ‘personal’ department
select  empname,empcode from emp join dept on emp.deptcode=dept.deptcode where dept.deptname in ('Accounts','Personal');
-- 12. List the employees working for ‘accounts’ but not for ‘personal’ department
select  empname,empcode from emp join dept on emp.deptcode=dept.deptcode 
where dept.deptname in ('Accounts') and 
emp.empname not in (select empname from emp join dept on emp.deptcode= dept.deptcode where dept.deptname in ('Persoanl'));
-- 13. List the youngest employee of the office
SELECT empname FROM emp WHERE birthdate = (SELECT MAX(birthdate) FROM emp);
select empcode,empname,birthdate from emp order by birthdate desc;
-- 14. Employees with basic pay not equal to 12400
select empcode,empname from emp where not (basicpay = 12400);
-- 15. List the employees who are drawing basic salary between 11000 and 12000.
select empcode,empname from emp where basicpay between 11000 and 12000 ;
-- 16. List the employees who are drawing basic salary not between 11000 and 12000
select empcode,empname from emp where basicpay not between 11000 and 12000 ;
-- 17. List the employees who got salary allowance between Rs.1000 to Rs.1500 in the month of January 2012. 
select empcode,empname from emp where empcode in (
select empcode from salary where allow between 1000 and 1500);
-- 18. List the employees whose name ends with ‘i’ or ‘y’.
select empcode,empname from emp where (empname)like '%i' or (empname) like '%y' ;
-- 19. List the employees who have atleast 25 years of experience
select desigcode,timestampdiff(year,joindate,curdate()) as experience  from emp where timestampdiff(year,joindate,curdate()) >=25;
-- 20. List the ‘Salesmen’ who have minimum 20 to 30 years of experience
SELECT empname FROM emp WHERE desigcode = 'SLMN' 
AND TIMESTAMPDIFF(YEAR, joindate, CURDATE()) BETWEEN 20 AND 30;
-- 21. Basic salary and half salary for each employee
Select empname,basicpay/2 as halfsalary FROM emp;
-- 22. Latest take-home-pay
select empname,(basic + allow - deduct) as TakeHomeAway from salary,emp where emp.empcode = salary.empcode;
-- 23. Take-home-pay of employees in Accounts department
select empname,deptcode,(basic + allow - deduct) as TakeHomeAway from salary,emp where 
emp.empcode = salary.empcode and emp.deptcode in(select deptcode from dept where deptname='Accounts');
-- 24. Employees and their ages
SELECT empname, TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) AS age FROM emp;
-- 25. Accounts employees ordered by age and name
SELECT empcode, empname FROM emp
WHERE emp.deptcode IN (SELECT deptcode FROM dept WHERE deptname = 'Accounts')
ORDER BY TIMESTAMPDIFF(YEAR, birthdate,CURDATE()) DESC;
-- 26. Number of employees directly reporting to 'Reddy'
SELECT COUNT(*) FROM emp WHERE supcode = (SELECT empcode FROM emp WHERE empname = 'Reddy');
-- 27. List the employees who have at least one person working under him/her and the -- number of their subordinates. 
-- List the employee with highest number of subordinates first, next the person with next highest number of subordinates and so on.
select empcode,empname,count(emp.supcode) as count from emp group by empcode,empname 
having count(emp.supcode)>=1 order by count(emp.supcode) asc;
-- 28. List the employees who have minimum 3 employees working under him/her.
SELECT e.empname FROM emp e  JOIN emp s ON e.empcode = s.supcode  GROUP BY e.empname  HAVING COUNT(s.empcode) >= 3;
-- 29. Minimum and maximum salaries in each grade code
SELECT desigcode, MIN(basicpay) AS min_salary, MAX(basicpay) AS max_salary FROM emp GROUP BY desigcode;
-- 30. Employees with their supervisors' names
SELECT e.empname AS emp, s.empname AS Supervisor FROM emp e LEFT JOIN emp s ON e.supcode = s.empcode;
-- 31. Supervisors with more than 3 officers reporting
SELECT e.empname AS Supervisor, COUNT(s.empcode) AS Subordinates FROM emp e  
JOIN emp s ON e.empcode = s.supcode  GROUP BY e.empname HAVING COUNT(s.empcode) > 3;

-- 
CREATE TABLE promotions (
    pid INT AUTO_INCREMENT PRIMARY KEY,
    empcode VARCHAR(15), 
    pdate DATE,
    FOREIGN KEY (empcode) REFERENCES emp(empcode) ON DELETE CASCADE
);

INSERT INTO promotions (emp_code, promotion_date) VALUES
(7369, '1990-06-15'),
(7499, '1991-03-12'),
(7521, '1992-07-21'),
(7566, '1991-09-10'),
(7698, '1993-04-05'),
(7782, '1994-11-30'),
(7839, '1990-02-20'),
(7900, '1991-08-14'),
(7902, '1995-05-17'),
(7934, '1991-12-10');

-- 
-- 32. Employees with no promotion
SELECT empname FROM emp WHERE empcode NOT IN (SELECT empcode FROM promotions);
-- 33. Employee with maximum promotions
SELECT empcode, COUNT(*) AS num_promotions FROM promotions GROUP BY empcode ORDER BY num_promotions DESC LIMIT 1;
-- 34. Employees promoted in 1991
SELECT empname FROM emp WHERE empcode IN (SELECT empcode FROM promotions WHERE YEAR(pdate) = 1991);
-- 35. Department budget and total salary drawn
SELECT d.deptname, d.budget, SUM(e.basicpay) AS total_salary FROM emp e 
JOIN dept d ON e.deptcode = d.deptcode GROUP BY d.deptname;
-- 36. Employee names in uppercase
SELECT UPPER(empname) FROM emp;
-- 37. Employees earning more than 'Jain'
SELECT empname FROM emp WHERE basicpay > (SELECT basicpay FROM emp WHERE empname = 'Jain');
-- 38. Employees earning more than all in range 11000-12000
SELECT empname FROM emp WHERE basicpay > ALL (SELECT basicpay FROM emp WHERE basicpay BETWEEN 11000 AND 12000);
-- 39. Employees earning above average salary
SELECT empname FROM emp WHERE basicpay > (SELECT AVG(basicpay) FROM emp) ORDER BY basicpay;
-- 40. Employee with highest salary
SELECT empname FROM emp WHERE basicpay = (SELECT MAX(basicpay) FROM emp);
-- 41. Employees other than highest salary earner
SELECT empname FROM emp WHERE basicpay < (SELECT MAX(basicpay) FROM emp);
-- 42. Highest-paid employee in each department
SELECT e.empname, d.deptname FROM emp e JOIN dept d ON e.deptcode = d.deptcode 
WHERE basicpay = (SELECT MAX(basicpay) FROM emp WHERE deptcode = e.deptcode);
-- 43. Second highest salary
SELECT empname FROM emp WHERE basicpay = 
(SELECT DISTINCT basicpay FROM emp ORDER BY basicpay DESC LIMIT 1 OFFSET 1);
-- 44. Fifth highest salary
SELECT empname FROM emp WHERE basicpay = 
(SELECT DISTINCT basicpay FROM emp ORDER BY basicpay DESC LIMIT 1 OFFSET 4);
-- 45. Female employee with highest salary
SELECT empname, deptcode FROM emp WHERE sex = 'Female' 
AND basicpay = (SELECT MAX(basicpay) FROM emp WHERE sex = 'Female');
-- 46. Male employees earning more than at least one female employee
SELECT empname FROM emp WHERE sex = 'Male' 
AND basicpay > ANY (SELECT basicpay FROM emp WHERE sex = 'Female');
-- 47. Departments where average salary is higher than company average
SELECT d.deptname FROM dept d JOIN emp e ON d.deptcode = e.deptcode 
GROUP BY d.	deptname HAVING AVG(e.basicpay) > (SELECT AVG(basicpay) FROM emp);
-- 48. Employees earning less than accounts department average salary
SELECT empname FROM emp WHERE basicpay < (SELECT AVG(basicpay) 
FROM emp WHERE deptcode = (SELECT deptcode FROM dept WHERE deptname = 'Accounts'));

