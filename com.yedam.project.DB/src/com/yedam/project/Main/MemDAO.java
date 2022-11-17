package com.yedam.project.Main;

import java.util.List;

public interface MemDAO { //테이블 접근을 위한 인터페이스
	
	
	List<MemVO> selectAll(); //전체 조회
	
	MemVO select(MemVO memVO);
	
	void insert(MemVO memVO);
	
	void update(MemVO memVO);
	
	void delete(int mem_num);
	
}
