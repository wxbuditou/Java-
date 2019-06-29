package cn.it.cast.student;

public class Student {
	
	private String student_number;
	private String student_username;
	private String student_password;
	private String student_onlinetime;
	private String student_registertime;
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getStudent_username() {
		return student_username;
	}
	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_onlinetime() {
		student_onlinetime = student_onlinetime.replace(".0", "");
		return student_onlinetime;
	}
	public void setStudent_onlinetime(String student_onlinetime) {
		this.student_onlinetime = student_onlinetime;
	}
	public String getStudent_registertime() {
		student_registertime = student_registertime.replace(".0", "");
		return student_registertime;
	}
	public void setStudent_registertime(String student_registertime) {
		this.student_registertime = student_registertime;
	}
	@Override
	public String toString() {
		return "Student [student_number=" + student_number + ", student_username=" + student_username
				+ ", student_password=" + student_password + ", student_onlinetime=" + student_onlinetime
				+ ", student_registertime=" + student_registertime + "]";
	}
	
	
}
