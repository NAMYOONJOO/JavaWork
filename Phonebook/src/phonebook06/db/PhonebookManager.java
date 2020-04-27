package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD) (Business logic 당담)
public class PhonebookManager implements Pb, Closeable {

	// TODO : DB를 위한 변수들 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton 적용
	private PhonebookManager() {

		// TODO :
		// JDBC 프로그래밍
		// 클래스 로딩
		// 연결 Connection
		// Statement( 필요하다면 ) 생성

		try {

			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");

			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();

		}
		return instance;
	}

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
//		int result = Pb.QUERY_FAIL;// 0
		// 매개변수 검증 : 이름 필수 ->이름 입력안되면 실패
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 입력오류 :", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;

		// TODO
		// SQL_INSERT 사용하여 INSERT
		// preparedStatement 사용..close

		try {
			// "INSERT INTO phonebook(pb_uid, pb_name, ph_phonenum, pb_memo)
			// VALUES(phonebook_seq.nextval, ?, ?, ?)"
			// **

			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 개 행(row) INSERT성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		// TODO
		// SQL_SELECT_ALL
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			int i = 0;
			rs = pstmt.executeQuery();
			ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
			while (rs.next()) {
				int uid = Integer.parseInt(rs.getString(COL_LABEL_UID));
				String name = rs.getString(COL_LABEL_NAME);
				String phonenum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				String date = rs.getString(COL_LABEL_REGDATE);
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dt=null;
				try {
					dt = fm.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PhonebookModel pbModel = new PhonebookModel(uid,name, phonenum, memo, dt);
				pbList.add(pbModel);

			}
			PhonebookModel[] result = new PhonebookModel[pbList.size()];
			for (int j = 0; j < pbList.size(); j++) {
				result[j] = pbList.get(j);
			}

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	@Override
	public PhonebookModel selectByUid(int uid) {
		// PhonebookModel pbModel = new PhonebookModel(name, phonenum, memo);
		// 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴
		// 없으면 null 리턴

		// TODO : 필수
		// Query문 정의해야됨
		PhonebookModel pbModel = null;

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				String name = rs.getString(COL_LABEL_NAME);
				String phonenum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);

				pbModel = new PhonebookModel(name, phonenum, memo);
				pbModel.setUid(uid);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pbModel;

	}// end selectByUid

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
//		int result = Pb.QUERY_FAIL;

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid오류 : " + uid, Pb.ERR_UID);
		if (name == null | name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 : " + uid, Pb.ERR_EMPTY_STRING);

		// 특정 uid값을 가진 데이터의 배열 인덱스 찾기

		int cnt = 0;

		// TODO
		// SQL_UPDATE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			// "UPDATE phonebook SET pb_name = ?, pb_phonenum = ?,pb_memo =? WHERE pb_uid
			// =?"
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 개 행(row) UPDATE성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
//		return 0;
	}

	@Override
	public int deletebyUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류 : " + uid, Pb.ERR_UID);
//		

		int cnt = 0;
		// TODO
		// SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			// "DELETE FROM phonebook WHERE pb_uid =?"
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();// DML 명령어 -> 정수형 리턴
			System.out.println(cnt + " 개 행(row) DELETE성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxIndex = 0;
		int maxUid = 0;
		// TODO 옵션

		return maxUid;

	}

	@Override
	public void close() throws IOException {

		// TODO
		// ResultSet
		// statement
		// connection등 close
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

//예외 클래스 정의1

//예외발생하면 ' 에러코드'+'에러메세지'를 부여하여 관리하는게 좋다. 
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR - " + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
}
