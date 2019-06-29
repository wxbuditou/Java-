package cn.it.cast.function;

public class Message {
	
	private String message_id;
	private String message_topic;
	private String message_content;
	private String message_uploadtime;
	private String message_uploaduser;
	private String message_uploadnumber;
	private int message_character;
	private int message_clicknum;
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getMessage_topic() {
		return message_topic;
	}
	public void setMessage_topic(String message_topic) {
		this.message_topic = message_topic;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getMessage_uploadtime() {
		message_uploadtime=message_uploadtime.replace(".0", "");
		return message_uploadtime;
	}
	public void setMessage_uploadtime(String message_uploadtime) {
		this.message_uploadtime = message_uploadtime;
	}
	public String getMessage_uploaduser() {
		return message_uploaduser;
	}
	public void setMessage_uploaduser(String message_uploaduser) {
		this.message_uploaduser = message_uploaduser;
	}
	
	public int getMessage_character() {
		return message_character;
	}
	public void setMessage_character(int message_character) {
		this.message_character = message_character;
	}
	public int getMessage_clicknum() {
		return message_clicknum;
	}
	public void setMessage_clicknum(int message_clicknum) {
		this.message_clicknum = message_clicknum;
	}
	public String getMessage_uploadnumber() {
		return message_uploadnumber;
	}
	public void setMessage_uploadnumber(String message_uploadnumber) {
		this.message_uploadnumber = message_uploadnumber;
	}
	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", message_topic=" + message_topic + ", message_content="
				+ message_content + ", message_uploadtime=" + message_uploadtime + ", message_uploaduser="
				+ message_uploaduser + ", message_uploadnumber=" + message_uploadnumber + ", message_character="
				+ message_character + ", message_clicknum=" + message_clicknum + "]";
	}
	
}
