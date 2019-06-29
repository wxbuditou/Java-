package cn.it.cast.Servlet;

import java.util.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyleContext;

import cn.it.cast.Service.StudentService;
import cn.it.cast.Service.TeacherService;
import cn.it.cast.function.Comment;
import cn.it.cast.function.Document;
import cn.it.cast.function.Message;
import cn.it.cast.function.News;
import cn.it.cast.function.Video;
import cn.it.cast.student.Student;
import cn.it.cast.teacher.Teacher;
import cn.it.cast.utils.PageModel;


public class StudentServlet extends StudentBaseServlet {
	public String scan_news(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//获取news对象存在pagemodel的list中，然后再传到前台
		System.out.println("scan_news...");
		int num =  Integer.parseInt(request.getParameter("num"));
		StudentService studentService = new StudentService();
		PageModel pModel = studentService.findNewsWithPage(num);
		request.setAttribute("page", pModel);
		return "/Student/student_news.jsp";
	}
	
	public String scan_video(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//获取video对象存在pagemodel的list中
		System.out.println("scan_video...");
		int num =  Integer.parseInt(request.getParameter("num"));
		StudentService studentService = new StudentService();
		PageModel pModel = studentService.findVideoWithPage(num);
		request.setAttribute("page", pModel);
		//将pagemodel对象传到前台
		return "/Student/student_video.jsp";
	}
	
	public String scan_document(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//获取document对象存在pagemodel的list中
		System.out.println("scan_document...");
		int num =  Integer.parseInt(request.getParameter("num"));
		StudentService studentService = new StudentService();
		PageModel pModel = studentService.findDocumentWithPage(num);
		request.setAttribute("page", pModel);
		return "/Student/student_document.jsp";
	}
	
	public String scan_message(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//获取document对象存在pagemodel的list中
		System.out.println("scan_message...");
		int num =  Integer.parseInt(request.getParameter("num"));
		StudentService studentService = new StudentService();
		PageModel pModel = studentService.findMessageWithPage(num);
		request.setAttribute("page", pModel);
		return "/Student/student_message.jsp";
	}
	/*
	public String scan_video(HttpServletRequest request,HttpServletResponse response) {
		return "video";
	}
*/
	public String show_news(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String news_id = request.getParameter("news_id");
		StudentService studentService = new StudentService();
		News news = studentService.show_news(news_id);//返回新闻对象
		request.setAttribute("news", news);
		return "/Student/student_show_news.jsp";
	}
	
	public String download_document(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		String document_id = request.getParameter("document_id");
		String realPath = "D:\\eclipse\\workspace\\kechengsheji\\Project\\WebContent\\upload\\document";
		System.out.println("document_id is "+document_id);
		StudentService studentService = new StudentService();
		Document document = studentService.download_document(document_id);//返回文档对象
		System.out.println(document.toString());
		realPath = realPath  + "/"+document.getDocument_attachment();
		System.out.println("document realpath is "+realPath);
		response.setHeader("Content-disposition","attachment;filename="+document.getDocument_attachment());
		//****************
		InputStream  inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(realPath);
			int len=0;
			byte buf[] = new byte[1024];
			outputStream = response.getOutputStream();
			while ((len=inputStream.read(buf)) >0 ) {
				outputStream.write(buf,0,len);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (inputStream!=null) {
				inputStream.close();
			}
			if (outputStream!=null) {
				outputStream.close();
			}
			}
		//response.sendRedirect("TeacherServlet?method=scan_document&num=1");
		return "null";
}
	
	//播放视频
	public String show_video(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String video_id = request.getParameter("video_id");
		System.out.println("video_id is "+video_id);
		StudentService studentService = new StudentService();
		Video video = studentService.show_video(video_id);//返回视频对象
		System.out.println(video.toString());
		request.setAttribute("video", video);
		return "/Student/student_show_video.jsp";
	}
	

	public String student_logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("student");
		request.getSession().removeAttribute("msg");
		//request.setAttribute("", arg1);
		return "/Student/student_home.jsp";
	}
	
	public String student_publish_message(HttpServletRequest request,HttpServletResponse response) throws SQLException, UnsupportedEncodingException {
		String path="";
		String tc = request.getParameter("topic");
		String topic = new String(tc.getBytes("ISO8859-1"),"UTF-8");
		Student student = (Student)request.getSession().getAttribute("student");
		String uploaduser = student.getStudent_username();
		String uploadnumber = student.getStudent_number();	
		String ct = request.getParameter("editorValue");
		String content = new String(ct.getBytes("ISO8859-1"), "UTF-8");
		System.out.println("topic: "+ topic + " content: "+content +" uploadnumber: "+ uploadnumber);
		if (content!=null) {
			StudentService studentService = new StudentService();
			studentService.publish_message(topic,content,uploaduser,uploadnumber);
			path="StudentServlet?method=scan_message&num=1";
		}else {
			//
		}
		System.out.println("publish_message  path:"+path);
		return path;
	}
	
	public String show_message(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		//获取文章id
		//通过文章id获取内容，输出内容
		//根据id在comment表查找评论。按时间评论全部输出来，返回一个comment的list
		String message_id = request.getParameter("message_id");
		System.out.println("message_id is "+message_id);
		StudentService studentService = new StudentService();
		Message message = studentService.show_message(message_id);//返回文章对象
		List<Comment> comments = studentService.getCommentByid(message_id);
		System.out.println(message.toString());
		request.setAttribute("message", message);
		//comments = null;
		request.setAttribute("comments", comments);
		return "/Student/student_show_message.jsp";
	}
	
	public String publish_comment(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		int comment_character =2;
		Student student = (Student)request.getSession().getAttribute("student");
		String comment_username = student.getStudent_username();
		String comment_usernumber = student.getStudent_number();
		String comment_content = request.getParameter("comment_content");
		String comment_messageid = request.getParameter("message_id");
		System.out.println("comment_content is "+comment_content + " comment_messageid is "+ comment_messageid);
		if (comment_content!=null||comment_content!="") {
		StudentService studentService = new StudentService();
		studentService.publish_comment(comment_username,comment_usernumber,comment_content,comment_messageid,comment_character);
		}
		//return "StudentServlet?method=show_message&message_id="+comment_messageid;
		response.sendRedirect("StudentServlet?method=show_message&message_id="+comment_messageid);
		return null;
	}
	
}
