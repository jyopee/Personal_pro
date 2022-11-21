package com.yedam.project.userlec;

import java.util.List;

import com.yedam.project.Main.MemVO;

public interface UserDAO {

	List<UserVO> selectAll();

	UserVO select(UserVO userVO);
	
	void update(UserVO userVO, int num);

	void delete(int lect_);

	UserVO select2(int LectNum);
}
