package com.lec.sts13_jdbc.board.beans;

import java.sql.Timestamp;

public class BWriteDTO {
	private int uid;// wr_uid
	private String subject;// wr_subject
	private String content;// wr_content
	private String name; // wr_name
	private int viewCnt;// wr_viewcnt
	private Timestamp regDate;// wr_regdate

	
	public BWriteDTO() {
		super();
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
	
	
	
	
	
}
