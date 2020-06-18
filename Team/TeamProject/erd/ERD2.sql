
/* Drop Sequences */

DROP SEQUENCE SEQ_Category_Cid;
DROP SEQUENCE SEQ_CommentQ_Cid;
DROP SEQUENCE SEQ_Comment_Cid;
DROP SEQUENCE SEQ_Comment_Cno;
DROP SEQUENCE SEQ_ComReview_CRno;
DROP SEQUENCE SEQ_ComReview_Rno;
DROP SEQUENCE SEQ_Consulting_Cno;
DROP SEQUENCE SEQ_Consulting_CSno;
DROP SEQUENCE SEQ_Knowhow_Kid;
DROP SEQUENCE SEQ_Picture_Pid;
DROP SEQUENCE SEQ_Picture_Pno;
DROP SEQUENCE SEQ_PQuestion_PQid;
DROP SEQUENCE SEQ_Product_Pid;
DROP SEQUENCE SEQ_Purchase_PCid;
DROP SEQUENCE SEQ_Question_Qid;
DROP SEQUENCE SEQ_question_Qno;
DROP SEQUENCE SEQ_Review_Rid;
DROP SEQUENCE SEQ_ShoppingBasket_SBid;




/* Create Sequences */

CREATE SEQUENCE SEQ_Category_Cid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_CommentQ_Cid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Comment_Cid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Comment_Cno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ComReview_CRno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ComReview_Rno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Consulting_Cno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Consulting_CSno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Knowhow_Kid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Picture_Pid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Picture_Pno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PQuestion_PQid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Product_Pid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Purchase_PCid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Question_Qid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_question_Qno INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Review_Rid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ShoppingBasket_SBid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Category
(
	-- 카테코리 코드
	-- 
	Cid number NOT NULL UNIQUE,
	Cname varchar2(10),
	PRIMARY KEY (Cid)
);


CREATE TABLE CommentQ
(
	Cid number NOT NULL UNIQUE,
	-- 사용자 아이디입니다.
	Cuid varchar2(20) NOT NULL,
	Cqno number NOT NULL,
	Ccontent clob NOT NULL,
	PRIMARY KEY (Cid)
);


CREATE TABLE Company
(
	Cno number NOT NULL UNIQUE,
	Cname varchar2(20) NOT NULL,
	Cadr varchar2(40) NOT NULL,
	Ctel number NOT NULL,
	Carea varchar2(20) NOT NULL,
	PRIMARY KEY (Cno)
);


CREATE TABLE Consulting
(
	CSno number NOT NULL,
	CScno number NOT NULL,
	-- 사용자 아이디입니다.
	CSuid varchar2(20) NOT NULL,
	CSname varchar2(20) NOT NULL,
	CSarea varchar2(20) NOT NULL,
	CSphoneNum number NOT NULL,
	PRIMARY KEY (CSno)
);


CREATE TABLE HomeUser
(
	-- 사용자 아이디입니다.
	Uidhome varchar2(20) NOT NULL UNIQUE,
	Upw varchar2(20) NOT NULL,
	-- 사용자이름
	Uname varchar2(10) NOT NULL,
	-- 0 : 남자
	-- 1 : 여자 
	Ugender number DEFAULT 0 NOT NULL,
	Utel varchar2(11) NOT NULL,
	Uemail varchar2(20) NOT NULL,
	-- 0 : 활성화 
	-- 1 : 비활성화 (탈퇴) 
	Ustate number DEFAULT 0 NOT NULL,
	-- 0 : 회원
	-- 1 : 관리자 
	Usuper number NOT NULL,
	Uaddress varchar2(100) NOT NULL,
	Uzipcode number NOT NULL,
	-- 사용자 주민번호
	Ujumin number NOT NULL,
	-- 관리자
	Umoditime date NOT NULL,
	Uimage varchar2(200),
	Unickname varchar2(10),
	-- 관리자페이지에서 필요
	Uregdate date,
	-- 관리자페이지에서 필요
	Ulogtime date,
	-- 선택약관 동의 : 0
	-- 선택약관 비동의 : 1
	Uyaggwan number NOT NULL,
	-- 0 : 이용빈도 낮음
	-- 1 : 재가입
	-- 2 : 개인정보 보호
	-- 3 : 회원특혜/쇼핑해택부족
	-- 4: : 콘텐츠/제품정보/상품부족
	-- 5 : 기타
	Utaltoe number,
	PRIMARY KEY (Uidhome)
);


