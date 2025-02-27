CREATE DATABASE IF NOT EXISTS crs_new;
USE crs_new;

-- Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('Admin', 'Faculty', 'Student') NOT NULL
);

-- Students Table
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    program VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    contact_info VARCHAR(255),
);

-- Courses Table
CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    credit_hours INT NOT NULL,
    department VARCHAR(100) NOT NULL,
    prerequisites VARCHAR(255),
    max_capacity INT NOT NULL
);

-- Enrollments Table
CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) ON DELETE CASCADE
);

-- Academic Records Table
CREATE TABLE AcademicRecords (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade VARCHAR(5),
    FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) ON DELETE CASCADE
);
INSERT INTO Users (username, password_hash, role) VALUES 
('admin1', SHA2('admin123',256), 'Admin'),    admin123
('admin2', SHA2('admin123', 256), 'Admin'),
('admin3', SHA2('admin123', 256), 'Admin'),
('admin4', SHA2('admin123', 256), 'Admin'),
('admin5', SHA2('admin123', 256), 'Admin'),
('faculty1', SHA2('faculty123', 256), 'Faculty'),
('student1', SHA2('student123', 256), 'Student'),
('student2', SHA2('student123', 256), 'Student'),
('student3', SHA2('student123', 256), 'Student'),
('student4', SHA2('student123', 256), 'Student'),
('student5', SHA2('student123', 256), 'Student'),
('student6', SHA2('student123', 256), 'Student'),
('student7', SHA2('student123', 256), 'Student'),
('student8', SHA2('student123', 256), 'Student'),
('student9', SHA2('student123', 256), 'Student'),
('student10', SHA2('student123', 256), 'Student'),
('student11', SHA2('student123', 256), 'Student'),
('student12', SHA2('student123', 256), 'Student'),
('student13', SHA2('student123', 256), 'Student'),
('student14', SHA2('student123', 256), 'Student'),
('student15', SHA2('student123', 256), 'Student'),
('student16', SHA2('student123', 256), 'Student'),
('student17', SHA2('student123', 256), 'Student'),
('student18', SHA2('student123', 256), 'Student'),
('student19', SHA2('student123', 256), 'Student'),
('student20', SHA2('student123', 256), 'Student');                                      


-- Insert Students (Ensure user_id matches Users table)
INSERT INTO Students (student_id, course_id name, date_of_birth, program, year, contact_info) VALUES 
(1, 'John Doe', '2000-05-15', 'Computer Science', 2, 'john.doe@example.com'),
(2, 'Jane Smith', '2001-08-22', 'Information Technology', 1, 'jane.smith@example.com'),
(3, 'Michael Johnson', '2001-03-10', 'Software Engineering', 2, 'michael.johnson@example.com'),
(4, 'Emily Davis', '2000-11-25', 'Computer Science', 3, 'emily.davis@example.com'),
(5, 'William Brown', '2002-07-08', 'Information Technology', 1, 'william.brown@example.com'),
(6, 'Olivia Wilson', '2001-12-14', 'Computer Science', 2, 'olivia.wilson@example.com'),
(7, 'James Taylor', '2002-04-29', 'Software Engineering', 1, 'james.taylor@example.com'),
(8, 'Sophia Moore', '2000-09-18', 'Information Technology', 3, 'sophia.moore@example.com'),
(9, 'Benjamin Anderson', '2001-06-05', 'Computer Science', 2, 'benjamin.anderson@example.com'),
(10,'Charlotte Thomas', '2002-08-22', 'Software Engineering', 1, 'charlotte.thomas@example.com'),
(11, 'Daniel White', '2000-10-30', 'Computer Science', 3, 'daniel.white@example.com'),
(12, 'Ava Harris', '2001-07-17', 'Information Technology', 2, 'ava.harris@example.com'),
(13, 'Henry Martin', '2002-01-11', 'Software Engineering', 1, 'henry.martin@example.com'),
(14, 'Mia Thompson', '2000-02-23', 'Computer Science', 3, 'mia.thompson@example.com'),
(15, 'Logan Martinez', '2001-09-14', 'Information Technology', 2, 'logan.martinez@example.com'),
(16, 'Evelyn Robinson', '2002-06-19', 'Software Engineering', 1, 'evelyn.robinson@example.com'),
(17, 'Jack Clark', '2000-05-20', 'Computer Science', 3, 'jack.clark@example.com'),
(18, 'Amelia Rodriguez', '2001-10-02', 'Information Technology', 2, 'amelia.rodriguez@example.com'),
(19, 'Lucas Lewis', '2002-12-08', 'Software Engineering', 1, 'lucas.lewis@example.com'),
(20, 'Harper Walker', '2000-04-11', 'Computer Science', 3, 'harper.walker@example.com');
(27,'Piyumal Sankalpa', '2001-08-24', 'Computer Science', 1, 'piyuma24sankalpa@gmail.com');


-- Insert Courses
INSERT INTO Courses (title, credit_hours, department, prerequisites, max_capacity) VALUES 
('Database Systems', 3, 'Computer Science', 'Basic ICT knowledge' , 30),
('Software Engineering', 3, 'Information Technology', 'Database Systems', 25),
('Data Structures', 3, 'Computer Science', 'Basic ICT knowledge', 40),
('Artificial Intelligence', 3, 'Computer Science', 'Data Structures', 20),
('Cyber Security', 3, 'Information Technology', 'Two B passes in GCE A/L', 35),
('Operating Systems', 3, 'Software Engineering', 'Data Structures', 30),
('Networking', 3, 'Information Technology', 'Two B passes in GCE A/L', 40);

-- Insert Enrollments   
INSERT INTO Enrollments (student_id, course_id) VALUES  
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 1),
(9, 2),
(10, 3),
(11, 4),
(12, 5),
(13, 6),
(14, 7),
(15, 1),
(16, 2),
(17, 3),
(18, 4),
(19, 5),
(20, 6);


-- Insert Academic Records (Assuming students have completed some courses)
INSERT INTO AcademicRecords (student_id, course_id, grade) VALUES 
(1, 1, 'A'),
(2, 2, 'B+'),
(3, 3, 'A-'),
(4, 4, 'B'),
(5, 5, 'C+'),
(6, 6, 'B-'),
(7, 7, 'A'),
(8, 1, 'B+'),
(9, 2, 'A-'),
(10, 3, 'B'),
(11, 4, 'C'),
(12, 5, 'B-'),
(13, 6, 'A'),
(14, 7, 'A-'),
(15, 1, 'B'),
(16, 2, 'C+'),
(17, 3, 'B-'),
(18, 4, 'A'),
(19, 5, 'B+'),
(20, 6, 'C');
(27, 1, 'A');

