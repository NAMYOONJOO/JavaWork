
/* Drop Tables */

DROP TABLE "USER" CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE "USER"
(
	"UID" number NOT NULL,
	ID varchar2(20) NOT NULL UNIQUE,
	PW varchar2(20) NOT NULL,
	Name varchar2(20) NOT NULL,
	Email varchar2(20) UNIQUE,
	PRIMARY KEY ("UID")
);

SELECT * FROM "USER"



