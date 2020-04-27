-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO ,ENAME 
FROM T_EMP ;


SELECT rownum, EMPNO ,ENAME 
FROM T_EMP ;
--rownum : 자동적으로 오라클에서 붙여주는 행번호 객체 (RowNum)

-- 직원번호 역순, 그러나 rownum은 1~
SELECT rownum, EMPNO ,ENAME 
FROM T_EMP
ORDER BY EMPNO DESC ;

SELECT rownum, EMPNO ,ENAME 
FROM T_EMP
WHERE ROWNUM <=5
ORDER BY EMPNO DESC ;

--select에 rownum 없어도 정상 동작
SELECT EMPNO ,ENAME 
FROM T_EMP
WHERE ROWNUM <=5
ORDER BY EMPNO DESC ;

-- rownum > 5?? 동작안함.... rownum 범위가 1이 포함안되면 동작안함
SELECT rownum, EMPNO ,ENAME 
FROM T_EMP
WHERE ROWNUM > 5
ORDER BY EMPNO DESC ;


--상위 다섯개 출력
--row1 ~row5 (1page)

SELECT rownum, EMPNO ,ENAME 
FROM T_EMP
WHERE ROWNUM > =1and ROWNUM <1+5
ORDER BY EMPNO DESC ;

--5 씩 증가 //하지만 동작안함 (아래꺼)
-- (2page)
SELECT rownum, EMPNO ,ENAME 
FROM T_EMP
WHERE ROWNUM > =6and ROWNUM <6+5
ORDER BY EMPNO DESC ;

-- phonebook 뻥튀기 
SELECT *
FROM PHONEBOOK ;

INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK );
-- 에러 Primary key 중복!

INSERT INTO PHONEBOOK (SELECT phonebook_seq.nextval ,PB_NAME, PB_PHONENUM ,PB_MEMO, PB_REGDATE FROM PHONEBOOK );


--Rownum ver,
SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC;

SELECT T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC) T;

SELECT rownum AS RNUM , T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC) T;

-- 한페이지당 5개 데이터 
-- 2번째 페이지
SELECT * From(
SELECT rownum AS RNUM , T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC) T
)
WHERE rnum >= 6 AND RNUM <6+5;

-- 3번째 페이지
SELECT * From(
SELECT rownum AS RNUM , T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC) T
)
WHERE rnum >= 11 AND RNUM <11+5;

--한페이지당 10개 데이터 
--3번째 페이지
SELECT * From(
SELECT rownum AS RNUM , T.*
FROM (SELECT pb_uid, pb_name, pb_phonenum
FROM PHONEBOOK 
ORDER BY PB_UID DESC) T
)
WHERE rnum >= 21 AND RNUM <21+10;



