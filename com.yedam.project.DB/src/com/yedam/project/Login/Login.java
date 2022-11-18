package com.yedam.project.Login;

import java.sql.SQLException;
import java.util.Scanner;

import com.yedam.project.DB.ConnDB;
import com.yedam.project.Main.MemVO;

public class Login extends ConnDB {
	private static Login log = null;
	Scanner input = new Scanner(System.in);

	public static Login getInstance() {
		if (log == null) {
			log = new Login();
		}
		return log;
	}

	
		public log Login(MemVO member) {

		Member loginInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM members WHERE Mem_num = '" + member.getMem_num() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 아이디 존재
				if (rs.getString("passwd").equals(member.getMemberPassword())) {
					loginInfo = new Member();
					loginInfo.setMemberId(rs.getString("Mem_num"));
					loginInfo.setMemberPassword(rs.getString("passwd"));
					loginInfo.setMemberRole(rs.getInt("Role"));

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
		return member;
	}

}
