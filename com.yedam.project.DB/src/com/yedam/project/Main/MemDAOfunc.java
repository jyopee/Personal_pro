package com.yedam.project.Main;

import java.util.ArrayList;
import java.util.List;

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
			connect();						//DB ����
			stmt = conn.createStatement();      //�����ͺ��̽��� SQL ���� ������ ���� SQLServerStatement ��ü�� ����ϴ�.
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
//			DELETE FROM Management WHERE mem_num = mem_num - ���� ����
			int result = stmt.executeUpdate(sql); // ������ ������ result ���� ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
