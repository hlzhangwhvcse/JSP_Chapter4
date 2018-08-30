package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookie() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Servlet Cookies Setting</TITLE></HEAD>");
		out.println("  <BODY>");
		String str = "Hello, Cookie! 你好，曲奇饼干！";
		str = URLEncoder.encode(str, "UTF-8");
//		str = str.trim().replaceAll(" ","");
		
//		1、错误堆栈：
//		java.lang.IllegalArgumentException: An invalid character [32] was present in the Cookie value
//		2、根本原因：cookie中不接受非法字符，非法字符，如堆栈中所述，[32],可以查询32对应的ASCII码，如此处是：空格。
//		3、解决方案：找到了根本原因，就要解决它。那么我们就要将Cookie中的非法字符去掉。
//		解决方法一：
//		String str = " hello world ";
//		str.trim().replaceAll(" ","");
//		解决方法二：
//		str = URLEncoder.encode(str, "UTF-8");
		
		Cookie cookie = new Cookie("Name", str);
//		cookie.setMaxAge(60*60*24);  // 设置Cookie过期时间为一天
//		cookie.setMaxAge(0);  // 设置Cookieh立即过期
		cookie.setMaxAge(10);  // 设置Cookie过期日期为5s
		response.addCookie(cookie);
		out.println("  <BR>");
		out.println("  Add Cookie OK!");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
