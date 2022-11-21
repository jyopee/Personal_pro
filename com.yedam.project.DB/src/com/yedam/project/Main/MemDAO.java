package com.yedam.project.Main;

import java.util.List;

import com.yedam.project.login.LogVO;

public interface MemDAO { //데이터베이스 메소드
	
	
	List<MemVO> selectAll(); //��ü ��ȸ
	
	MemVO select(MemVO memVO);
	
	void insert(MemVO memVO);
	
	void update(String name,String email,String add,int num);
	
	void delete(int mem_num);
	
	
	
	
	
}
