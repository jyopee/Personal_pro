package com.yedam.project.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.project.DB.ConnDB;
import com.yedam.project.Login.Member;

public class MemDAOfunc extends ConnDB implements MemDAO {
	Scanner input = new Scanner(System.in);
	private Object update;
	private static MemDAO instance = null; // 인스턴스 생성

	public static MemDAO getInstance() {
		if (instance == null) // 占싸쏙옙占싹쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			instance = new MemDAOfunc(); // 占쏙옙占싸몌옙占쏙옙 占싸쏙옙占싹쏙옙占쏙옙 占싼곤옙占쌍곤옙
		return instance; // 占쏙옙占� 占싣니몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍는곤옙 占싼곤옙占쌍겠댐옙.
	}

	@Override
	public List<MemVO> selectAll() {
		List<MemVO> list = new ArrayList<>();
		try {
			connect(); // DB 占쏙옙占쏙옙
			stmt = conn.createStatement(); // 占쏙옙占쏙옙占싶븝옙占싱쏙옙占쏙옙 SQL 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 SQLServerStatement 占쏙옙체占쏙옙
											// 占쏙옙占쏙옙求占�.
			String sql = "SELECT * FROM Member";
			rs = stmt.executeQuery(sql);

			int index = 0;
			while (rs.next()) {
				MemVO memVO = new MemVO();
				memVO.setMem_num(rs.getInt(("Mem_num")));
				memVO.setName(rs.getString("Name"));
				memVO.setPhoneNum(rs.getString("Phone_num"));
				memVO.setEmail(rs.getString("Email"));
				memVO.setAddress(rs.getString("Address"));

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
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT * from Member WHERE" + memVO.getMem_num() + "OR" + memVO.getName();
			rs = stmt.executeQuery(sql);

			if (rs.next()/* 값이 존재할 경우 */) {
				findVO = new MemVO();
				findVO.setMem_num(rs.getInt(("Mem_num")));
				findVO.setName(rs.getString("Name"));
				findVO.setPhoneNum(rs.getString("Phone_num"));
				findVO.setEmail(rs.getString("Email"));
				findVO.setAddress(rs.getString("Address"));
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
			String sql = "INSERT INTO Member VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memVO.getMem_num());
			pstmt.setString(2, memVO.getName());
			pstmt.setString(3, memVO.getPhoneNum());
			pstmt.setString(4, memVO.getEmail());
			pstmt.setString(5, memVO.getAddress());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("성공적으로 추가되었습니다.");
			} else {
				System.out.println("INSERT에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(String name, String email, String add, int num) {
		boolean check = true;

		int result;
		try {
			while (check = true) {

				connect();

				String sql1 = "UPDATE Member SET ? name,Phone_num,Email,Address WHERE emp_no =?";

				pstmt = conn.prepareStatement(sql1);

				System.out.println("수정 완료 :  Y / N");
				String yes = input.nextLine();
				if (yes == "Y") {
					pstmt.setString(1, name);
					pstmt.setString(3, email);
					pstmt.setString(4, add);
					pstmt.setInt(5, num);
					int update = pstmt.executeUpdate();

					check = false;

				} else
					continue;

			}

			result = pstmt.executeUpdate();

			if (result > 0) {
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
	public void delete(int mem_num) {
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "DELETE FROM Member WHERE mem_num = " + mem_num;
			int result = stmt.executeUpdate(sql); // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 result 占쏙옙占쏙옙 占쏙옙占쏙옙

			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
