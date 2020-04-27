--날짜함수
SELECT SYSDATE FROM daul;

--기본적인 날짜연산
SELECT 
SYSDATE 오늘,
SYSDATE+1 "내일(24h 뒤)",
sysdate-2 "그저께",
sysdate+ 1/24 "한시간뒤"
FROM DUAL ;

--일자 차이 계산
SELECT 
SYSDATE "오늘",
TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 시작,
sysdate-TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 경과
FROM DUAL ;

--Months-BETWEEN : 날짜 사이의 개월 수 
SELECT 
	--두 날짜중 큰 날짜를 먼저 써야 양수갓으로 나옴
	MONTHS_BETWEEN('2020-04-08','1997-05-02') 융두애기, 
	-- 규칙2 : 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
	MONTHS_BETWEEN('2012-02-29','2012-02-01') "2/29-2/01",
	Months_between('2012-04-30','2012-04-01') "4/1-4/30",
	Months_between('2012-05-31','2012-05-01') "5/1-5/31"
FROM dual;

--#4501
SELECT 
NAME ,TO_CHAR(sysdate,'YYYY-MM-DD') 오늘,TO_CHAR(HIREDATE ,'YYYY-MM-DD') 입사일,
ROUND(Months_between(sysdate,HIREDATE)/12) 근속연수,
Round(Months_between(sysdate,HIREDATE),1) 근속개월,
Round(Months_between(sysdate,HIREDATE)*365,1) 근속일
FROM T_PROFESSOR 

--ADD_MONTH() 개월 추가
SELECT SYSDATE, ADD_MONTHS(sysdate,3)
FROM DUAL ;

SELECT SYSDATE, LAST_DAY(sysdate) "이번달마지막날",
NEXT_DAY(sysdate,'월') "다음월요일"
FROM DUAL ;

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.
SELECT sysdate,
round(sysdate),
trunc(sysdate)
FROM dual;

