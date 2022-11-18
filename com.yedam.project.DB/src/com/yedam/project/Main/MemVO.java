package com.yedam.project.Main;

public class MemVO {

	// ĸ��ȭ �ʵ�
	private int Mem_num; // 회원 번호(아이디)
	private String Name; // 회원 이름
	private String PhoneNum; // 회원 휴대전화
	private String Email; // 회원 이메일
	private String Address; // 회원 주소

	public int getMem_num() {
		return Mem_num;
	}

	public void setMem_num(int mem_num) {
		Mem_num = mem_num;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	@Override
	public String toString() {
		return "MemVO [Mem_num=" + Mem_num + ", Name=" + Name + ", PhoneNum=" + PhoneNum + ", Email=" + Email
				+ ", Address=" + Address  + "]";

	}

}
