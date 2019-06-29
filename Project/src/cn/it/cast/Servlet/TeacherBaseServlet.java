package cn.it.cast.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherBaseServlet")
public class TeacherBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeacherBaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String method = request.getParameter("method");//获取链接中method值
		System.out.println("method : "+ method);
		String path= null;	
		if (method!=null) {
			Class clazz = this.getClass();
			try {
				Method md = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				if (method!=null) {
					path = (String)md.invoke(this,request,response);
				}
				if (path!=null) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
}
