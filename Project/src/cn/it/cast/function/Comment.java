package cn.it.cast.function;

public class Comment {
	private String comment_id;
	private String comment_username;
	private String comment_usernumber;
	private String comment_content;
	private String comment_time;
	private String comment_messageid;
	private int comment_character;
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_username() {
		return comment_username;
	}
	public void setComment_username(String comment_username) {
		this.comment_username = comment_username;
	}
	public String getComment_usernumber() {
		return comment_usernumber;
	}
	public void setComment_usernumber(String comment_usernumber) {
		this.comment_usernumber = comment_usernumber;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		comment_time = comment_time.replace(".0", "");
		this.comment_time = comment_time;
	}
	public String getComment_messageid() {
		return comment_messageid;
	}
	public void setComment_messageid(String comment_messageid) {
		this.comment_messageid = comment_messageid;
	}
	public int getComment_character() {
		return comment_character;
	}
	public void setComment_character(int comment_character) {
		this.comment_character = comment_character;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", comment_username=" + comment_username + ", comment_usernumber="
				+ comment_usernumber + ", comment_content=" + comment_content + ", comment_time=" + comment_time
				+ ", comment_messageid=" + comment_messageid + ", comment_character=" + comment_character + "]";
	}
	
}
