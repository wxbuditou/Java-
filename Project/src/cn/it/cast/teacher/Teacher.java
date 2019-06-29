package cn.it.cast.teacher;

public class Teacher {
	private String teacher_number;
	private String teacher_username;
	private String teacher_password;
	private String teacher_onlinetime;
	private String teacher_registertime;
	public String getTeacher_number() {
		return teacher_number;
	}
	public void setTeacher_number(String teacher_number) {
		this.teacher_number = teacher_number;
	}
	public String getTeacher_username() {
		return teacher_username;
	}
	public void setTeacher_username(String teacher_username) {
		this.teacher_username = teacher_username;
	}
	public String getTeacher_password() {
		return teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	public String getTeacher_onlinetime() {
		teacher_onlinetime = teacher_onlinetime.replace(".0", "");
		return teacher_onlinetime;
	}
	public void setTeacher_onlinetime(String teacher_onlinetime) {
		this.teacher_onlinetime = teacher_onlinetime;
	}
	public String getTeacher_registertime() {
		teacher_registertime = teacher_registertime.replace(".0", "");
		return teacher_registertime;
	}
	public void setTeacher_registertime(String teacher_registertime) {
		this.teacher_registertime = teacher_registertime;
	}
	@Override
	public String toString() {
		return "Teacher [teacher_number=" + teacher_number + ", teacher_username=" + teacher_username
				+ ", teacher_password=" + teacher_password + ", teacher_onlinetime=" + teacher_onlinetime
				+ ", teacher_registertime=" + teacher_registertime + "]";
	}
	
	
}
