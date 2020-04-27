SELECT *FROM TEST_MEMBER 

INSERT INTO TEST_MEMBER 

--(DDL)
--INSERT INTO table이름
--UPDATE 테이블이름 SET
--DELETE FROM 테이블이름

INSERT INTO TEST_MEMBER  values(10, '남윤주', sysdate);
SELECT *FROM  TEST_MEMBER ;


INSERT INTO TEST_MEMBER VALUES (22,'이승환',sysdate);
INSERT INTO TEST_MEMBER VALUES (17,'윤종섭','2019-08-03');
INSERT INTO TEST_MEMBER VALUES ('','이예지','');-- 비어있는 ''를 insert하면 null값 처리
--INSERT INTO TEST_MEMBER VALUES (10,'',sysdate);
--Not Null로 지정했기때문에 오류

SELECT *FROM  TEST_MEMBER ;





--dBeaver에서는 기본적으로 auto-COMMIT 수행 