package com.yedam.project.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.yedam.project.DB.ConnDB;

public class MemDAOfunc extends ConnDB implements MemDAO {
	private static MemDAO instance = null; // �ν��Ͻ� ����

	public static MemDAO getInstance() {
		if (instance == null) // �ν��Ͻ��� ���������� ������
			instance = new MemDAOfunc(); // ���θ��� �ν��Ͻ��� �Ѱ��ְ�
		return instance; // ��� �ƴϸ� ������ �����ִ°� �Ѱ��ְڴ�.
	}

	@Override
	public List<MemVO> selectAll() {
		List<MemVO> list = new ArrayList<>();
		try {
			connect(); // DB ����
			stmt = conn.createStatement(); // �����ͺ��̽��� SQL ���� ������ ���� SQLServerStatement ��ü�� ����ϴ�.
			String sql = "SELECT * FROM Management";
			rs = stmt.executeQuery(sql);

			int index = 0;
			while (rs.next()) {
				MemVO memVO = new MemVO();
				memVO.setMem_num(rs.getInt(("mem_num")));
				memVO.setName(rs.getString("name"));
				memVO.setPhoneNum(rs.getString("phoneNum"));
				memVO.setEmail(rs.getString("email"));
				memVO.setAddress(rs.getString("address"));

				list.add(memVO);
				index++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public MemVO select(MemVO memVO) {
		MemVO findVO = null;
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("검색하고자 하는 회원 번호를 입력하세요");
			int mem_num =input.nextInt();
			connect();
			stmt = conn.createStatement();
			/* 검색조건을 empNo를 쓸것이기 때문에 */

//			String sql = "SELECT * FROM employees WHERE emp_no = " + findVO.getMem_num();
			String sql = "SELECT mem_num,name,phone_number,email,address WHERE mem_num =" + mem_num;
			rs = stmt.executeQuery(sql);

			if (rs.next()/* 값이 존재하면 */) {
				findVO.setMem_num(rs.getInt(("mem_num")));
				findVO.setName(rs.getString("name"));
				findVO.setPhoneNum(rs.getString("phoneNum"));
				findVO.setEmail(rs.getString("email"));
				findVO.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return findVO;

	}

	@Override
	public void insert(MemVO memVO) {
		try {
			connect();
			String sql = "INSERT INTO employees VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memVO.getMem_num());
			pstmt.setString(2, memVO.getName());
			pstmt.setString(3, memVO.getPhoneNum());
			pstmt.setString(4, memVO.getEmail());
			pstmt.setString(5, memVO.getAddress());
			// 여기까지는 SQL 문장을 보낼수있게 된것

			// 실행함
			int result = pstmt.executeUpdate();

			if (result > 0/* 몇갠진 몰라도 일단 등록되었다는것 */) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(MemVO memVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int mem_num) {
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "DELETE FROM Management WHERE mem_num = " + mem_num;
//			DELETE FROM Management WHERE mem_num = mem_num - ���� ����
			int result = stmt.executeUpdate(sql); // ������ ������ result ���� ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
