/*1 Count the number of male employees */
SELECT COUNT(gender) AS male_employees FROM employees WHERE gender = "M";
/* Index - table - column*/
CREATE INDEX idx_employees_gender ON employees(gender);


/*2 Count all the employees in a given department */
DELIMITER $$
CREATE PROCEDURE employees_per_department 
    (IN department_name VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT COUNT(emp_no) AS employees_num 
    FROM departments 
    INNER JOIN dept_emp ON departments.dept_no = dept_emp.dept_no 
    WHERE dept_name = department_name;
END$$
DELIMITER ;
CALL employees_per_department("Sales", @result);

CREATE INDEX idx_departments_dept_no ON departments(dept_no);
CREATE INDEX idx_dept_emp_dept_no ON dept_emp(dept_no);

/*SELECT COUNT(dept_no) FROM dept_emp WHERE dept_no = "d007";*/

/*3 Select all the employees with more than 1 department */

/* SELECT COUNT(*) AS more_than_1_count 
FROM
    (SELECT COUNT(emp_no) AS employees_num 
     FROM dept_emp 
     GROUP BY emp_no 
     HAVING COUNT(*)>1) 
AS multiple_department_employees; */

SELECT emp_no 
FROM dept_emp 
GROUP BY emp_no 
HAVING COUNT(*)>1;

CREATE INDEX idx_employee_number ON employees(emp_no);

/*4 Count the number of senior engineers */
SELECT COUNT(emp_no) AS employees_num FROM titles WHERE title = "Senior Engineer";

CREATE INDEX idx_titles_title ON titles(title);

/*5 Select all the senior engineers with more than 1 department */
SELECT COUNT(*) FROM
    (SELECT COUNT(titles.emp_no) AS employees_num 
     FROM 
     dept_emp INNER JOIN titles 
     ON dept_emp.emp_no = titles.emp_no 
     WHERE title = "Senior Engineer" 
     GROUP BY titles.emp_no HAVING COUNT(*)>1) 
     AS multiple_department_employees;

/*6 Select the titles for the top 10 salaries */
SELECT title, salary 
FROM salaries INNER JOIN titles 
ON salaries.emp_no = titles.emp_no
ORDER BY salary 
DESC LIMIT 10;

CREATE INDEX idx_salaries_emp_no ON salaries(emp_no);
CREATE INDEX idx_titles_emp_no ON titles(emp_no);
CREATE INDEX idx_salaries_salary ON salaries(salary);

/*7 Select the information of all employees considering their manager information */

DELIMITER $$
CREATE PROCEDURE employees_of_a_manager 
    (IN manager_id VARCHAR(100), OUT msg VARCHAR(100))
BEGIN
    SELECT * FROM dept_emp WHERE dept_emp.dept_no =(SELECT dept_no FROM dept_manager WHERE emp_no = manager_id);
END$$
DELIMITER ;

CALL employees_of_a_manager ("110022", @result);
