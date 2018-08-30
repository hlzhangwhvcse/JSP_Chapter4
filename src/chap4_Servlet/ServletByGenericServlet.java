package chap4_Servlet;


import javax.servlet.GenericServlet;
import java.io.*;
import javax.servlet.*;

public class ServletByGenericServlet extends GenericServlet {

	// 重写service()方法
	public void service(ServletRequest req, ServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			pw.println("Hello Servlet!By extends GenericServlet");
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
