package cn.it.cast.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.it.cast.Service.UserService;
import cn.it.cast.domain.Admin;
import cn.it.cast.student.Student;
import cn.it.cast.teacher.Teacher;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Boolean existUser = true;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String position = request.getParameter("position");
		String code = request.getParameter("code");
		String randcode = (String) request.getSession().getAttribute("check_code");
		System.out.println("username: "+username+" password: "+password+" position: "+position+" code :"+code);

		if (code.equals(randcode)) {
			UserService userService = new UserService();
			Object object=null;
			try {
				object = userService.validate(username,password,position);
				//System.out.println(object.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (object==null) {
				request.getSession().setAttribute("msg", "用户不存在！");
				response.sendRedirect("/Project/index.jsp");
			}else {
				if (position.equals("student")) {	//学生登陆
					try {
						Student student=userService.validateStudent(username,password);
						if (student!=null) {
						System.out.println(student.toString());
						request.getSession().setAttribute("student", student);
						response.sendRedirect("Student/student_home.jsp");//转发到学生主页
						//账号与密码不匹配
						}else {
							existUser = false;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if (position.equals("teacher")) {	//教师登陆
					try {
						Teacher	teacher = userService.validateTeacher(username,password);
						if (teacher!=null) {
						request.getSession().setAttribute("teacher", teacher);
						response.sendRedirect("Teacher/teacher_home.jsp");//转发到教师主页
						}else {
							existUser = false;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if (position.equals("adminstrator")) {	//管理员登陆
					try {
						Admin admin = userService.validateAdmin(username, password);
						if (admin!=null) {
						request.getSession().setAttribute("admin", admin);
						response.sendRedirect("Admin/admin_home.jsp");//转发到管理员界面
						}else {
							existUser = false;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (existUser==false) {
					request.getSession().setAttribute("msg", "帐号与密码不匹配！");
					response.sendRedirect("/Project/index.jsp");

				}
				
			}
		}else {
			request.getSession().setAttribute("msg", "验证码错误！");
			response.sendRedirect("/Project/index.jsp");
		}
		
	}
	
	
	

}
