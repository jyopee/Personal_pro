package com.yedam.project.Main;

public class MemVO {

	// 캡슐화 필드
	private int mem_num;        // 회원번호
	private String name; 		// 회원 이름		
	private String phoneNum;    // 회원 전화번호
	private String email;		// 회원 이메일
	private String address;		// 회원 주소
	
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
