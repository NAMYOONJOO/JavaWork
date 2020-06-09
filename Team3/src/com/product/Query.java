package com.product;


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
	public static final String COL_LABEL_PID = "pid";
	public static final String COL_LABEL_PNAME = "pname";
	public static final String COL_LABEL_PPRICE = "pprice";
	public static final String COL_LABEL_PBRAND = "pbrand";
	public static final String COL_LABEL_PIMAGE = "pimage";
	public static final String COL_LABEL_PCODE = "pcode";
	public static final String SEQ_NAME = "product_seq";
	
	// PreparedStatement에서 사용될 SQL 문장
	public static final String SQL_SELECT_ALL =
			"SELECT * FROM " + TBL_NAME;
	public static final String SQL_INSERT_SEQ = 
			"INSERT INTO " + TBL_NAME + " VALUES(" + SEQ_NAME + ".nextval, ?,?,?,?,?)";
	
	public static final String SQL_DROP_TABLE = 
			"DROP TABLE "+TBL_NAME+" CASCADE CONSTRAINTS";
	public static final String SQL_DROP_SEQ = 
			"DROP SEQUENCE "+SEQ_NAME;
	public static final String SQL_CREATE_SEQ = 
			"CREATE SEQUENCE "+SEQ_NAME;
	public static final String SQL_CREATE_TABLE = 
			"CREATE TABLE Product" + 
			"(" + 
			"	Pid number NOT NULL ," + 
			"	Pname varchar2(100) NOT NULL," + 
			"	Pprice number DEFAULT 0 NOT NULL," + 
			"	Pbrand varchar2(100)," + 
			"	Pimage varchar2(1000)," + 
			"	Pcode number NOT NULL," + 
			"	PRIMARY KEY (Pid)" + 
			")";


} // end Query(I)
