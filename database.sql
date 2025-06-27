-- Create Student table
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15)
);

-- Create Room table
CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    floor_no INT,
    room_number VARCHAR(10) UNIQUE NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(20) DEFAULT 'Vacant'
);

-- Create FeeRecord table
CREATE TABLE FeeRecord (
    fee_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    due_date DATE NOT NULL,
    is_paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
        ON DELETE CASCADE
);

-- Create Complaint table
CREATE TABLE Complaint (
    complaint_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    complaint_type VARCHAR(50),
    description TEXT,
    status VARCHAR(20) DEFAULT 'Pending',
    date_filed DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
        ON DELETE CASCADE
);

-- Create Visitor table
CREATE TABLE Visitor (
    visitor_name VARCHAR(100),
    purpose VARCHAR(100),
    visiting_student_id INT,
    visit_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (visiting_student_id) REFERENCES Student(student_id)
        ON DELETE CASCADE
);

--  StudentRoom table to track room assignments
CREATE TABLE StudentRoom (
    student_id INT PRIMARY KEY,
    room_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
        ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES Room(room_id)
        ON DELETE CASCADE
);
