-- 게시글 테이블--------------------------------------------------------------------------
DROP TABLE Question;
DROP SEQUENCE SEQ_question_Qno;
-------------------------------------------------------------------------------------
-- 테이블 생성
CREATE TABLE Question
(
	-- 기본키 PK
	Qno number NOT NULL,
	-- 로그인 아이디 저장, FK, member 테이블로 FK
	Qmember_id VARCHAR2(20),
	Qtitle varchar2(100) NOT NULL,
	Qcontent clob NOT NULL,
	Qregdate date DEFAULT SYSDATE,
	Qclickcnt NUMBER DEFAULT 0,
	Qkeyword varchar2(50) NOT NULL,
	PRIMARY KEY (Qno)
);

-- FK 설정
ALTER TABLE Question
	ADD FOREIGN KEY (Qmember_id)
	REFERENCES member (MEMBER_ID);
-- 시퀀스 생성
CREATE SEQUENCE SEQ_question_Qno INCREMENT BY 1 START WITH 1;


-- 댓글 기능 구현 ------------------------------------------------------------------------
DROP TABLE QComment;
DROP SEQUENCE SEQ_QComment_Cno;
-------------------------------------------------------------------------------------
-- 테이블 생성
CREATE TABLE QComment
(
	-- 기본키 PK인 댓글 등록 번호
	Cno number NOT NULL,
	-- FK member 테이블과 PK시켜두기, 남긴사람 아이디가 필요
	Cmember_id VARCHAR2(20) NOT NULL,
	-- 게시글 번호, 어떤 게시글 번호의 소속인지 FK
	Cqno number NOT NULL,
	-- 댓글 내용
	Ccontent clob NOT NULL,
	-- 댓글 등록일
	Cregdate date DEFAULT SYSDATE,
	-- 기본키
	PRIMARY KEY (Cno)
);
-- 시퀀스 생성
CREATE SEQUENCE SEQ_QComment_Cno INCREMENT BY 1 START WITH 1;

-- FK 설정, 삭제시 제약 조건 필요
ALTER TABLE QComment
    ADD CONSTRAINT comment_fk_constraint
    FOREIGN KEY(Cqno) REFERENCES Question (Qno)
    ON DELETE CASCADE;
-- FK 설정
ALTER TABLE QComment
	ADD FOREIGN KEY (Cmember_id)
	REFERENCES member (MEMBER_ID);
	
-- 신고 페이지 --------------------------------------------------------------------------
DROP TABLE Qrepor;
DROP SEQUENCE SEQ_Qrepor_Rno;
-------------------------------------------------------------------------------------
-- 테이블 생성
CREATE TABLE Qrepor
(
	-- 기본키 PK, 신고번호
	Rno number NOT NULL,
	-- FK member 테이블과 PK시켜두기, 남긴사람 아이디가 필요
	Rmember_id VARCHAR2(20) NOT NULL,
	-- 신고 유형
	Rtype number NOT NULL,
	-- 게시글 번호
	Rqno number NOT NULL,
	-- 기본키
	PRIMARY KEY (Rno)
);
-- 시퀀스 생성
CREATE SEQUENCE SEQ_Qrepor_Rno INCREMENT BY 1 START WITH 1;

-- FK 설정, 삭제시 제약조건 필요
ALTER TABLE Qrepor
    ADD CONSTRAINT report_fk_constraint
    FOREIGN KEY(Rqno) REFERENCES Question(Qno)
    ON DELETE CASCADE;
ALTER TABLE Qrepor
	ADD FOREIGN KEY (Rmember_id)
	REFERENCES member (MEMBER_ID);