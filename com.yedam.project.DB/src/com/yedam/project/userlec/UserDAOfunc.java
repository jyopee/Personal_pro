package com.yedam.project.userlec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.project.DB.ConnDB;
import com.yedam.project.Main.MemVO;

public class UserDAOfunc extends ConnDB implements UserDAO {

	Scanner input = new Scanner(System.in);
	private static UserDAO instance = null; // 인스턴스 생성

	public static UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAOfunc();
		return instance;
	}

	@Override
	public List<UserVO> selectAll() {
		List<UserVO> list = new ArrayList<>();
		try {
			connect(); // DB 占쏙옙占쏙옙
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Lectname";
			rs = stmt.executeQuery(sql);

			int index = 0;
			while (rs.next()) {

				UserVO userVO = new UserVO();
				userVO.setLectnum(rs.getInt(("LectNum")));
				userVO.setLectName(rs.getString("LectName"));
				userVO.setProfessor(rs.getString("Professor"));

				list.add(userVO);
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
	public UserVO select(UserVO userVO) {
		UserVO findVO = null;

		try {
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT * from ClassRegist WHERE Stunum =" + userVO.getStunum() + " AND Stuname ='"
					+ userVO.getStuname() + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()/* 값이 존재할 경우 */) {
				findVO = new UserVO();

				findVO.setLectnum(rs.getInt(("Lectnum")));
				findVO.setLectname(rs.getString("Lectname"));
				findVO.setProff(rs.getString("Proff"));
				findVO.setStunum(rs.getInt("Stunum"));
				findVO.setStuname(rs.getString("Stuname"));

			}
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return findVO;

	}

	@Override
	public void delete(int lectnum) {

		try {
			connect();
			stmt = conn.createStatement();
			String sql = "DELETE FROM ClassRegist WHERE lectnum = " + lectnum;
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

	@Override
	public UserVO select2(int LectNum) {
		UserVO selectVO = null;

		try {
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT LectNum,LectName,Professor from Lectname WHERE LectNum  =" + LectNum;

			rs = stmt.executeQuery(sql);

			if (rs.next()/* 값이 존재할 경우 */) {
				selectVO = new UserVO();
				selectVO.setLectnum(rs.getInt("LectNum"));
				selectVO.setLectName(rs.getString("LectName"));
				selectVO.setProfessor(rs.getString("Professor"));

			}
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return selectVO;

	}

	@Override
	public void insert(UserVO userVO, MemVO memVO) {
		try {
			connect();
			String sql = "INSERT INTO ClassRegist(Lectnum,Lectname,Proff,Stunum,Stuname) VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

	
			pstmt.setInt(1, userVO.getLectNum());
			pstmt.setString(2, userVO.getLectName());
			pstmt.setString(3, userVO.getProfessor());
			pstmt.setInt(4, memVO.getMem_num());
			pstmt.setString(5, memVO.getName());

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
	public MemVO select3(int Mem_num) {
		MemVO memVO = null;

		try {
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT Mem_num,Name from Member WHERE Mem_num  =" + Mem_num;

			rs = stmt.executeQuery(sql);

			if (rs.next()/* 값이 존재할 경우 */) {
				memVO = new MemVO();
				memVO.setMem_num(rs.getInt("Mem_num"));
				memVO.setName(rs.getString("Name"));

			}
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return memVO;
	}

}
