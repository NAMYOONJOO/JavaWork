package phonebook02.mvc;

import java.util.Arrays;

//CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD) (Business logic 당담)
public class PhonebookManager implements PhonebookController {
	public static final int MAX_DATA = 3;// 최대 데이터 개수 ->6->9->12
	// 배열로 구현.
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];

	// 몇개의 데이터가 저장되었느지
	private int count = 0;

	// singleton 적용
	private PhonebookManager() {
		// TODO Auto-generated constructor stub
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
		int result = PhonebookController.QUERY_FAIL;//0
		//매개변수 검증 : 이름 필수 ->이름 입력안되면 실패 
		if(name == null || name.trim().length()==0) {
			return result;
		}
		
		
		// 만약 배열이 다 차있으면, MAX_DATA 만큼 추가된 새 배열 작성
		if(count ==pbList.length) {
			pbList = Arrays.copyOf(pbList,pbList.length+MAX_DATA);//3->6
			
		}
		
		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count] .setUid(getMaxUid()+1);//기존의 최대 uid값보다 1증가한 값, (unique한 값 보장)
		//Uid와 배열 Index는 다르다 
		count++;

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		return Arrays.copyOfRange(pbList, 0, count); //count가 0이면 length0 짜리 배열 리턴
	}

	@Override
	public PhonebookModel selectByUid(int uid) {
		//특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴
		//		없으면 null 리턴
		
		for(int index = 0 ; index<count;index++) {
			if(pbList[index].getUid()==uid) {
				return pbList[index];// uid발견하면 리턴
			}
		}
		return null; //못찾으면
	}//end selectByUid

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		int result = PhonebookController.QUERY_FAIL;
		
		//매개변수 검증
		if(uid<1)return result;
		if(name==null|name.trim().length()==0) return result; //이름 필수
		
		// 특정 uid값을 가진 데이터의 배열 인덱스 찾기 
		int index = findIndexByUid(uid);
		if(index<0)return result;//fail
		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);;
		pbList[index].setMemo(memo);
		result =  1; //수정성공
		
		return 0;
	}

	@Override
	public int deletebyUid(int uid) {

		int result = PhonebookController.QUERY_FAIL;
		
		//매개변수 검증
		if(uid<1)return result;
		int index = findIndexByUid(uid);
		if(index<0) {
			return result;
		}
		
		//배열 뒤의 원소들을 앞으로 이동
		for (int i = index, j= index+1; j<count ; i++,j++) {
			pbList[i]=pbList[j];
		}
		
		//count 감소
		count--;
		result = 1;
		return result;
	}
	//현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		for(int index = 0; index< count; index++)
		{
			if(maxUid<pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		
		return maxUid;
	}
	// 특정 uid값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for(int index = 0; index<count; index++) {
			if(pbList[index].getUid()==uid) {
				return index;
			}
		}
		return -1;
		
	}

}
