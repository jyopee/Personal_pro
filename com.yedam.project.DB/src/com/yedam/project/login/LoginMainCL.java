package com.yedam.project.login;

import java.util.Scanner;

import com.yedam.project.Main.MemManagement;
import com.yedam.project.Main.MemVO;
import com.yedam.project.userlec.UserManagement;

public class LoginMainCL {

	boolean loop = false;
	private int role;
	protected static int num;
	protected static String name;
	Scanner input = new Scanner(System.in);
	LogDAO logDAO = LogDAOfunc.getInstance();

	public LoginMainCL() {
		MenuSelect();

	}

	public void MenuPrint() {

		System.out.println("==================================관 리 자==================================");
		System.out.println("                              시작(Y) / 종료(N)                                 ");
		System.out.println("==========================================================================");

		

	}

	public void MenuSelect() {

		while (true) {
			
			MenuPrint();

			System.out.println("				  Y / N");
			String menuNo = input.nextLine();

			if (menuNo.equals("Y")) { // 1.회원 등록
				login();
			} else if (menuNo.equals("N")) {// 3.회원 전체 조회
				System.out.println("수고하겼습니다.");
				break;
			}
			
				
		}

	}

	public LogVO login() {
		LogVO input = LoginInput();
		LogVO info = logDAO.login(input);

		if (info == null) {
			login();
		} else if (info.getMemberId().equals("admin")) {

			new MemManagement();

		} else {

			new UserManagement();

		}

		return info;

	}

	public LogVO LoginInput() {
		LogVO LogInput = new LogVO();
		System.out.print("회원 아이디 :");
		LogInput.setMemberId(input.nextLine());
		System.out.print("비밀번호 :");
		LogInput.setPasswd(input.nextLine());


		return LogInput;
	}

}
