
-- === 1. CREATE TABLES ===

CREATE TABLE STUDENT (
    student_id NUMBER PRIMARY KEY,
    full_name VARCHAR2(100),
    gender VARCHAR2(10),
    email VARCHAR2(100) UNIQUE,
    phone_number VARCHAR2(15),
    admission_date DATE
);

CREATE TABLE ROOM (
    room_id NUMBER PRIMARY KEY,
    room_number VARCHAR2(10) UNIQUE,
    block_name VARCHAR2(50),
    capacity NUMBER,
    status VARCHAR2(20)
);

CREATE TABLE ROOM_ALLOCATION (
    allocation_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    room_id NUMBER,
    checkin_date DATE,
    checkout_date DATE,
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
    FOREIGN KEY (room_id) REFERENCES ROOM(room_id)
);

CREATE TABLE COMPLAINT (
    complaint_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    complaint_type VARCHAR2(50),
    description VARCHAR2(500),
    status VARCHAR2(20),
    date_filed DATE,
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id)
);

-- Added FEE_RECORD table to support FeeDAO simulation
CREATE TABLE FEE_RECORD (
    fee_id NUMBER PRIMARY KEY,
    student_id NUMBER,
    amount NUMBER(10,2),
    due_date DATE,
    is_paid CHAR(1),
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id)
);

-- === 2. INSERT MOCK DATA ===

INSERT INTO STUDENT VALUES (1, 'Anushka Sharma', 'Female', 'anushka@example.com', '9876543210', TO_DATE('2023-08-01', 'YYYY-MM-DD'));
INSERT INTO STUDENT VALUES (2, 'Raj Mehta', 'Male', 'raj@example.com', '9999988888', TO_DATE('2023-07-01', 'YYYY-MM-DD'));

INSERT INTO ROOM VALUES (101, 'A101', 'Block A', 1, 'Available');
INSERT INTO ROOM VALUES (102, 'B202', 'Block B', 2, 'Available');

INSERT INTO ROOM_ALLOCATION VALUES (201, 1, 101, TO_DATE('2025-06-26', 'YYYY-MM-DD'), TO_DATE('2025-12-31', 'YYYY-MM-DD'));
INSERT INTO ROOM_ALLOCATION VALUES (202, 2, 102, TO_DATE('2025-07-01', 'YYYY-MM-DD'), NULL);

INSERT INTO COMPLAINT VALUES (301, 1, 'Water Issue', 'No water in bathroom', 'Open', TO_DATE('2025-06-26', 'YYYY-MM-DD'));
INSERT INTO COMPLAINT VALUES (302, 2, 'Electricity', 'Fan not working', 'Resolved', TO_DATE('2025-07-01', 'YYYY-MM-DD'));

-- === 3. VALIDATE STRUCTURE ===

DESC STUDENT;
DESC ROOM;
DESC ROOM_ALLOCATION;
DESC COMPLAINT;
DESC FEE_RECORD;

-- === 4. VALIDATE CONSTRAINTS ===

SELECT constraint_name, constraint_type, table_name
FROM user_constraints
WHERE table_name IN ('STUDENT', 'ROOM', 'ROOM_ALLOCATION', 'COMPLAINT', 'FEE_RECORD');

-- Check foreign key relationships
SELECT a.constraint_name, a.table_name, a.column_name, c.r_constraint_name, c.table_name AS ref_table
FROM user_cons_columns a
JOIN user_constraints c ON a.constraint_name = c.constraint_name
WHERE c.constraint_type = 'R'
AND a.table_name IN ('ROOM_ALLOCATION', 'COMPLAINT', 'FEE_RECORD');

-- === 5. VALIDATE DATA ===

-- STUDENT
SELECT COUNT(*) AS total_students FROM STUDENT;
SELECT * FROM STUDENT;

-- ROOM
SELECT COUNT(*) AS total_rooms FROM ROOM;
SELECT * FROM ROOM;

-- ROOM_ALLOCATION
SELECT COUNT(*) AS total_allocations FROM ROOM_ALLOCATION;
SELECT * FROM ROOM_ALLOCATION;

-- COMPLAINT
SELECT COUNT(*) AS total_complaints FROM COMPLAINT;
SELECT * FROM COMPLAINT;

-- === 6. JDBC DAO LOGIC SIMULATION ===

-- === ROOM BOOKING DAO SIMULATION ===
INSERT INTO ROOM_ALLOCATION (allocation_id, student_id, room_id, checkin_date, checkout_date)
VALUES (203, 1, 101, TO_DATE('2025-07-01', 'YYYY-MM-DD'), TO_DATE('2025-12-15', 'YYYY-MM-DD'));

SELECT * FROM ROOM_ALLOCATION WHERE student_id = 1 AND room_id = 101;

UPDATE ROOM SET status = 'Occupied' WHERE room_id = 101;
SELECT room_number, status FROM ROOM WHERE room_id = 101;

-- === COMPLAINT DAO SIMULATION ===
INSERT INTO COMPLAINT (complaint_id, student_id, complaint_type, description, status, date_filed)
VALUES (303, 1, 'Electricity Issue', 'Light not working', 'Open', TO_DATE('2025-07-01', 'YYYY-MM-DD'));

SELECT * FROM COMPLAINT WHERE student_id = 1;

UPDATE COMPLAINT SET status = 'Resolved' WHERE complaint_id = 303;
SELECT complaint_id, status FROM COMPLAINT WHERE complaint_id = 303;

-- === FEE DAO SIMULATION ===
INSERT INTO FEE_RECORD (fee_id, student_id, amount, due_date, is_paid)
VALUES (402, 1, 18000.00, TO_DATE('2025-07-20', 'YYYY-MM-DD'), 'N');

SELECT * FROM FEE_RECORD WHERE student_id = 1;

UPDATE FEE_RECORD SET is_paid = 'Y' WHERE student_id = 1;
SELECT fee_id, is_paid FROM FEE_RECORD WHERE student_id = 1;
