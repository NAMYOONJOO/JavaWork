package phonebook05.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;



//CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD) (Business logic 당담)
public class PhonebookManager implements Pb, Closeable {

	public static final String PB_DATA_DIR = "data";
	public static final String PB_DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton 적용
	private PhonebookManager() {
		// TODO
		// 파일이 존재하면 ㅍ하일 읽어들이기 --->pbList;
		// FileNotFoundException 여부로 확인
		
		
		// 여기 부분 싱글톤 패턴 만들라고 시험문제 나와요
		pbDir = new File(PB_DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			}else {
				System.out.println("폴더 생성 실패");
			}
		}else {
			System.out.println("폴더 존재 : " + pbDir.getAbsolutePath());
		}
		
		pbFile = new File(pbDir ,PB_DATA_FILE);
		if(pbFile.exists()) { //파일이 존재한다면
			System.out.println(" 파일에서 데이터 읽습니다 ...");
			try (
					InputStream in = new FileInputStream(pbFile);
					ObjectInputStream oin = new ObjectInputStream(in);
					){
				pbList = (ArrayList<PhonebookModel>)oin.readObject();
				System.out.println(pbList.size()+ "개의 데이터를 읽었습니다. ");
			} catch (FileNotFoundException e) {
//				System.out.println("파일없슴");
			} catch (IOException e) {
			} catch (ClassNotFoundException e) {
			}
		}else {
			System.out.println("읽어올 파일이 없습니다. ");
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

		PhonebookModel pbModel = new PhonebookModel(name, phoneNum, memo);
		pbList.add(pbModel);
		pbModel.setUid(getMaxUid() + 1);
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
//		PhonebookModel[] result = new PhonebookModel[pbList.size()];
//		for (int i = 0; i < pbList.size(); i++) {
//			result[i] = pbList.get(i);
//		}
//		return result; // count가 0이면 length0 짜리 배열 리턴
		return pbList.toArray(new PhonebookModel[pbList.size()]);

	}

	@Override
	public PhonebookModel selectByUid(int uid) {
		// 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴
		// 없으면 null 리턴
		int index = 0;
		for (PhonebookModel e : pbList) {
			if (e.getUid() == uid) {
				return pbList.get(index);
			}
			index++;
		}
		return null; // 못찾으면
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
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid : " + uid, Pb.ERR_UID);

		pbList.set(index, new PhonebookModel(name, phoneNum, memo));
//		pbList.get(index).setUid(uid);
//		pbList.get(index).setName(name);
//		pbList.get(index).setPhoneNum(phoneNum);
//		pbList.get(index).setMemo(memo); 
		// 위에가 더 효율

//		result = 1; // 수정성공
		return 1;
//		return 0;
	}

	@Override
	public int deletebyUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류 : " + uid, Pb.ERR_UID);
//			return result;
		int index = findIndexByUid(uid);
		if (index < 0) {
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);
//			return result;
		}

		pbList.remove(findIndexByUid(uid));

		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxIndex = pbList.size() - 1;

		int maxUid = 0;

		for (int index = 0; index < pbList.size() - 1; index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}
		return maxUid;
	}

	// 특정 uid값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {

		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return index;
			}
		}

		return 1;

	}

	@Override
	public void close() throws IOException {

		// TODO
		// pblist ->로 저장
	
		OutputStream out = new FileOutputStream(new File(pbDir, PB_DATA_FILE));
		ObjectOutputStream oout = new ObjectOutputStream(out);
		
		oout.writeObject(pbList);
		oout.close();
		System.out.println("파일 저장 완료");//친절한 메세지 

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
