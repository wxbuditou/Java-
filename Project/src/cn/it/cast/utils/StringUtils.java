package cn.it.cast.utils;

public class StringUtils {
	public static String filterHTML(String str) {
		StringBuffer strs = new StringBuffer();
		if (strs!=null&!strs.equals("")) {
			char[] chs = str.toCharArray();
			for (char c:chs) {
				switch(c) {
				case' ':strs.append("&nbsp;");break;
				case'>':strs.append("&gt;");break;
				case'<':strs.append("&lt;");break;
				case'\n':strs.append("&<br>");break;
				default:strs.append(c);
				}
			}
		}
		return strs.toString();	
	}
}
