SELECT *
FROM T_PROFESSOR ;


-- null 값 과의 연산 결과는 null이다.!
SELECT NAME , PAY , BONUS , pay+BONUS -- NULL 값출력 
FROM T_PROFESSOR ;

--그룹함수에서는 동작, null은 연산에서 제외되어 동작
SELECT SUM(PAY ), sum(BONUS ) 
FROM T_PROFESSOR ;

-- nvl() 함수
SELECT NAME , PAY , BONUS , pay+NVL(BONUS, 0) 총지급액 -- 보너스가 NULL값이면 0으로 계싼 
FROM T_PROFESSOR ;

-- #4201
SELECT NAME ,PAY ,NVL(BONUS,0) BONUS, PAY*12+NVL(BONUS,0) 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- #4202
SELECT NAME ,PAY ,NVL2(BONUS,BONUS ,0) BONUS, NVL2(BONUS,pay*12+BONUS,pay*12) 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;
--NVL2(BONUS,BONUS ,0) 삼항연산자랑 느낌비슷
--bonus값이 null이 아니면 Bonus로 처리 null이면 0으로 처리 