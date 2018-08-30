package chap4_Servlet;


import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.*;

public class ServletByServlet implements Servlet {

	// Method 1 init
	// 该函数用于初始化该servlet,该函数只会被调用一次（当用户第一次访问该servlet时）
	public void init(ServletConfig parm1) throws ServletException {
		System.out.println("init");
	}

	// * Method 2 getServletConfig
	public ServletConfig getServletConfig() {
		return null;
	}

	/**
	 * Method 3 service
	 * 
	 * @param req
	 *            用于获得客户端的信息
	 * @param res
	 *            用于向客户端返回信息
	 * @throws ServletException
	 * @throws IOException
	 *             该函数用于处理业务逻辑，当用户每访问该servlet时，都会被调用
	 */
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service");
		PrintWriter pw = res.getWriter();
		pw.println("Hello Servlet!By implements Servlet.");
	}

	/**
	 * Method 4 getServletInfo
	 */
	public String getServletInfo() {
		return "";
	}

	/**
	 * Method 5 destroy
	 */

	public void destroy() {
		System.out.println("destroy");
	}
}
