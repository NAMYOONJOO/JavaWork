package phonebook04.list;

import java.text.SimpleDateFormat;
import java.util.Date;
//모델객체
//데이터 표현
public class PhonebookModel {
	private int uid;	//unique id
	private String name;
	private String phoneNum;
	private String memo;// 메일
	private Date regDate;//등록일시

	public PhonebookModel() {
		this.name = "";
		this.phoneNum = "";
		this.memo = "";
		this.regDate= new Date(); //생성되는 현재시간
	}

	public PhonebookModel(String name, String phoneNum, String email) {
		this();
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = email;
	}
	

	public PhonebookModel(int uid, String name, String phoneNum, String email, Date regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = email;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		String str = String.format("%3d|%s|%s|%s|%20s", 
				uid, name, phoneNum, memo, 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		return str;
	}

}
