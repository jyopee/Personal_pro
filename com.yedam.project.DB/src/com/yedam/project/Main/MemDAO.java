package com.yedam.project.Main;

import java.util.List;

public interface MemDAO { //���̺� ������ ���� �������̽�
	
	
	List<MemVO> selectAll(); //��ü ��ȸ
	
	MemVO select(MemVO memVO);
	
	void insert(MemVO memVO);
	
	void update(MemVO memVO);
	
	void delete(int mem_num);
	
}
