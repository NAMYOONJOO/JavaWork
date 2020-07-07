package com.lec.sts15_mybatis.board.beans;

import java.util.List;

public interface IWriteDAO {
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	//public BWriteDTO readByUid(final int uid);
	public BWriteDTO selectByUid(final int uid);
	public int update(String subject, String content,int uid);
	public int deleteByUid(final int uid); 
	
	public int incViewCnt(int uid);   // 조회수 증가
}











