#Q1
SELECT first_name, last_name FROM student;

#Q2
SELECT instructor_id from instructor
WHERE tenured = 1;

#Q3
SELECT s.first_name AS student_fname, s.last_name AS student_lname, i.first_name AS advisor_fname, i.last_name AS advisor_lname FROM student s
JOIN instructor i ON s.advisor_id = i.instructor_id;

#Q4
SELECT i.instructor_id, i.first_name, i.last_name FROM instructor i
RIGHT JOIN student s ON s.advisor_id = i.instructor_id
WHERE i.instructor_id IS NOT NULL
GROUP BY i.instructor_id;

#Q5
SELECT i.first_name, i.last_name, SUM(c.num_credits) FROM instructor i
JOIN course c ON c.instructor_id = i.instructor_id
GROUP BY i.instructor_id;

#Q6
SELECT course_code, course_name FROM course
WHERE course_code LIKE '%3___%';

#Q7
SELECT c.course_code AS 'Course Code', i.first_name AS 'Instructor First Name', i.last_name AS 'Instructor Last Name', c.num_credits AS 'Credit Hours' FROM student_schedule s
INNER JOIN course c ON c.course_id = s.course_id
INNER JOIN instructor i ON i.instructor_id = c.instructor_id
WHERE s.student_id = '1';