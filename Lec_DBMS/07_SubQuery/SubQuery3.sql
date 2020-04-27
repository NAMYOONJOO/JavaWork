
CREATE TABLE test_emp_a (
emp_id NUMBER,
emp_name Varchar2(100)
);


CREATE TABLE test_emp_b (
emp_id NUMBER,
emp_name Varchar2(100)
);

DELETE FROM test_emp_a;
DELETE FROM test_emp_b;


--한 row 씩 insert
INSERT INTO test_emp_a values(101,'장유성');
INSERT INTO test_emp_b values(201,'고유성');

SELECT *
FROM TEST_EMP_A ;


SELECT * 
FROM TEST_EMP_B ;

-- 동시에 여러개의 table에 insert하기

-- 다중 테이블 INSERT 구문에 sub Query 필요

INSERT ALL 
INTO TEST_EMP_A VALUES (102,'조현주')
INTO TEST_EMP_B VALUES (202,'최현주')
SELECT * FROM dual;
-- 마지막줄 필수임

--sub Query로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM dual);
INSERT INTO TEST_EMP_B (SELECT 500, '김성원' FROM dual);

--TABLE 묻고 더블로가
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A); 

INSERT INTO Test_emp_b(emp_name) (SELECT emp_name FROM TEST_EMP_A);

