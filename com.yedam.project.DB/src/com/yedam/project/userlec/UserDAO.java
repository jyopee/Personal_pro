package com.yedam.project.userlec;

import java.util.List;

import com.yedam.project.Main.MemVO;
import com.yedam.project.login.LogVO;

public interface UserDAO {

	List<UserVO> selectAll();

	UserVO select(UserVO userVO);
	
	void insert(UserVO userVO, MemVO memVO);

	void delete(int lect_);

	UserVO select2(int LectNum);
	
	MemVO select3(int Stunum);

}
