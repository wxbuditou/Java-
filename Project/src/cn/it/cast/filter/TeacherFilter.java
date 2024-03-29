package cn.it.cast.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.it.cast.student.Student;
import cn.it.cast.teacher.Teacher;

/**
 * Servlet Filter implementation class TeacherFilter
 */
@WebFilter("/TeacherFilter")
public class TeacherFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TeacherFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if (req.getSession().getAttribute("teacher")!=null) {
			Teacher teacher = (Teacher) req.getSession().getAttribute("teacher");
			System.out.println("教师:"+teacher.getTeacher_username()+"登陆成功...");;
			chain.doFilter(request, response);
		}else if (req.getSession().getAttribute("student")!=null||req.getSession().getAttribute("admin")!=null) {
			req.getSession().setAttribute("msg", "请求页面发生错误，请重新登陆！");
			//req.getRequestDispatcher("/index.jsp").forward(req, res);
			res.sendRedirect("/Project/index.jsp");
		}else {
			req.getSession().setAttribute("msg", "请登录后再操作！");
			//req.getRequestDispatcher("/index.jsp").forward(req, res);
			res.sendRedirect("/Project/index.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
