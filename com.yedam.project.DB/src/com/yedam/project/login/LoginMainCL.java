package com.yedam.project.login;

import java.util.Scanner;

public class LoginMainCL {

	private LogVO role;
	Scanner input = new Scanner(System.in);
	LogDAO logDAO = LogDAOfunc.getInstance();

	public LoginMainCL() {

		login();
	}

	public LogVO login() {

		LogDAO logVO = new LogDAOfunc();
		LogVO logVO1 = LoginInput();
		LogVO logVO2 = logVO.login(logVO1);

		if (logVO2 == null) {
			login();
		} else {

			this.role = logVO2;
			System.out.println(role);
			check(logVO2);
		}

		return logVO2;

	}

	public LogVO LoginInput() {
		LogVO logVO = new LogVO();
		System.out.println("회원 아이디 :");
		logVO.setMemberId(input.nextLine());
		System.out.println("비밀번호 :");
		logVO.setPasswd(input.nextLine());

		return logVO;
	}

	public void check(LogVO logVO2) {
		LogDAO logVO = new LogDAOfunc();
		logVO.check(role);

	}
}
