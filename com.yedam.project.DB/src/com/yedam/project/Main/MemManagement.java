package com.yedam.project.Main;

import java.util.List;
import java.util.Scanner;

public class MemManagement {
	Scanner input = new Scanner(System.in);

	MemDAO memDAO = MemDAOfunc.getInstance(); // 인스턴스 생성
	boolean loop = true;

	public MemManagement() {

		MenuPrint();
	}

	public void MenuPrint() {

		while (true) {

			System.out.println("======================================");
			System.out.println("|1. 회원등록 | 2.회원전체 조회 | 3.회원정보 조회");
			System.out.println("|4. 회원정보 추가 | 5.회원정보 업데이트 | 6.회원정보 삭제 | 7.종료");
			System.out.println("======================================");

			MenuSelect();
		}

	}

	private MemVO Input() {
		MemVO memVO = new MemVO();
		System.out.println("회원 번호");
		memVO.setMem_num(Integer.parseInt(input.nextLine()));
		System.out.println("회원 이름");
		memVO.setName(input.nextLine());

		return memVO;
	}

	private MemVO InsertInput() {

		System.out.println();

		MemVO memVO = new MemVO();
		System.out.print("회원 번호 :");
		memVO.setMem_num(Integer.parseInt(input.nextLine()));
		System.out.print("회원 이름 :");
		memVO.setName(input.nextLine());
		System.out.print("회원 전화번호 :");
		memVO.setPhoneNum(input.nextLine());
		System.out.print("회원 이메일 :");
		memVO.setEmail(input.nextLine());
		System.out.print("회원 주소 :");
		memVO.setAddress(input.nextLine());

		return memVO;
	}

	public void MenuSelect() {

		System.out.println("메뉴를 선택하세요");
		int menuNo = Integer.parseInt(input.nextLine());

		if (menuNo == 1) { // 1.회원 등록
			InsertMem();
		} else if (menuNo == 2) {// 3.회원 전체 조회
			selectAll();
		} else if (menuNo == 3) {// 4.회원조회
			select();
		} else if (menuNo == 4) {// 5.회원 정보 추가
			InsertMem();
		} else if (menuNo == 5) {// 6.회원 정보 업데이트
			updateMem();
		} else if (menuNo == 6) {// 7.회원 정보 삭제
			delete();
		} else if (menuNo == 7) {
			end();
		}
	}

	public void selectAll() {
		List<MemVO> list = memDAO.selectAll();

		if (list.isEmpty()) {
			System.out.println("정보가 없습니다.");
			return;
		}

		for (MemVO memVO : list) {
			System.out.printf("%d : %s %s \n ", memVO.getMem_num(), memVO.getName(), memVO.getPhoneNum(),
					memVO.getEmail(), memVO.getAddress());
		}
	}

	public void select() {
		System.out.println("찾고자 하는 회원의 정보를 입력하세요 ");

		MemVO findmem = Input();
		MemVO findVO = memDAO.select(findmem);

		if (findVO == null) {
			System.out.println("결과가 존재하지 않습니다.");
		} else {
			System.out.println(findVO);
		}

	}

	private void InsertMem() {

		System.out.println("추가 하고자 하는 회원 정보를 입력하세요");
		MemVO memVO = InsertInput();
		memDAO.insert(memVO);

	}

	private void updateMem() {
		System.out.println("변경하고자 하는 회원 번호를 입력하세요");
		int num = input.nextInt();
		System.out.println("변경하고자 하는 이름을 입력하세요");
		String name = input.next();
		System.out.println("변경하고자 하는 이메일를 입력하세요");
		String email = input.next();
		System.out.println("변경하고자 하는 주소를 입력하세요");
		String add = input.next();

		memDAO.update(name, email, add, num);

	}

	private void delete() {
		System.out.println("삭제하고자 하는 회원번호를 입력하세요");
		int memNo = inputMemNo();
		memDAO.delete(memNo);
	}

	private int inputMemNo() {
		int memNo = 0;
		try {
			memNo = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("사원번호는 숫자로 구성되어 잇습니다.");
		}
		return memNo;
	}

	private void end() {
		System.out.println("===================");
		System.out.println("프로그램을 종료합니다..");
		System.out.println("===================");
		loop = false;
	}

//		String sql ="UPDATE Member SET  WHERE mem_num ="+ Update.getMem_num() + "and" +Update.getName();
}
