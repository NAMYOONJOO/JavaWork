--계층형 쿼리 (hierarchical Query)

SELECT * FROM T_DEPT2 ; --서로의 계층관계 주목

SELECT LPAD(dname,10,'*') 부서명 FROM T_DEPT2 ;
--LEVEL
SELECT dname,LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR dcode = PDEPT 
START WITH DCODE = 1;

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 * 
 */

--prior를 디른데 주면?
SELECT dname,LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT 
START WITH DCODE = 1;


SELECT DCODE , dname,PDEPT ,LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT 
--START WITH DCODE = 1005;
START WITH DCODE = 1011;

SELECT LPAD(DNAME,LEVEL * 6 ,'*') 
FROM T_DEPT2 
CONNECT BY PRIOR dcode = PDEPT 
START WITH DCODE =0001;

SELECT LPAD(e.name||'-'||d.dname ||NVL(e.post,'사원'),LEVEL *22,'-') "이름과 직급"
FROM T_EMP2 e,(SELECT DNAME ,DCODE , PDEPT 
FROM T_DEPT2) d
WHERE e.DEPTNO =d.DCODE 
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO =20000101
;

SELECT DNAME ,DCODE , PDEPT 
FROM T_DEPT2 ;


SELECT LEVEL-1 hr
FROM DUAL 
CONNECT BY LEVEL<=24