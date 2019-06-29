package cn.it.cast.function;

public class News {
	private String news_id;
	private String news_topic;
	private String news_content;
	private String news_uploadtime;
	private String news_uploaduser;
	private String news_uploadnumber;
	private int news_clicknum;
	private int news_character;
	public String getNews_topic() {
		return news_topic;
	}
	public void setNews_topic(String news_topic) {
		this.news_topic = news_topic;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public String getNews_uploadtime() {
		news_uploadtime=news_uploadtime.replace(".0", "");
		return news_uploadtime;
	}
	public void setNews_uploadtime(String news_uploadtime) {
		this.news_uploadtime = news_uploadtime;
	}
	
	public int getNews_clicknum() {
		return news_clicknum;
	}
	public void setNews_clicknum(int news_clicknum) {
		this.news_clicknum = news_clicknum;
	}
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getNews_uploaduser() {
		return news_uploaduser;
	}
	public void setNews_uploaduser(String news_uploaduser) {
		this.news_uploaduser = news_uploaduser;
	}
	public int getNews_character() {
		return news_character;
	}
	public void setNews_character(int news_character) {
		this.news_character = news_character;
	}
	public String getNews_uploadnumber() {
		return news_uploadnumber;
	}
	public void setNews_uploadnumber(String news_uploadnumber) {
		this.news_uploadnumber = news_uploadnumber;
	}
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", news_topic=" + news_topic + ", news_content=" + news_content
				+ ", news_uploadtime=" + news_uploadtime + ", news_uploaduser=" + news_uploaduser
				+ ", news_uploadnumber=" + news_uploadnumber + ", news_clicknum=" + news_clicknum + ", news_character="
				+ news_character + "]";
	}
	
	
	
}
