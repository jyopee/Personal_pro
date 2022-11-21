package com.yedam.project.login;

import com.yedam.project.Main.MemVO;
import com.yedam.project.userlec.UserVO;

public interface LogDAO {

	abstract LogVO login(LogVO logVO);
	abstract void Save(LogVO logVO);
	
	
}

