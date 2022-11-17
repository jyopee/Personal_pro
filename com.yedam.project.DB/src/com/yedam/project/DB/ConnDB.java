package com.yedam.project.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	// 데이터 연결 정보
	private String JdbcDriver = "org.sqlite.JDBC";
	private String JdbcUrl = "jdbc:sqlite:D:/PesonalProject/Database/Management.db";

	// 필드
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	protected void connect() { // DB 연결
		try {
			Class.forName(JdbcDriver);
			conn = DriverManager.getConnection(JdbcUrl);
		} catch (ClassNotFoundException jdbcUrl) {
			System.out.println("JDBC DRIVER LOADING FAIL");
		} catch (SQLException e) {
			System.out.println("JDBC DRIVER CONNECTION FAIL");
		}
	}

	protected void disconnect() {
		try {
				if(rs!= null) rs.close();
				if(stmt!= null) rs.close();
				if(pstmt!= null) rs.close();
				if(conn!= null) rs.close();
		}catch (SQLException e) {
			System.out.println("DB가 정상적으로 해체되지 않았습니다.");
		}
	}

}
