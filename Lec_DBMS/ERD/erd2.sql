
/* Drop Tables */

DROP TABLE register CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE department
(
	depno number NOT NULL,
	phonenum varchar2(20),
	office varchar2(20),
	dname varchar2(10),
	PRIMARY KEY (depno)
);


CREATE TABLE lecture
(
	lecno number NOT NULL,
	lname varchar2(10),
	credit number,
	lecpersonnum number,
	class varchar2(10),
	lecyear date,
	profno number NOT NULL,
	PRIMARY KEY (lecno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	name varchar2(10) NOT NULL,
	jumin varchar2(13),
	adress varchar2(20),
	position varchar2(10),
	phonenum varchar2(10),
	hiredate date,
	depno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE register
(
	studno number NOT NULL,
	lecno number NOT NULL
);


CREATE TABLE student
(
	studno number NOT NULL,
	grade number,
	phonenum varchar2(10),
	adress varchar2(20),
	jumin varchar2(13),
	name varchar2(10),
	depno number NOT NULL,
	PRIMARY KEY (studno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (depno)
	REFERENCES department (depno)
;


ALTER TABLE student
	ADD FOREIGN KEY (depno)
	REFERENCES department (depno)
;


ALTER TABLE register
	ADD FOREIGN KEY (lecno)
	REFERENCES lecture (lecno)
;


ALTER TABLE lecture
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE register
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



