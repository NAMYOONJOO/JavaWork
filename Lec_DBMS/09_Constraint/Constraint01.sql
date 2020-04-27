-- 제약조건 (constraint)
-- 테이블 생성시 동시에 설정하기 

-- t_dept2.dcode 참조예쩡
SELECT * FROM T_DEPT2 ; -- dcode : 0001. 1000, 1001....

DROP TABLE t_emp3 CASCADE CONSTRAINT;
--#9001)   다음 조건을 만족하는 t_emp3 테이블 생성
-- 제약조건명을 명시하지 않는 방법
CREATE TABLE t_emp3 (
 NO number(4) PRIMARY KEY , 
 name varchar2(10) NOT NULL ,
 jumin varchar2(13) NOT NULL UNIQUE ,
 area Number(1) CHECK(area<5) ,
 deptno varchar2(6) REFERENCES t_dept2(dcode)
);

-- 별도의 항목으로 제약조건 정의 가능
DROP TABLE t_emp4 CASCADE CONSTRAINT;


CREATE TABLE t_emp4 (
 NO number(4) , 
 name varchar2(10) NOT NULL ,
 jumin varchar2(13) NOT NULL,
 area Number(1) ,
 deptno varchar2(6), 
 PRIMARY KEY(NO),
 unique(jumin),
 check(area<5),
 FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);
--NOT NULL 별도 정의 안됨

--제약조건에 별명을 붙여 관리 가능

--#9002)   다음 조건을 만족하는 t_emp4 테이블 생성
--제약조건명을 명시하여 정의 
DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3 (
 NO number(4) CONSTRAINT emp3_no_pk PRIMARY KEY , 
 name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL ,
 jumin varchar2(13) 
 	CONSTRAINT emp3_jumin_nn NOT NULL 
 	CONSTRAINT emp3_jumin_uk UNIQUE ,
 area Number(1) CONSTRAINT emp3_area_ck CHECK(area<5) ,
 deptno varchar2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
);

--구문따로
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
 NO number(4), 
 name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL ,
 jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
 area Number(1)  ,
 deptno varchar2(6),
 CONSTRAINT emp3_no_pk PRIMARY KEY (no),
 CONSTRAINT emp3_jumin_uk UNIQUE (jumin),
 CONSTRAINT emp3_area_ck CHECK(area<5),
 CONSTRAINT emp3_deptno_fk FOREIGN key(deptno) REFERENCES t_dept2(dcode) 
);

--#9003 제약조건 조회하기
SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP4'; --테이블명 대문자로 쓰기

SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status
FROM USER_CONSTRAINTS +

WHERE table_name = 'T_EMP3'; --테이블명 대문자로 쓰기

--#9005 : 제약조건에 맞는 OR 위배되는 DML 시도해보기
INSERT INTO t_emp3 values(1,'오라클','1234561234567',4,1000);
--두번하면 pk 때문에  에러난다. 
--SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated

INSERT INTO t_emp3 values(2,'오라클','1234561234567',4,1000);
--jumin unique 오류
--SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 values(2,'오라클','2222222222222',4,1000);
-- 2222222222222222222입력시  varchar2(13) 초과 오류 

INSERT INTO t_emp3 values(3,'오라클','2222222222222',10,1000);
--SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this COLUMN

INSERT INTO t_emp3 values(3,'오라클','2222222222222',3,2000);
--SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 (NO,Jumin,area,deptno)values(4,'3333333333333',4,1001);
-- NN오류 
--SQL Error [1400] [23000]: ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

-- INSERT 뿐 아니라 UPDATE/DELETE 에서도 오류 발생 가능 
UPDATE T_EMP3 SET area = 10 WHERE NO = 1; --check값 오류

SELECT * FROM T_EMP3; 
DELETE FROM T_DEPT2  WHERE DCODE =1000;-- 부모가 사라져버리기
--자식이 참조하고 있어  delete불가하다. 
--참조하고 있는 부모는 삭제 불가 


--#9005 테이블 생성 후 Alter 명령 사용하여 제약조건 추가 가능!
--t_emp4 의 name 컬럼 UNIQUE 제약조건 추가 
--ALTER ~ ADD
--ALTER ~ MODIFY
--ALTER ~ drop

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(name);

--t_emp4 테이블의 area 컬럼에 NOT NULL 제약조건 추가해보세요
--(과연 ADD CONSTRAINT 로 될까?)
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL(area);
--아니 안된다. 

-- 이미 기본값이 NULL 을 허용하기 때문에 ADD 대신 Modify로 해야한다. 
ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);


--#9007 t_emp4 테이블의 name 컬럼이 t_emp2 테이블의 name 컬럼의 값을 참조하도록 참조키 제약조건을 설정하세요
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY (name) REFERENCES t_emp2(name);
--SQL Error [2270] [42000]: ORA-02270: no matching unique or primary key for this column-list
--참조되는 부모테이블의 컬럼은 PRIMARY key이거나 Unique해야 한다.


--일단 부모테이블의 name을 unique로 바꾼뒤 위의 쿼리를 다시 실행해 보세요
ALTER TABLE T_EMP2 ADD CONstraINT emp2_name_uk UNIQUE(name);


--#9008
DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3 (
 NO number(4) CONSTRAINT emp3_no_pk PRIMARY KEY , 
 name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL ,
 jumin varchar2(13) 
 	CONSTRAINT emp3_jumin_nn NOT NULL 
 	CONSTRAINT emp3_jumin_uk UNIQUE ,
 area Number(1) CONSTRAINT emp3_area_ck CHECK(area<5) ,
 deptno varchar2(6) 
 	CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
	ON DELETE CASCADE --부모삭제되면 자식도 삭제 	
-- 	ON DELETE set NULL --부모삭제되면 null값으로  
	);


--#9009
--t_emp4 테이블의 name 필드의 제약조건에 
--부모 테이블이 삭제되면 NULL 이 되도록 설정하기 (ALTER 사용)
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk;
--기존 제약조건 삭제  alter~drop
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN key(name)
REFERENCES t_emp2(name) 
ON DELETE SET NULL;
-- 부모 삭제되면 자식은 null로 변함

---------------------------------------------------------------------
--disalbe novalidate 


--#9010
SELECT * FROM T_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

--제약조건 조회
SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status 
FROM USER_constraints
WHERE TABLE_name ='T_VALIDATE';

INSERT INTO T_VALIDATE values(1,'DDD'); --처음에 에러 ! PK니까


SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status 
FROM USER_constraints
WHERE TABLE_name ='T_NOVALIDATE';

INSERT INTO T_NOVALIDATE values(1,'DDD');

ALTER TABLE T_NOVALIDATE 
disable NOVALIDATE CONSTRAINT SYS_C007031;
--status 값 enalbed->disabled
--위에꺼 다시 실행시 에러가 나지 않는다. 

SELECT * FROM T_NOVALIDATE ;

ALTER TABLE T_NOVALIDATE 
enable NOVALIDATE CONSTRAINT SYS_C007031;
--불가능 //primarykey 조건 위반 

DELETE FROM T_NOVALIDATE WHERE NAME ='DDD';
-- 다시 enable 시키면 성공~


