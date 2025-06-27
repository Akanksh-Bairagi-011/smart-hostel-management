

--  STUDENT Table
CREATE TABLE STUDENT (
    student_id NUMBER PRIMARY KEY,
    full_name VARCHAR2(100),
    gender VARCHAR2(10),
    email VARCHAR2(100) UNIQUE,
    phone_number VARCHAR2(15),
    admission_date DATE
);

--  ROOM Table
CREATE TABLE ROOM (
    room_id NUMBER PRIMARY KEY,
    room_number VARCHAR2(10) UNIQUE,
    block_name VARCHAR2(50),
    capacity NUMBER,
    status VARCHAR2(20) -- e.g., 'Available', 'Occupied'
);

--  ROOM_ALLOCATION Table
CREATE TABLE ROOM_ALLOCATION (
    allocation_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    room_id NUMBER,
    checkin_date DATE,
    checkout_date DATE,
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
    FOREIGN KEY (room_id) REFERENCES ROOM(room_id)
);

--  COMPLAINT Table
CREATE TABLE COMPLAINT (
    complaint_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    complaint_type VARCHAR2(50),
    description VARCHAR2(500),
    status VARCHAR2(20), -- e.g., 'Open', 'Resolved'
    date_filed DATE,
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id)
);
