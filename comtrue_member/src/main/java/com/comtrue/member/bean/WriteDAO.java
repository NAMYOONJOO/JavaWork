package com.comtrue.member.bean;

import java.util.ArrayList;

public interface WriteDAO {
	public ArrayList<WriteDTO> select();

	public int insert(final WriteDTO dto);

	public WriteDTO readByMid(int memberId);

	public WriteDTO selectByMid(int memberId);

	public int update(final WriteDTO dto);

	public int deleteByMid(int memberId);
}
