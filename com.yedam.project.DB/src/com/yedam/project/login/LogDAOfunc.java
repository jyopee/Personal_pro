package com.yedam.project.login;

import java.sql.SQLException;

import com.yedam.project.DB.ConnDB;
import com.yedam.project.Main.MemManagement;

public class LogDAOfunc extends ConnDB implements LogDAO {
	private static LogDAO instance = null; // 인스턴스 생성

	public static LogDAO getInstance() {
		if (instance == null) // 占싸쏙옙占싹쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			instance = new LogDAOfunc(); // 占쏙옙占싸몌옙占쏙옙 占싸쏙옙占싹쏙옙占쏙옙 占싼곤옙占쌍곤옙
		return instance; // 占쏙옙占� 占싣니몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍는곤옙 占싼곤옙占쌍겠댐옙.
	}

	@Override
	public LogVO login(LogVO logVO) {

		LogVO loginInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM Member WHERE MemberId = '" + logVO.getMemberId() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 아이디 존재
				if (rs.getString("passwd").equals(logVO.getPasswd())) {
					loginInfo = new LogVO();
					loginInfo.setMemberId(rs.getString("MemberId"));
					loginInfo.setPasswd(rs.getString("passwd"));
					System.out.println("로그인 되었습니다.");

				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return loginInfo;

	}

}
