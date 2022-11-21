package com.yedam.project.login;

public class LogVO {
	private String MemberId = "admin"; // 회원 번호(아이디)
	private String passwd; // 회원 이름


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

	@Override
	public String toString() {
		return "LogVO [MemberId=" + MemberId + ", passwd=" + passwd + "]";
	}

	
	
	
	
	

}
