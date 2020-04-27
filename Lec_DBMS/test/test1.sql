INSERT INTO T_STUDENT (STUDNO ,NAME ,ID ,GRADE ,DEPTNO, PROFNO )values(9091,'김수진','sooplus',101,2,1004);

DELETE FROM T_STUDENT WHERE GRADE =4;

SELECT * FROM T_STUDENT ;

ROLLBACK;

SELECT NAME "이름", PAY "급여" 
FROM T_PROFESSOR 
WHERE pay>=5000;

SELECT *
FROM T_PROFESSOR ;


--5
CREATE INDEX idx_student_name ON t_student(name);

SELECT p.NAME "교수님이름", d.DNAME "소속학과명"
FROM T_PROFESSOR p JOIN T_DEPARTMENT d
ON p.DEPTNO =d.DEPTNO ;

SELECT name
FROM T_PROFESSOR 

SELECT s.NAME "학생이름",d.DNAME "학과명"
FROM T_STUDENT s JOIN T_DEPARTMENT d 
ON s.DEPTNO1 =d.DEPTNO 
WHERE (SELECT DEPTNO1 
FROM T_STUDENT 
WHERE NAME ='이윤나')=s.DEPTNO1 ;

SELECT DEPTNO1 
FROM T_STUDENT 
WHERE NAME ='이윤나';

--수정본 학과번호
SELECT s.NAME "학생이름",d.DNAME "학과명"
FROM T_STUDENT s JOIN T_DEPARTMENT d 
ON s.DEPTNO =d.DEPTNO 
WHERE (SELECT DEPTNO 
FROM T_STUDENT 
WHERE NAME ='이윤나')=s.DEPTNO ;

SELECT *
FROM T_STUDENT ;


--8
--ex)
CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name , email, hpage
FROM T_PROFESSOR 
;

CREATE OR REPLACE VIEW v_stud_info ("학생이름","학생학과명","담당교수님 이름")
AS 
SELECT s.NAME ,d.DNAME ,p.NAME 
FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p
WHERE s.DEPTNO1 =d.DEPTNO AND s.PROFNO =p.PROFNO ;

SELECT * FROM v_stud_info;


SELECT s.NAME ,d.DNAME ,p.NAME 
FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p
WHERE s.DEPTNO1 =d.DEPTNO AND s.PROFNO =p.PROFNO ;

ALTER TABLE T_STUDENT 
ADD (   
      birthday DATE
);

SELECT tname FROM tab;

COMMIT ;
quit;

DROP TABLE t_emp4 CASCADE CONSTRAINT;


CREATE TABLE  T_MEMBER (
 NO number(4) , 
 name varchar2(10) NOT NULL ,
 jumin varchar2(13) NOT NULL,
 area Number(1) ,
 deptno varchar2(6), 
 PRIMARY KEY(NO),
 unique(jumin),
 check(area<5),
 FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);
--2
DROP TABLE T_MEMBER CASCADE CONSTRAINT;
CREATE TABLE  T_MEMBER (
 mb_uid NUMBER ,
 mb_name varchar2(20) NOT NULL,
 mb_jumin char(13),
 mb_age NUMBER ,
 mb_dept NUMBER ,
 PRIMARY KEY (mb_uid),
 unique(mb_jumin),
 check(mb_age>0),
 FOREIGN KEY(mb_dept) REFERENCES t_dept(dcode)
);

SELECT dcode
FROM T_DEPT2;

SELECT p.NAME "교수님이름", d.DNAME "소속 학과명"
FROM T_PROFESSOR p JOIN T_DEPARTMENT d
ON p.DEPTNO =d.DEPTNO ;

SELECT s.NAME "학생이름",d.DNAME "학과명"

FROM T_STUDENT s JOIN T_DEPARTMENT d 

ON s.DEPTNO =d.DEPTNO 

WHERE (SELECT DEPTNO FROM T_STUDENT WHERE NAME ='이윤나')=s.DEPTNO ;

SELECT p.NAME "교수님이름", d.DNAME "소속 학과명" FROM T_PROFESSOR p JOIN T_DEPARTMENT d ON p.DEPTNO =d.DEPTNO ;
CREATE OR REPLACE VIEW v_stud_info ("sname","dname","pname") AS SELECT s.NAME ,d.DNAME ,p.NAME FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p WHERE s.DEPTNO =d.DEPTNO AND s.PROFNO =p.PROFNO ;


CREATE OR REPLACE VIEW v_stud_info ("sname","dname","pname") AS SELECT s.NAME ,d.DNAME ,p.NAME FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p WHERE s.DEPTNO1 =d.DEPTNO AND s.PROFNO =p.PROFNO ;

ALTER TABLE T_STUDENT ADD (         birthday DATE);




