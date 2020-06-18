package com.lec.beans;

import java.util.List;

public class AjaxWriteResult {
	private int count;   // 데이터 개수
	private String status;  // 처리 결과
	private String message;  // 결과 메세지
	List<CategoryDTO> list;
	/*
	{
		count : ○○○,
		status : ○○○,
		message : ○○○
	}
	 */
	
	public List<CategoryDTO> getList() {
		return list;
	}

	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}

	public AjaxWriteResult() {}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	
	
	
}
