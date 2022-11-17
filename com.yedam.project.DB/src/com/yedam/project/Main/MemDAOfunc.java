package com.yedam.project.Main;

import java.util.ArrayList;
import java.util.List;

import com.yedam.project.DB.ConnDB;

public class MemDAOfunc extends ConnDB implements MemDAO {
	private static MemDAO instance = null; // 인스턴스 생성

	public static MemDAO getInstance() {
		if (instance == null) // 인스턴스가 생성된적이 없으면
			instance = new MemDAOfunc(); // 새로만든 인스턴스를 넘겨주고
		return instance; // 빈게 아니면 기존에 갖고있는걸 넘겨주겠다.
	}

	@Override
	public List<MemVO> selectAll() {
		List<MemVO> list = new ArrayList<>();
		try {
			connect();						//DB 연결
			stmt = conn.createStatement();      //데이터베이스로 SQL 문을 보내기 위한 SQLServerStatement 개체를 만듭니다.
			String sql = "SELECT * FROM Management";
			rs = stmt.executeQuery(sql);
			while(true) {
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	@Override
	public MemVO select(MemVO memVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemVO memVO) {
		// TODO Auto-generated method stub

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
//			DELETE FROM Management WHERE mem_num = mem_num - 쿼리 생성
			int result = stmt.executeUpdate(sql); // 쿼리를 실행후 result 값에 저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