CREATE TABLE PClist
(
	PCLid number NOT NULL,
	PCLpid number NOT NULL,
	PCLpcnt number NOT NULL
);


CREATE TABLE Picture
(
	Pid number NOT NULL UNIQUE,
	Pqno number NOT NULL,
	Ppicture varchar2(100),
	PRIMARY KEY (Pid)
);


CREATE TABLE Pimage
(
	pfuid number NOT NULL,
	pfsource varchar2(100) NOT NULL,
	pffile varchar2(200) NOT NULL,
	pfpid number NOT NULL,
	PRIMARY KEY (pfuid)
);


CREATE TABLE PQuestion
(
	PQid number NOT NULL UNIQUE,
	PQpid number NOT NULL,
	-- 사용자 아이디입니다.
	PQuid varchar2(20) NOT NULL,
	PQregdate date NOT NULL,
	PQcontent clob NOT NULL,
	PQanswer clob,
	PRIMARY KEY (PQid)
);


CREATE TABLE Product
(
	Pid number NOT NULL UNIQUE,
	Pname varchar2(20) NOT NULL,
	Pprice number DEFAULT 0 NOT NULL,
	Pbrand varchar2(20),
	-- 이미지 url
	-- 
	Pimage varchar2(300),
	-- 상품 카테코리 코드
	-- 
	Pcode number NOT NULL UNIQUE,
	PRIMARY KEY (Pid)
);


CREATE TABLE Purchase
(
	PCid number NOT NULL UNIQUE,
	-- 사용자 아이디입니다.
	PCuid varchar2(20) NOT NULL UNIQUE,
	PCtotalprice number,
	PCregdate date NOT NULL,
	-- 0: 입금대기
	-- 1: 결제완료
	-- 2: 배송준비
	-- 3: 배송중
	-- 4: 배송완료
	-- 5: 구매확정
	PCstatus number NOT NULL,
	PCaddress varchar2(50) NOT NULL,
	PCaddressnum number NOT NULL,
	PCcontent varchar2(50),
	PCcardnum number NOT NULL,
	PRIMARY KEY (PCid)
);


CREATE TABLE Question
(
	Qno number NOT NULL UNIQUE,
	-- 사용자 아이디입니다.
	Quid varchar2(20) NOT NULL UNIQUE,
	Qtitle varchar2(20) NOT NULL,
	Qcontent clob NOT NULL,
	Qregdate date NOT NULL,
	Qclickcnt number NOT NULL,
	-- 구분점을 이용하여 키워드를 구분할 예정
	-- 1개 필수, 5기 이하 등록 가능
	Qkeyword clob NOT NULL,
	PRIMARY KEY (Qno)
);


CREATE TABLE Report
(
	Rid number NOT NULL UNIQUE,
	Rqno number NOT NULL UNIQUE,
	-- 사용자 아이디입니다.
	Ruid varchar2(20) NOT NULL UNIQUE,
	-- 신고 사유는 라디오 박스로 넘버링할 예정
	Rselect number NOT NULL,
	PRIMARY KEY (Rid)
);


CREATE TABLE SaleProduct
(
	SPid number NOT NULL UNIQUE,
	SPregdate date NOT NULL
);


