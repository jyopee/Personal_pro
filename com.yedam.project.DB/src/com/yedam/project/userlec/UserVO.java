package com.yedam.project.userlec;

public class UserVO {

	private int LectNum;
	private String LectName;
	private String Professor;

//	============= 수강 신청 ================

	private int Lectnum;
	private String Lectname;
	private String Stuname;
	private int Stunum;

	
	public int getLectNum() {
		return LectNum;
	}


	public void setLectNum(int lectNum) {
		LectNum = lectNum;
	}


	public String getLectName() {
		return LectName;
	}


	public void setLectName(String lectName) {
		LectName = lectName;
	}


	public String getProfessor() {
		return Professor;
	}


	public void setProfessor(String professor) {
		Professor = professor;
	}


	public int getLectnum() {
		return Lectnum;
	}


	public void setLectnum(int lectnum) {
		Lectnum = lectnum;
	}


	public String getLectname() {
		return Lectname;
	}


	public void setLectname(String lectname) {
		Lectname = lectname;
	}


	public String getStuname() {
		return Stuname;
	}


	public void setStuname(String stuname) {
		Stuname = stuname;
	}


	public int getStunum() {
		return Stunum;
	}


	public void setStunum(int stunum) {
		Stunum = stunum;
	}


	@Override
	public String toString() {
		return "UserVO [LecNum=" + LectNum + ", LecName=" + LectName + ", professor=" + Professor + ", Lecnum=" + Lectnum
				+ ", lecname=" + Lectname + ", Stuname=" + Stuname + ", Stunum=" + Stunum + "]";
	}

}
