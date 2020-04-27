--view도 ddl언어로 생성

--ex CREATE USER, TABLE, SEQUENCE , VIEW 등을 생성 가능 (4가지)

-- #8101) t_professor 테이블의 profno, name, email, hpage 칼럼만 
--사용하는 view를 생성하세요 view 의 이름은 v_prof로 하세요

--이런식으로 쿼리문 작성 시험이 나온다 

CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name , email, hpage
FROM T_PROFESSOR 
;
--v_prof 가 이제 테이블처럼 동작한다. 

SELECT * FROM v_prof;

SELECT tname FROM tab; -- VIEW 확인가능
--scott이 갖는 테이블 목록 출력

-- 같은 이름으로 view생성시 에러난다. 
-- 따라서 기저 view를 지우기 위해 OR replace를 덫붙인다. 

--view 생성시 별도의 컬럼 이름을 지정해 줄 수  있다. 
--view에서 쓰는 이름을 달리 정할 수 있다. 
CREATE OR REPLACE VIEW v_prof (pfno,nm,em,hp)
AS
SELECT profno, name , email, hpage
FROM T_PROFESSOR 
;



-- #8102) t_professor, t_department 테이블을 join 하여
-- 교수번호와 교수이름과 소속학과 이름을 조회하는 view 를 생성하세요.  
--(이름: v_prof_dept)

CREATE OR REPLACE VIEW v_prof_dept (교수번호, 교수명, 소속학과명)
AS
SELECT p.PROFNO ,p.NAME ,d.DNAME 
FROM T_PROFESSOR p JOIN T_DEPARTMENT d
ON p.DEPTNO =d.DEPTNO ;
--특징 : 영구적으로 사용 가능
SELECT *FROM v_prof_dept;

-- #8103) t_student, t_department 테이블 : 학과별로 학생들의 
-- 최대키와 최대몸무게, 학과 이름을 출력하세요
SELECT 
	d.dname "학과명", 
	s.max_height "최대키", 
	s.max_weight "최대몸무게"
FROM 
	( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
	FROM t_student
	GROUP BY deptno1 ) s , 
	t_department d
WHERE 
	s.deptno1 = d.deptno;

--#8104) t_student, t_department 테이블 : 학과별(deptno1)로 
--가장 키가 큰 학생들의 이름과 키, 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요

CREATE OR REPLACE VIEW v_student (학과명, 최대키, 학생이, 키)
AS
SELECT d.DNAME,a.max_h,s.name,a.max_h
FROM 
(SELECT max(HEIGHT) max_h,DEPTNO1
FROM T_STUDENT 
GROUP BY DEPTNO1) a ,t_student s, t_department d
WHERE a.DEPTNO1 =s.deptno1 AND s.HEIGHT =a.max_h AND s.DEPTNO1 =d.DEPTNO ;

SELECT *FROM v_student;



--#8105) 연습
--t_student 테이블 : 
--학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, 
--inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.

SELECT grade, AVG(HEIGHT)
FROM T_STUDENT 
GROUP BY GRADE ;

CREATE OR REPLACE VIEW v_height (학년, 이름, 키, 평균키)
as
SELECT s.GRADE ,s.NAME ,s.HEIGHT ,a.avg_height
FROM 
(SELECT grade, AVG(HEIGHT) avg_height
FROM T_STUDENT 
GROUP BY GRADE) a ,
t_student s
WHERE a.grade=s.GRADE AND s.HEIGHT >a.avg_height
ORDER BY grade ASC;

SELECT * FROM v_height;

DROP VIEW v_height;
