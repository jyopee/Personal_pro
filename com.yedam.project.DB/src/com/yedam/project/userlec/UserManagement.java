package com.yedam.project.userlec;

import java.util.List;
import java.util.Scanner;

import com.yedam.project.Main.MemVO;
import com.yedam.project.login.LogVO;
import com.yedam.project.login.LoginMainCL;

public class UserManagement {
	protected int num;
	protected String name;

	Scanner input = new Scanner(System.in);
	boolean loop = true;

	UserDAO userDAO = UserDAOfunc.getInstance();// 인스턴스 생성

	public UserManagement() {
		MenuSelect();
	}

	public void MenuPrint() {

		

			System.out.println("==================================일반 유저=================================");
			System.out.println("	|1.강의 조회|2.강의 신청| 3.신청 강의 조회|4.수강 정정 |5.종료");
			System.out.println("==========================================================================");

			
		
	}

	public void MenuSelect() {

		while (loop == true) {
			
			MenuPrint();

			System.out.println("메뉴를 선택하세요");

			int menuNo = Integer.parseInt(input.nextLine());

			if (menuNo == 1) { // 1.강의 조회
				selectAll();
			} else if (menuNo == 2) {// 2.강의 신청
				Insert();
			} else if (menuNo == 3) {// 4.신청강의 조회
				select();
			} else if (menuNo == 4) {// 6.수강 정정
				delete();
			} else if (menuNo == 5) {// 종료
				End();
			}
		}
//			new LoginMainCL();

	}

	public void selectAll() {
		List<UserVO> list = userDAO.selectAll();

		if (list.isEmpty()) {
			System.out.println("정보가 없습니다.");
			return;
		}

		UserVO VO = new UserVO();
		System.out.println(VO.getLectNum());

		for (UserVO userVO : list) {
			System.out.printf("강의 번호 : %d   강의 이름 : %s   담당 교수 : %s   ", userVO.getLectnum(), userVO.getLectName(),
					userVO.getProfessor());
			System.out.println();

		}
	}

	public void select() {
		System.out.println("학생 번호와 학생 이름을 입력하세요 :");

		UserVO findmem = Input();
		UserVO findVO = userDAO.select(findmem);

		if (findVO == null) {
			System.out.println("결과가 존재하지 않습니다.");
		} else {
			System.out.printf("강의 번호 : %d   강의 이름 : %s   담당 교수 : %s  학생이름 : %s  학생번호 : %d   ", findVO.getLectnum(),
					findVO.getLectName(), findVO.getProfessor(), findVO.getStuname(), findVO.getStunum());

		}

	}

	public UserVO Registselect2() {
		System.out.println("수강하고자 하는과목 코드를 입력하세요:");

		int Stunum = Integer.parseInt(input.nextLine());
		UserVO findVO1 = userDAO.select2(Stunum);

		if (findVO1 == null) {
			System.out.println("결과가 존재하지 않습니다.");
		}
		System.out.println(findVO1);
		return findVO1;

	}

	public MemVO Registselect3() {
		System.out.println("당신의 학생 번호를 입력하세요:");

		int Stunum = Integer.parseInt(input.nextLine());
		MemVO findVO2 = userDAO.select3(Stunum);

		if (findVO2 == null) {
			System.out.println("결과가 존재하지 않습니다.");

		}
		System.out.println(findVO2);
		return findVO2;

	}

	private void Insert() {

		UserVO lect = Registselect2();
		MemVO mem = Registselect3();
		userDAO.insert(lect, mem);

	}

	private UserVO Input() {

		UserVO put = new UserVO();

		System.out.print("학생 번호 :");
		put.setStunum(Integer.parseInt(input.nextLine()));
		System.out.print("학생 이름 :");
		put.setStuname(input.nextLine());

		return put;
	}

	private void delete() {

		System.out.println("삭제하고자 하는 회원번호를 입력하세요");
		int memNo = Integer.parseInt(input.nextLine());
		userDAO.delete(memNo);
	}

	private void End() {
		loop = false;
		System.out.println("======================================");
		System.out.println("	   프로그램을 종료합니다..			");
		System.out.println("======================================");

		new LoginMainCL();

	}

}
