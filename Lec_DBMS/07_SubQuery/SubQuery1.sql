
-- #7101) t_emp 테이블에서 scott 보다 급여를 많이 받는 사람의 이름과 급여 출력
SELECT *
FROM T_EMP ;

SELECT sal FROM T_EMP WHERE ENAME ='SCOTT';


SELECT ENAME "이름" ,SAL "급여"
FROM T_EMP 
WHERE sal> (SELECT sal FROM T_EMP WHERE ENAME ='SCOTT');


--#7102) t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력
SELECT MAX(HEIGHT) 
FROM T_STUDENT ;


SELECT NAME ,HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT =(SELECT MAX(HEIGHT) 
FROM T_STUDENT)
;

--#7103) t_student, t_department 테이블 사용하여 이윤나 학생과
-- 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요

SELECT DEPTNO1 
FROM T_STUDENT 
WHERE NAME ='이윤나'

SELECT t.NAME ,d.DNAME 
FROM T_STUDENT t JOIN T_DEPARTMENT d 
ON t.DEPTNO1 =d.DEPTNO 
WHERE t.DEPTNO1 =(SELECT DEPTNO1 
FROM T_STUDENT 
WHERE NAME ='이윤나') ;

-- #7104) t_professor, t_department 테이블 :
-- 입사일이 송도권 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명을 출력하세요

-- 송도권교수 입사일 봅기
SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='송도권';

SELECT p.NAME "교수명", TO_CHAR(p.HIREDATE,'YYYY-MM-dd') "입사일", d.DNAME "학과명"
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO =d.DEPTNO AND p.HIREDATE > (SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='송도권');

-- #7105) t_student 테이블 : 1전공이 101번인 학과의 평균 몸무게보다
-- 몸무게가 많은 학생들의 이름과 몸무게를 출력하세요

SELECT AVG(WEIGHT) 
FROM T_STUDENT 
WHERE DEPTNO1 =101;

SELECT NAME "이름", WEIGHT "몸무게"
FROM T_STUDENT 
WHERE WEIGHT > (SELECT AVG(WEIGHT) 
FROM T_STUDENT 
WHERE DEPTNO1 =101);


--#7106) t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 
--조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요

--조인형 교수보다 월급
SELECT PAY 
FROM T_PROFESSOR 
WHERE NAME ='조인형';

--심슨 교수와 같은 입사일
SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='심슨';

SELECT NAME "이름", PAY "급여", TO_CHAR(HIREDATE ,'YY/MM/dd') 입사일 
FROM T_PROFESSOR 
WHERE PAY < (SELECT PAY 
FROM T_PROFESSOR 
WHERE NAME ='조인형')
AND HIREDATE =(SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='심슨');


--다중행 Sub Query

--t_emp2, t_dept2 테이블 : 근무지역 (t_dept2.area) 이 서울 지사인 
--모든 사원들의 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요

SELECT DCODE 
FROM T_DEPT2 
WHERE AREA ='서울지사';

SELECT EMPNO ,NAME ,DEPTNO 
FROM T_EMP2 
WHERE DEPTNO IN (SELECT DCODE 
FROM T_DEPT2 
WHERE AREA ='서울지사')


--#7108) t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 
--사람의 이름(name)과 직급(post), 연봉(pay)을 출력하세요. 
-- 단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요


SELECT PAY 
FROM T_EMP2
WHERE POST ='과장';


SELECT NAME "이름", POST "직급", TO_CHAR(PAY ,'999,999,999')||'원' "연봉"
FROM T_EMP2 
WHERE pay >ANY (SELECT PAY 
FROM T_EMP2
WHERE POST ='과장');


--#7109) t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 
--가장 적게 나가는 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요

SELECT WEIGHT 
FROM T_STUDENT 
WHERE GRADE =4;

SELECT NAME "이름", GRADE "학년", WEIGHT "몸무게"
FROM T_STUDENT 
WHERE WEIGHT < ALL (SELECT WEIGHT 
FROM T_STUDENT 
WHERE GRADE =4)
;


