
/* Drop Tables */

DROP TABLE buddy CASCADE CONSTRAINTS;
DROP TABLE buddy_post CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE buddy
(
	bd_uid number NOT NULL,
	bd_userid varchar2(15) NOT NULL,
	bd_userpw varchar2(15) NOT NULL,
	bd_username varchar2(10) NOT NULL,
	PRIMARY KEY (bd_uid)
);


CREATE TABLE buddy_post
(
	bd_pid number NOT NULL,
	bd_subject varchar2(200) NOT NULL,
	bd_content clob,
	bd_name varchar2(40) NOT NULL,
	bd_viewcnt number DEFAULT 0,
	bd_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (bd_pid)
);

CREATE SEQUENCE bd_uid_SEQ

SELECT *FROM  buddy ;
INSERT INTO buddy VALUES
(bd_uid_SEQ.nextval, 'bhd4445','cathy10','남윤주');
INSERT INTO buddy VALUES
(bd_uid_SEQ.nextval, 'wookyung','gjsldnrud','김우경');

SELECT *FROM  buddy_post ;



