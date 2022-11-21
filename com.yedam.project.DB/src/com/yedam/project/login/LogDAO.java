package com.yedam.project.login;

public interface LogDAO {

	abstract LogVO login(LogVO logVO);
	abstract void check(LogVO logVO);
}
