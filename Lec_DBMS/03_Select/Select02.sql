--산술연산자
SELECT ename, sal, sal*1.1
FROM T_EMP ;

SELECT ENAME , SAL , COMM ,SAL+COMM
FROM T_EMP 
-- 널값과 산술연산한 값은 null이 나온다 !! 주의하기*************

-- WHERE 조건절
SELECT  *
FROM T_EMP 
WHERE JOB ='SALESMAN' --문자열은 대소문자 구분!
;

SELECT ENAME , SAL , DEPTNO 
FROM T_EMP 
WHERE DEPTNO =10;

SELECT ENAME ,SAL 
FROM T_EMP 
WHERE SAL >2000;

SELECT ENAME , EMPNO , SAL 
FROM T_EMP 
WHERE ENAME ='SCOTT'

SELECT *
FROM T_STUDENT ;

SELECT name, grade FROM T_STUDENT  WHERE grade = 2 OR GRADE =3;
SELECT name, grade FROM T_STUDENT  WHERE grade in  (2,3);
SELECT name, grade FROM T_STUDENT  WHERE grade >1 AND GRADE <4;
SELECT name, grade FROM T_STUDENT  WHERE grade NOT in  (1,4);
SELECT name, grade FROM T_STUDENT  WHERE grade BETWEEN 2 and 3;

SELECT NAME ,PAY ,"POSITION" 
FROM T_PROFESSOR 
WHERE PAY >300 AND "POSITION" ='정교수';

--p19
SELECT NAME , "POSITION" 
FROM T_PROFESSOR 
WHERE BONUS IS NULL ;

--p20
SELECT NAME 
FROM T_PROFESSOR
WHERE NAME LIKE '김%';

--p21
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%NE%';

--p22
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '_A%';

--order by
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%L%'
ORDER BY ENAME DESC ;

SELECT ENAME ,JOB,SAL 
FROM T_EMP 
ORDER BY JOB DESC ,SAL ASC ;

SELECT NAME ,GRADE ,HEIGHT 
FROM T_STUDENT 
ORDER BY GRADE ASC , HEIGHT DESC;
