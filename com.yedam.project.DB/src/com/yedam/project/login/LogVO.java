package com.yedam.project.login;

public class LogVO {
	private String MemberId; // 회원 번호(아이디)
	private String passwd; // 회원 이름
	private int M_num = 0;

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String string) {
		MemberId = string;
	}

	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getMem_num() {
		return M_num;
	}

	public void setMem_num(int mem_num) {
		M_num = mem_num;
	}

	
	
	

}
