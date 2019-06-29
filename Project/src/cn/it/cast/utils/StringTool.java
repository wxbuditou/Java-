package cn.it.cast.utils;
//校验字符串工具类
public class StringTool {
	//判断输入的字符串参数是否为空
	public static boolean validateNull(String args) {
		if (args ==null|| args.length()==0) {
			return true;
		}else {
			return false;
		}
	}
	
	//判断输入的字符串参数是否为空后者是null字符，如果是，返回target，否则返回source
	public static String changeNull(String source,String target) {
		if (source==null||source.length()==0||source.equalsIgnoreCase("null")) {
			return target;
		}else {
			return source;
		}
	}
	
	public static String filterHtml(String input) {
		if (input==null) {
			return null;
		}
		
		if (input.length()==0) {
			return input;
		}
		
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&#30;");
		input = input.replaceAll("\"", "&quot;");
		return  input.replaceAll("\n", "<br>;");
		
	}
	
	
}
