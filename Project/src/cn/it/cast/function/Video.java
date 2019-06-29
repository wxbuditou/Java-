package cn.it.cast.function;

public class Video {
	private String video_id;
	private String video_name;
	private String video_oldattachment;
	private String video_attachment;
	private String video_uploadtime;
	private String video_uploaduser;
	private String video_uploadnumber;
	private String video_pro;
	private int video_character;
	private int video_playnum;
	private String video_savepath;
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_attachment() {
		return video_attachment;
	}
	public void setVideo_attachment(String video_attachment) {
		this.video_attachment = video_attachment;
	}
	public String getVideo_uploadtime() {
		video_uploadtime=video_uploadtime.replace(".0", "");
		return video_uploadtime;
	}
	public void setVideo_uploadtime(String video_uploadtime) {
		this.video_uploadtime = video_uploadtime;
	}
	
	public String getVideo_pro() {
		return video_pro;
	}
	public void setVideo_pro(String video_pro) {
		this.video_pro = video_pro;
	}
	public String getVideo_id() {
		return video_id;
	}
	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
	public String getVideo_uploaduser() {
		return video_uploaduser;
	}
	public void setVideo_uploaduser(String video_uploaduser) {
		this.video_uploaduser = video_uploaduser;
	}
	public int getVideo_character() {
		return video_character;
	}
	public void setVideo_character(int video_character) {
		this.video_character = video_character;
	}
	public int getVideo_playnum() {
		return video_playnum;
	}
	public void setVideo_playnum(int video_playnum) {
		this.video_playnum = video_playnum;
	}
	public String getVideo_oldattachment() {
		return video_oldattachment;
	}
	public void setVideo_oldattachment(String video_oldattachment) {
		this.video_oldattachment = video_oldattachment;
	}
	public String getVideo_savepath() {
		return video_savepath;
	}
	public void setVideo_savepath(String video_savepath) {
		this.video_savepath = video_savepath;
	}
	public String getVideo_uploadnumber() {
		return video_uploadnumber;
	}
	public void setVideo_uploadnumber(String video_uploadnumber) {
		this.video_uploadnumber = video_uploadnumber;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_name=" + video_name + ", video_oldattachment="
				+ video_oldattachment + ", video_attachment=" + video_attachment + ", video_uploadtime="
				+ video_uploadtime + ", video_uploaduser=" + video_uploaduser + ", video_uploadnumber="
				+ video_uploadnumber + ", video_pro=" + video_pro + ", video_character=" + video_character
				+ ", video_playnum=" + video_playnum + ", video_savepath=" + video_savepath + "]";
	}
	
	
}