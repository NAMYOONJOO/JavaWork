package com.project.java.productlist;


/*CREATE TABLE Product
(
	Pid number NOT NULL ,
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
*/
public interface Query {
	
	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
		// JDBC 드라이버 클래스 정보
		public static final String DRIVER =
				"oracle.jdbc.driver.OracleDriver";
		// DB 서버 정보
		public static final String URL =
				"jdbc:oracle:thin:@localhost:1521:XE";
		// DB 사용자 계정 정보
		public static final String USER = "team5";
		public static final String PASSWD = "team5";

		public static final String TBL_NAME = "product";
		public static final String COL_LABEL_NO = "mb_no";
		public static final String COL_LABEL_NAME = "mb_name";
		public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";
		public static final String SEQ_NAME = "test_member_seq";

}
