package com.yedam.project.userlec;

import java.util.List;



public interface UserDAO {
	
	List<UserVO> selectAll();
	
	UserVO select(UserVO userVO);
	
	void insert(UserVO userVO);
	
	void update(String name,String email,String add,int num);
	
	void delete(int lect_);
}
