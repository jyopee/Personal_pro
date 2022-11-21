package com.yedam.project.userlec;

import java.util.List;
import java.util.Scanner;

public class UserManagement {
	Scanner input = new Scanner(System.in);
	boolean loop = true;

	UserDAO userDAO = UserDAOfunc.getInstance();// 인스턴스 생성

	public UserManagement() {
		MenuPrint();
	}

	public void MenuPrint() {

		while (true) {

			System.out.println("==================================일반 유저==================================");
			System.out.println("|1.강의 조회|2.강의 신청| 3.신청 강의 조회|4.수강 정정 |5.종료");
			System.out.println("==========================================================================");

			MenuSelect();
		}

	}

	public void MenuSelect() {

		while (true) {

			System.out.println("메뉴를 선택하세요");
			int menuNo = Integer.parseInt(input.nextLine());

			if (menuNo == 1) { // 1.강의 조회
				selectAll();
			} else if (menuNo == 2) {// 2.강의 신청
				Registlect();
			} else if (menuNo == 3) {// 4.신청강의 조회
				select();
			} else if (menuNo == 4) {// 6.수강 정정

			} else if (menuNo == 5) {// 종료
				End();
			}
//			new LoginMainCL();
		}
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

	private UserVO Input() {

		UserVO put = new UserVO();

		System.out.print("학생 번호 :");
		put.setStunum(Integer.parseInt(input.nextLine()));
		System.out.print("학생 이름 :");
		put.setStuname(input.nextLine());

		return put;
	}

	private void Registlect() {

		System.out.println("신청 하고자 하는 강의 정보를 입력하세요");

		UserVO userVO = InsertInput();

		userDAO.insert(userVO);

	}

	private UserVO InsertInput() {
		System.out.println();

		UserVO userVO = new UserVO();

		System.out.print("강의 번호 :");
		userVO.setLectnum(Integer.parseInt(input.nextLine()));

		return userVO;

	}

	private UserVO searchLect() {
		UserVO search = new UserVO();
		search.setLectNum(Integer.parseInt(input.nextLine()));
		UserVO findVO = userDAO.select(search);

		return findVO;
	}

	private void End() {
		loop = false;
	}

}
