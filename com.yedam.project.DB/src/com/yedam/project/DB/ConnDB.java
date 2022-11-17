package com.yedam.project.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	// ������ ���� ����
	private String JdbcDriver = "org.sqlite.JDBC";
	private String JdbcUrl = "jdbc:sqlite:D:/PesonalProject/Database/Management.db";

	// �ʵ�
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	protected void connect() { // DB ����
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
			System.out.println("DB�� ���������� ��ü���� �ʾҽ��ϴ�.");
		}
	}

}
