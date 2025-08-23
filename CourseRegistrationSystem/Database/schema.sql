CREATE TABLE Users (     
    id INT PRIMARY KEY,     
    username VARCHAR(50) UNIQUE NOT NULL,     
    password VARCHAR(50) NOT NULL,     
    `role` VARCHAR(20) NOT NULL
);

CREATE TABLE Students (
    id INT PRIMARY KEY,
    email VARCHAR(100),
    payment DECIMAL(10,2),
    FOREIGN KEY (id) REFERENCES Users(id)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    name VARCHAR(100),
    dr_name VARCHAR(100),
    hours INT,
    date DATE
);

CREATE TABLE Enrollment (
    student_id INT,
    course_id INT,
    status BOOLEAN,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES Students(id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
INSERT INTO Users (id, username, password, role) VALUES (12345, 'admin', 'admin', 'admin');
