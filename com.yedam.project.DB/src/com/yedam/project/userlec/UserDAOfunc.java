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
				userVO.setLectNum(rs.getInt(("LecNum")));
				userVO.setLectName(rs.getString("LecName"));
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
				findVO.setStunum(rs.getInt("Stunum"));
				findVO.setStuname(rs.getString("Stuname"));

			}
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return findVO;

	}
	
	public UserVO selectLect () {
		
	}

	@Override
	public void insert(UserVO userVO) {
		try {
			connect();
			String sql = "INSERT INTO ClassRegist VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, userVO.getLectname());
			pstmt.setInt(3, userVO.getStunum());
			pstmt.setString(4, userVO.getStuname());

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
	public void update(String lectname, String Stuname, String Stunum, int lectnum) {
		int result;
		try {

			connect();

			String sql1 = "UPDATE ClassRegist SET LectName= ? ,Stunum = ? ,Stuname = ? WHERE lectnum =?";

			pstmt = conn.prepareStatement(sql1);

			pstmt.setString(1, lectname);
			pstmt.setString(2, Stuname);
			pstmt.setString(3, Stunum);
			pstmt.setInt(4, lectnum);

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
		// TODO Auto-generated method stub

	}

}
