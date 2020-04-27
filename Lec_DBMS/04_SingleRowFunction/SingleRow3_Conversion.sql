--묵시적 자동 형변환 예
SELECT 1+1
FROM dual;

SELECT '1'+1 --2?
-- 문자가 숫자로 형변환 (자바와 반대이다)
FROM dual;
--위와 동일한 동작을 합니다. 
SELECT TO_NUMBER('1')+1
FROM dual;

--################################
--TO_CHAR 함수 (날짜->문자)
SELECT 
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY'), --연도 네자리로 변환
	TO_CHAR(SYSDATE, 'RRRR'), --연도 Y2K버그이후
	TO_CHAR(SYSDATE, 'YY'), --연도 두자리로 변환
	TO_CHAR(SYSDATE, 'YEAR') --연도영문
FROM DUAL ;

SELECT 
	TO_CHAR(SYSDATE, 'DD') 일숫자2자리,
	TO_CHAR(SYSDATE, 'DDTH') 몇번째날,
	TO_CHAR(SYSDATE, 'DAY') 요일,
	TO_CHAR(SYSDATE, 'Dy') 요일앞자리
FROM DUAL ;

SELECT 
	TO_CHAR(SYSDATE, 'MM' ) 월두자리,
	TO_CHAR(SYSDATE, 'MON') 월3자리,  -- 7월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM dual;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	
FROM dual;

--#4301
SELECT 
 TO_CHAR(SYSDATE, 'YY/MM/dd') "SYSDATE",
 TO_CHAR(SYSDATE, 'YYYY-MM-dd hh24:mm:ss') 날짜 
 FROM dual;

-- #4302
SELECT NAME ,TO_CHAR(BIRTHDAY , 'YYYY-MM-dd') 생일
FROM T_STUDENT 
WHERE TO_CHAR(BIRTHDAY,'MM')='03' 


-- TO_CHAR : 대소문자 지정예
SELECT
SYSDATE,
TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM DUAL

-- ##################################
--TO_CHAR() 함수 - 숫자를 문자로 변환

SELECT 
1234,
TO_CHAR(1234,'99999') "9하나당 1자리 ",--다섯자리에 맞춰서 출력
TO_char(1234,'099999') "빈자리0으로",
To_char(1234,'$9999') "빈자리 $로",
To_char(1234.1234,'9999.99') "소수점 이하 2자리",
To_char(123456,'999,999') "천자리단위 구분기호""
FROM DUAL ;


-- #4303
SELECT NAME ,
TO_CHAR(NVL2(BONUS,pay*12+BONUS,pay*12),'9,999') 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

--TO_NUMBER
SELECT 
TO_NUMBER('123.44')
FROM DUAL ;


-- TO_DATE() 함수 - 문자->날짜로 변환
SELECT 
	TO_DATE('2020-02-29', 'YYYY-MM-DD') 
	 --범위 벗어나는 날짜는 변환 불가
FROM DUAL ;


-- #4304
SELECT 
NAME, 
TO_CHAR(HIREDATE,'YYYY-MM-DD') 입사일,
To_char(pay*12,'9,999') 연봉, 
TO_CHAR(pay*12*1.1,'9,999') 인상후 
FROM T_PROFESSOR 
WHERE to_char(HIREDATE,'YYYY') < '2000'
