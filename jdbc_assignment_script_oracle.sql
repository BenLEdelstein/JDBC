CREATE TABLE student(
student_id NUMERIC NOT NULL,
full_name VARCHAR2(255) NOT NULL,
email VARCHAR2(255) NOT NULL UNIQUE,
gpa NUMBER(5,2) NOT NULL,
pass VARCHAR2(255) NOT NULL,
student_role NUMERIC NOT NULL,
CONSTRAINT student_pk PRIMARY KEY(student_id)
);
INSERT INTO STUDENT VALUES(1, 'Bairon Vasquez','b@gmail.com', 3.4, '111', -1);
INSERT INTO STUDENT VALUES(2, 'Yamil Burgos','y@gmail.com', 3.4, '222', -1);
INSERT INTO STUDENT VALUES(3, 'Joseph Robinson','J@gmail.com', 3.9, '333', -1);


CREATE TABLE instructor(
instructor_id NUMERIC NOT NULL,
full_name VARCHAR2(255) NOT NULL,
email VARCHAR2(255) NOT NULL UNIQUE,
speciality VARCHAR(255) NOT NULL,
admin_role NUMERIC NOT NULL,
pass VARCHAR2(255) NOT NULL,
CONSTRAINT instructor_pk PRIMARY KEY(instructor_id)
);

INSERT INTO INSTRUCTOR VALUES(1, 'Luke','luke@gmail.com', 'Mathemathician', 0, '444');
INSERT INTO INSTRUCTOR VALUES(2, 'lance','lance@gmail.com', 'scientis', 0, '555');
INSERT INTO INSTRUCTOR VALUES(3, 'mark','mark@gmail.com', 'important', 1, '666');

CREATE TABLE course(
course_id NUMERIC NOT NULL,
course_name VARCHAR2(255) NOT NULL UNIQUE,
minimum_gpa NUMBER(5,2) NOT NULL,
CONSTRAINT course_pk PRIMARY KEY(course_id)
);
INSERT INTO COURSE VALUES(1, 'Math', 3.1);
INSERT INTO COURSE VALUES(2, 'Science', 3.2);
INSERT INTO COURSE VALUES(3, 'English', 3.1);
INSERT INTO COURSE VALUES(4, 'GYM', 2.8);

CREATE TABLE teaching(
teaching_id NUMERIC GENERATED ALWAYS AS IDENTITY( START WITH 1 INCREMENT BY 1) NOT NULL,
course_id NUMERIC NOT NULL,
instructor_id NUMERIC NOT NULL,
CONSTRAINT course_fk FOREIGN KEY(course_id) REFERENCES course(course_id),
CONSTRAINT instructor_fk FOREIGN KEY(instructor_id) REFERENCES instructor(instructor_id),
CONSTRAINT teaching_pk PRIMARY KEY(teaching_id)
);

INSERT INTO TEACHING(course_id, instructor_id) VALUES(1,1);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(2,3);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(3,2);

CREATE TABLE attending(
attending_id NUMERIC GENERATED ALWAYS AS IDENTITY( START WITH 1 INCREMENT BY 1) NOT NULL,
course_id NUMERIC NOT NULL,
student_id NUMERIC NOT NULL,
CONSTRAINT course_att_fk FOREIGN KEY(course_id) REFERENCES course(course_id),
CONSTRAINT student_att_fk FOREIGN KEY(student_id) REFERENCES student(student_id),
CONSTRAINT attending_pk PRIMARY KEY(attending_id)
);

INSERT INTO ATTENDING(course_id, student_id) VALUES(1,3);
INSERT INTO ATTENDING(course_id, student_id) VALUES(2,3);
INSERT INTO ATTENDING(course_id, student_id) VALUES(1,2);


COMMIT;