CREATE TABLE UserAccess
(
	-- 사용자 아이디입니다.
	UAid varchar2(20) NOT NULL,
	-- 사용자 접속시간
	UAtime date NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE Product
	ADD FOREIGN KEY (Pcode)
	REFERENCES Category (Cid)
;


ALTER TABLE Consulting
	ADD FOREIGN KEY (CScno)
	REFERENCES Company (Cno)
;


ALTER TABLE CommentQ
	ADD FOREIGN KEY (Cuid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE Consulting
	ADD FOREIGN KEY (CSuid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE PQuestion
	ADD FOREIGN KEY (PQuid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE Purchase
	ADD FOREIGN KEY (PCuid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE Question
	ADD FOREIGN KEY (Quid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE Report
	ADD FOREIGN KEY (Ruid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE UserAccess
	ADD FOREIGN KEY (UAid)
	REFERENCES HomeUser (Uidhome)
;


ALTER TABLE PClist
	ADD FOREIGN KEY (PCLpid)
	REFERENCES Product (Pid)
;


ALTER TABLE Pimage
	ADD FOREIGN KEY (pfpid)
	REFERENCES Product (Pid)
;


ALTER TABLE PQuestion
	ADD FOREIGN KEY (PQpid)
	REFERENCES Product (Pid)
;


ALTER TABLE SaleProduct
	ADD FOREIGN KEY (SPid)
	REFERENCES Product (Pid)
;


ALTER TABLE PClist
	ADD FOREIGN KEY (PCLid)
	REFERENCES Purchase (PCid)
;


ALTER TABLE CommentQ
	ADD FOREIGN KEY (Cqno)
	REFERENCES Question (Qno)
;


ALTER TABLE Picture
	ADD FOREIGN KEY (Pqno)
	REFERENCES Question (Qno)
;


ALTER TABLE Report
	ADD FOREIGN KEY (Rqno)
	REFERENCES Question (Qno)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Category_Cid BEFORE INSERT ON Category
FOR EACH ROW
BEGIN
	SELECT SEQ_Category_Cid.nextval
	INTO :new.Cid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_CommentQ_Cid BEFORE INSERT ON CommentQ
FOR EACH ROW
BEGIN
	SELECT SEQ_CommentQ_Cid.nextval
	INTO :new.Cid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Comment_Cid BEFORE INSERT ON Comment
FOR EACH ROW
BEGIN
	SELECT SEQ_Comment_Cid.nextval
	INTO :new.Cid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Comment_Cno BEFORE INSERT ON Comment
FOR EACH ROW
BEGIN
	SELECT SEQ_Comment_Cno.nextval
	INTO :new.Cno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_ComReview_CRno BEFORE INSERT ON ComReview
FOR EACH ROW
BEGIN
	SELECT SEQ_ComReview_CRno.nextval
	INTO :new.CRno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_ComReview_Rno BEFORE INSERT ON ComReview
FOR EACH ROW
BEGIN
	SELECT SEQ_ComReview_Rno.nextval
	INTO :new.Rno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Consulting_Cno BEFORE INSERT ON Consulting
FOR EACH ROW
BEGIN
	SELECT SEQ_Consulting_Cno.nextval
	INTO :new.Cno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Consulting_CSno BEFORE INSERT ON Consulting
FOR EACH ROW
BEGIN
	SELECT SEQ_Consulting_CSno.nextval
	INTO :new.CSno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Knowhow_Kid BEFORE INSERT ON Knowhow
FOR EACH ROW
BEGIN
	SELECT SEQ_Knowhow_Kid.nextval
	INTO :new.Kid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Picture_Pid BEFORE INSERT ON Picture
FOR EACH ROW
BEGIN
	SELECT SEQ_Picture_Pid.nextval
	INTO :new.Pid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Picture_Pno BEFORE INSERT ON Picture
FOR EACH ROW
BEGIN
	SELECT SEQ_Picture_Pno.nextval
	INTO :new.Pno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_PQuestion_PQid BEFORE INSERT ON PQuestion
FOR EACH ROW
BEGIN
	SELECT SEQ_PQuestion_PQid.nextval
	INTO :new.PQid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Product_Pid BEFORE INSERT ON Product
FOR EACH ROW
BEGIN
	SELECT SEQ_Product_Pid.nextval
	INTO :new.Pid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Purchase_PCid BEFORE INSERT ON Purchase
FOR EACH ROW
BEGIN
	SELECT SEQ_Purchase_PCid.nextval
	INTO :new.PCid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Question_Qid BEFORE INSERT ON Question
FOR EACH ROW
BEGIN
	SELECT SEQ_Question_Qid.nextval
	INTO :new.Qid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_question_Qno BEFORE INSERT ON question
FOR EACH ROW
BEGIN
	SELECT SEQ_question_Qno.nextval
	INTO :new.Qno
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Review_Rid BEFORE INSERT ON Review
FOR EACH ROW
BEGIN
	SELECT SEQ_Review_Rid.nextval
	INTO :new.Rid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_ShoppingBasket_SBid BEFORE INSERT ON ShoppingBasket
FOR EACH ROW
BEGIN
	SELECT SEQ_ShoppingBasket_SBid.nextval
	INTO :new.SBid
	FROM dual;
END;

/




/* Comments */

COMMENT ON COLUMN Category.Cid IS '카테코리 코드
';
COMMENT ON COLUMN CommentQ.Cuid IS '사용자 아이디입니다.';
COMMENT ON COLUMN Consulting.CSuid IS '사용자 아이디입니다.';
COMMENT ON COLUMN HomeUser.Uidhome IS '사용자 아이디입니다.';
COMMENT ON COLUMN HomeUser.Uname IS '사용자이름';
COMMENT ON COLUMN HomeUser.Ugender IS '0 : 남자
1 : 여자 ';
COMMENT ON COLUMN HomeUser.Ustate IS '0 : 활성화 
1 : 비활성화 (탈퇴) ';
COMMENT ON COLUMN HomeUser.Usuper IS '0 : 회원
1 : 관리자 ';
COMMENT ON COLUMN HomeUser.Ujumin IS '사용자 주민번호';
COMMENT ON COLUMN HomeUser.Umoditime IS '관리자';
COMMENT ON COLUMN HomeUser.Uregdate IS '관리자페이지에서 필요';
COMMENT ON COLUMN HomeUser.Ulogtime IS '관리자페이지에서 필요';
COMMENT ON COLUMN HomeUser.Uyaggwan IS '선택약관 동의 : 0
선택약관 비동의 : 1';
COMMENT ON COLUMN HomeUser.Utaltoe IS '0 : 이용빈도 낮음
1 : 재가입
2 : 개인정보 보호
3 : 회원특혜/쇼핑해택부족
4: : 콘텐츠/제품정보/상품부족
5 : 기타';
COMMENT ON COLUMN PQuestion.PQuid IS '사용자 아이디입니다.';
COMMENT ON COLUMN Product.Pimage IS '이미지 url
';
COMMENT ON COLUMN Product.Pcode IS '상품 카테코리 코드
';
COMMENT ON COLUMN Purchase.PCuid IS '사용자 아이디입니다.';
COMMENT ON COLUMN Purchase.PCstatus IS '0: 입금대기
1: 결제완료
2: 배송준비
3: 배송중
4: 배송완료
5: 구매확정';
COMMENT ON COLUMN Question.Quid IS '사용자 아이디입니다.';
COMMENT ON COLUMN Question.Qkeyword IS '구분점을 이용하여 키워드를 구분할 예정
1개 필수, 5기 이하 등록 가능';
COMMENT ON COLUMN Report.Ruid IS '사용자 아이디입니다.';
COMMENT ON COLUMN Report.Rselect IS '신고 사유는 라디오 박스로 넘버링할 예정';
COMMENT ON COLUMN UserAccess.UAid IS '사용자 아이디입니다.';
COMMENT ON COLUMN UserAccess.UAtime IS '사용자 접속시간';





CREATE TABLE Pimage
(
	pfuid number NOT NULL,
	pfsource varchar2(200) NOT NULL,
	pffile varchar2(200) NOT NULL,
	pfpid number NOT NULL,
	PRIMARY KEY (pfuid)
);
CREATE SEQUENCE SEQ_Pimage INCREMENT BY 1 START WITH 1;
SELECT COUNT(PFPID) FROM Pimage WHERE PFPID =1;
SELECT *FROM PIMAGE ;

DROP TABLE Pimage;
CREATE TABLE Pimage
(
	pfuid number NOT NULL,
	pfsource varchar2(200) NOT NULL,
	pffile varchar2(200) NOT NULL,
	pfpid number NOT NULL,
	PRIMARY KEY (pfuid)
);


DROP SEQUENCE pfile_seq;
CREATE SEQUENCE pfile_seq;
INSERT INTO PIMAGE VALUES (pfile_seq.nextval,'dd','dd',1);

SELECT * FROM PRODUCT ;