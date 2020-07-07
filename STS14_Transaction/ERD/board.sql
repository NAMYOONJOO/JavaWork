
/* Drop Tables */

DROP TABLE boardTable CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE boardTable
(
	"UID" number NOT NULL,
	Name varchar2(20),
	Subject varchar2(20) NOT NULL,
	Content clob NOT NULL,
	ViewCnt number DEFAULT 0,
	boardDate date,
	PRIMARY KEY ("UID"),
	CONSTRAINT ViewCnt_limit
	CHECK(ViewCnt>=0)
	
);


SELECT *FROM boardTable

