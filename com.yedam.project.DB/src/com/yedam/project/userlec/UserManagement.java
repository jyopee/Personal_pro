package com.yedam.project.userlec;

import java.util.List;
import java.util.Scanner;

import com.yedam.project.Main.MemVO;

public class UserManagement {
	protected int num;
	protected String name;

	Scanner input = new Scanner(System.in);
	boolean loop = true;

	UserDAO userDAO = UserDAOfunc.getInstance();// 인스턴스 생성


	public UserManagement() {
		MenuPrint();

	}

	public UserManagement(int num, String name) {
		this.num = num;
		this.name = name;
		new UserManagement();
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
			System.out.println(num);
			System.out.println(name);
			System.out.println("메뉴를 선택하세요");
			int menuNo = Integer.parseInt(input.nextLine());

			if (menuNo == 1) { // 1.강의 조회
				selectAll();
			} else if (menuNo == 2) {// 2.강의 신청
				Registselect2();
			} else if (menuNo == 3) {// 4.신청강의 조회
				select();
			} else if (menuNo == 4) {// 6.수강 정정
				delete();
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

	public UserVO Registselect2() {
		System.out.println("과목 코드:");

		int Stunum = Integer.parseInt(input.nextLine());
		UserVO findVO = userDAO.select2(Stunum);

		if (findVO == null) {
			System.out.println("결과가 존재하지 않습니다.");
		}
		UserVO lect = new UserVO();
		lect = findVO;
		Regist(lect, Stunum);
		return findVO;
		

	}

	private void Regist(UserVO lect, int Stunum) {
		System.out.println(lect);
		System.out.println(Stunum);
		userDAO.update(lect, Stunum);
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
	}

}
