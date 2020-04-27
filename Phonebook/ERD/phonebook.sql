
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

--시퀀스 객체 생성
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ;
SELECT * phonebook ORDER BY pb_uid DESC;

--알아둬야할 함수들 ~~~~
SELECT COUNT(*) cnt FROM TEST_MEMBER ;--현재 테이블ㅇ 모든 레코드 개수 출력 
SELECT max(MB_no) "max" FROM TEST_MEMBER ;
SELECT MIN(MB_no) "min" FROM TEST_MEMBER ;
SELECT COUNT(*) cnt FROM PHONEBOOK ;
