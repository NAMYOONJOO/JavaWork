SELECT *FROM T_PROFESSOR ;
SELECT count(*), 
count(HPAGE)--null을 허용
FROM T_PROFESSOR ;
--그룹함수에서는 NULL 값은 계산에서 제외

SELECT count(bonus), sum(bonus), avg(BONUS) FROM T_PROFESSOR ;

SELECT MAX(HIredate),min (HIREDATE) FROM  T_EMP ;

--null허용 컬럼의 그룹함수 적용시
--nvl, nvl2 사용해야함
SELECT avg(nvl(BONUS ,0))
FROM T_PROFESSOR;


--t_professor테이블에서 '학과별'로 교수들의 평균 보너스를 출력하시오
--불가능 하다 select절에 group함수와 group함수가 아닌 것과는 같이 출력 불가 ****                                                                           
SELECT DEPTNO , ROUND(avg(nvl(bonus,0)),1) 보너스평균
FROM T_PROFESSOR 
GROUP BY deptno;
--select다음엔 그룹함수인것과 아닌것이 같이 나올 수 없다

--#5101
SELECT DEPTNO ,"POSITION" , avg(PAY) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO ,"POSITION" --1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ASC,"POSITION" ASC;

--부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 부서만 출력
SELECT DEPTNO ,avg(PAY) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO
WHERE avg(pay)>450; --그룹함수는 where절에서 사용불가

--부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 부서만 출력
-- having : 그룹함수 결과에 대한 조건절
SELECT DEPTNO ,avg(PAY) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO
HAVING avg(pay)>450;

--<SELECT쿼리문 순서>*************

--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY

--#5102
SELECT MGR 매니저,count (mgr) 직원수,sum(sal) 급여총액,avg(sal) 급여평균, avg(COMM) 교통비평균
FROM T_EMP
WHERE JOB <> 'PRESIDENT'
GROUP BY MGR 
;

--#5103
SELECT DEPTNO , count(DEPTNO) 총인원, round((avg(sysdate-HIREDATE)),5) 근속평균, round(avg(PAY)) 급여평균, ROUND(avg(BONUS)) 보너스평균
FROM T_PROFESSOR 
WHERE "POSITION" ='조교수'OR "POSITION" ='정교수'
GROUP BY DEPTNO 
;

--#5104
SELECT DEPTNO1 학과 ,max(WEIGHT)-min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 ;

--#5105
SELECT DEPTNO1 학과 ,max(WEIGHT)-min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING max(WEIGHT)-min(WEIGHT)>30;


