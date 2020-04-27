--JOIN *******시험에 반드시나와용

--FROM 절에 테이블에도 별칭(alias)를 줄 수 있다. !

SELECT s.STUDNO , s.NAME , s.DEPTNO1 
FROM T_STUDENT s;

SELECT d.DEPTNO , d.DNAME 
FROM T_DEPARTMENT d;

SELECT s.STUDNO, s.NAME , s.DEPTNO1 ,d.DEPTNO , d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d;
--ORACLE 방식

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 


SELECT s.STUDNO, s.NAME , s.DEPTNO1, d.DNAME 
FROM T_STUDENT s CROSS JOIN  T_DEPARTMENT d 
WHERE s.DEPTNO1 =d.DEPTNO ;
-- ANSI방식


--equi JOIN (등가조인)
--Oracle join 방식
SELECT s.NAME 학생이름, s.DEPTNO1 학과이름 , d.DNAME 학과이름
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO1 =d.DEPTNO ;
-- ANSI join 방식
SELECT s.NAME 학생이름, s.DEPTNO1 학과이름 , d.DNAME 학과이름
FROM T_STUDENT s join T_DEPARTMENT d
ON s.DEPTNO1 =d.DEPTNO ;
--join과 on은 쌍을 이룬다 

-- 제 2전공은? deptno2
SELECT s.NAME 학생이름, s.DEPTNO2 "제2학과", d.DNAME "제2학과이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO2 =d.DEPTNO 


--#6102
--Oracle
SELECT s.NAME 학생이름, s.PROFNO 지도교수 ,p.NAME 지도교수이름
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO =p.PROFNO ;
--ANSI
SELECT s.NAME 학생이름, s.PROFNO 지도교수 ,p.NAME 지도교수이름
FROM T_STUDENT s join T_PROFESSOR p
ON s.PROFNO =p.PROFNO ;


--#6103
SELECT s.NAME 학생이름, d.DNAME 학과이름,p.NAME 교수이름
FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p
WHERE s.PROFNO =p.PROFNO AND s.DEPTNO1 =d.DEPTNO ;

--ANSI
SELECT s.NAME 학생이름, d.DNAME 학과이름,p.NAME 교수이름
FROM 
T_STUDENT s
JOIN T_DEPARTMENT d ON s.DEPTNO1 =d.DEPTNO
JOIN T_PROFESSOR p ON  s.PROFNO =p.PROFNO;


--#6104
SELECT e.NAME 사원이름 , e.POST 현재, e.pay 현재연봉, p.S_PAY 하한금액,p.E_PAY 상한금액
FROM T_EMP2 e JOIN T_POST p
ON e.POST =p.POST ;

SELECT e.NAME 사원이름 , e.POST 현재, e.pay 현재연봉, p.S_PAY 하한금액,p.E_PAY 상한금액
FROM T_EMP2 e , T_POST p
WHERE e.POST =p.POST ;


--#6105
SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.DEPTNO1 =101 and s.PROFNO=p.PROFNO ;

SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s JOIN T_PROFESSOR p
ON s.PROFNO=p.PROFNO 
WHERE s.DEPTNO1 =101 ;


