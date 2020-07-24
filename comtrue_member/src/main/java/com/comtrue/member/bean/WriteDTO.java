package com.comtrue.member.bean;

public class WriteDTO {
	
	//직원 정보는 직원번호(숫자3자리), 이름, 전화번호, 직급, 이메일 주소
	private int memberId;     
	private String name; 
	private String phoneNum;  
	private String position; 
	private String email;
	
	public WriteDTO() {
		super();
	}
	
	public WriteDTO(int memberId, String name, String phoneNum, String position, String email) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.phoneNum = phoneNum;
		this.position = position;
		this.email = email;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}  
}
