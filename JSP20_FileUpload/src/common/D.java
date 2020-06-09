package common;
/*
 * DB 접속 정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라키터 등에서 관리하는 것이 좋다. 
 */
public class D {
   public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
   public static String URL ="jdbc:oracle:thin:@localhost:1521:XE";
   public static String UID = "scott0316";
   public static String UPW = "tiger0316";
   
   public static String SQL_WRITE_SELECT=
   "SELECT * FROM test_write ORDER BY wr_uid DESC";
   
   public static String SQL_WRITE_INSERT = 
   "INSERT INTO test_write"+"(wr_uid, wr_subject,wr_content,wr_name)"+
   "VALUES(test_write_seq.nextval,?,?,?)";
   
   public static String SQL_WRITE_INC_VIEWCNT = //조회수 증가
   "UPDATE test_write SET wr_viewcnt=wr_viewcnt+1 WHERE wr_uid=?";

   public static String SQL_WRITE_SELECT_BY_UID= //글 읽어오기 
   "SELECT * FROM test_write WHERE wr_uid = ?";
   
   public static String SQL_WRITE_UPDATE = 
   "UPDATE test_write SET wr_subject = ?,wr_content=? Where wr_uid = ?";
   
   public static String SQL_WRITE_DELETE_BY_UID = 
   "DELETE FROM test_write WHERE wr_uid=?";
	   
	   
   //첨부파일용 쿼리
   //특정글(wr_uid)의 첨부파일 1 INSERT
   public static final String SQL_FILE_INSERT = 
		   "INSERT INTO test_file"
		   +"(bf_uid, bf_source,bf_file,wr_uid)"
		   +"VALUES"
		   +"(test_file_seq.nextval,?,?,?)";
   
   
   //특정 글(wr_uid)의 첨부파일
   public static final String SQL_FILE_SELECT = 
		   "SELECT bf_uid, bf_source, bf_file FROM test_file "
		   +"WHERE wr_uid = ?"
		   +"ORDER BY bf_uid DESC";
   //특정 첨부파일 (bf_uid) 하나를 SELECT
   public static final String SQL_FILE_SELECT_BY_UID = 
		   "SELECT bf_uid, bf_source, bf_file FROM test_file "
		   +"WHERE bf_uid=?";
   //특정 첨부파일 (bf_uid)하나를 DELETE
   public static final String SQL_FILE_DELETE_BY_UID = 
		   "DELETE FROM test_file WHERE br_uid = ?";
   
   //특정글(wr_uid)의 첨부파일(들)을 DELETE
   public static final String SQL_FILE_DELETE_BY_WRUID=
		   "DELETE FROM test_file WHERE wr_uid = ?";

}
