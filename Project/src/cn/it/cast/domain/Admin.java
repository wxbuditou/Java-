package cn.it.cast.domain;

public class Admin {
	private String ad_number;
	private String ad_username;
	private String ad_password;
	private String ad_onlinetime;
	private String ad_registertime;
	public String getAd_number() {
		return ad_number;
	}
	public void setAd_number(String ad_number) {
		this.ad_number = ad_number;
	}
	public String getAd_username() {
		return ad_username;
	}
	public void setAd_username(String ad_username) {
		this.ad_username = ad_username;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public String getAd_onlinetime() {
		ad_onlinetime = ad_onlinetime.replace(".0", "");
		return ad_onlinetime;
	}
	public void setAd_onlinetime(String ad_onlinetime) {
		this.ad_onlinetime = ad_onlinetime;
	}
	public String getAd_registertime() {
		ad_registertime = ad_registertime.replace(".0", "");
		return ad_registertime;
	}
	public void setAd_registertime(String ad_registertime) {
		this.ad_registertime = ad_registertime;
	}
	@Override
	public String toString() {
		return "Admin [ad_number=" + ad_number + ", ad_username=" + ad_username + ", ad_password=" + ad_password
				+ ", ad_onlinetime=" + ad_onlinetime + ", ad_registertime=" + ad_registertime + "]";
	}
	
	
}
