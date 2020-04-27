-- 다중칼럼 Sub Query----------------


-- #7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 
--학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

--학년별로 최대 키
SELECT grade, max(HEIGHT)
FROM T_STUDENT
GROUP BY GRADE ;

SELECT GRADE 학년, NAME 이름, HEIGHT 키
FROM T_STUDENT 
WHERE (GRADE ,HEIGHT) IN (SELECT grade, max(HEIGHT)
FROM T_STUDENT
GROUP BY GRADE) 
ORDER BY GRADE ASC;


--#7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의
-- 교수번호와 이름, 학과명을 출력하세요.  단 학과이름 순으로 오름차순 정렬하세요


--각 학과별로 입사일이 가장 오래된
SELECT DEPTNO ,Min(HIREDATE) 
FROM T_PROFESSOR 
GROUP BY DEPTNO ;

--
SELECT p.PROFNO 교수번호, p.NAME 교수명, TO_CHAR(p.HIREDATE,'YYYY-MM-dd') 입사일 , d.DNAME 학과명
FROM T_PROFESSOR p JOIN T_DEPARTMENT d
ON p.DEPTNO =d.DEPTNO 
WHERE (p.DEPTNO ,p.HIREDATE ) IN (SELECT DEPTNO ,Min(HIREDATE) 
FROM T_PROFESSOR 
GROUP BY DEPTNO);


--#7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 
--이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요

SELECT  POST , MAX(PAY) 
FROM T_EMP2
GROUP BY POST ;

SELECT NAME 사원명, post 직급 , PAY 연봉
FROM T_EMP2 
WHERE (post,pay)in(SELECT  POST , MAX(PAY) 
FROM T_EMP2
GROUP BY POST )
ORDER BY pay ASC;

--#7204)  t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은
-- 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT avg(pay)
FROM T_EMP2 
GROUP BY DEPTNO ;

SELECT d.DNAME 부서명, e.NAME 직원명, e.PAY 연봉
FROM T_EMP2 e join T_DEPT2 d
ON e.DEPTNO =d.DCODE 
WHERE e.PAY < ALL (SELECT avg(pay)
FROM T_EMP2 
GROUP BY DEPTNO)
ORDER by pay ASC ;


-- #7205) t_emp2 테이블 :  직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 
--사람들의 이름과 직급, 현재 연봉을 출력하세요.
-- 시험에 안나와요 하지말 실무에 써야될거아니에요 ㅎㅎ

SELECT a.NAME 사원이름 , NVL(a.post,' ') 직급, PAY "직급"
FROM T_EMP2 a 
WHERE a.pay >= (SELECT avg(b.pay)
FROM T_EMP2 b
WHERE NVL(a.post,' ')=NVL(b.post,' ')) ;
--직급컬럼은  NULL허용

SELECT avg(b.pay)
FROM T_EMP2 b
WHERE '과장'=b.post ;

--#7206) t_emp2, t_dept2 테이블: 조회하여 사원들의 이름과 부서 이름을 출력
SELECT NAME "사원이름", 
(SELECT d.DNAME 
FROM T_DEPT2 d
WHERE d.DCODE = e.DEPTNO ) "부서이름"
FROM T_EMP2 e;

SELECT d.DNAME 
FROM T_DEPT2 d
WHERE d.DCODE = 1001;

--PPT끗
--추가내용




