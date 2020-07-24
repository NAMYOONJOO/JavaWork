
/* Drop Tables */

DROP TABLE C_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE C_member
(
	memberId number NOT NULL UNIQUE,
	name varchar2(20) NOT NULL,
	phoneNum varchar2(20) NOT NULL,
	position varchar2(20) NOT NULL,
	email varchar2(30) NOT NULL
);



