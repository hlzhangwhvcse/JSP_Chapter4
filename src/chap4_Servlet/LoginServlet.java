package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 
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
		
		//获取参数 
		request.setCharacterEncoding("utf-8");
		String cookietime = request.getParameter("cookietime");
		int cookietimes = Integer.parseInt(cookietime.trim());
		Cookie cookieName = new Cookie("Name", URLEncoder.encode(request.getParameter("username"),"utf-8"));
//		cookieName.setMaxAge(cookietimes*60*60*24);
		cookieName.setMaxAge(cookietimes);
		cookieName.setPath("/");
		response.addCookie(cookieName);
			    	      
		Cookie cookiePassword = new Cookie("Password", request.getParameter("password"));
//		cookiePassword.setMaxAge(cookietimes*60*60*24);
		cookiePassword.setMaxAge(cookietimes);
		cookiePassword.setPath("/");
		response.addCookie(cookiePassword);
					
		//使用日历计算当前时间，设置message以便传递到首页显示
		Calendar  calendar = null;
		String message=null;
		calendar = Calendar.getInstance();
		Date trialTime = new Date();
		calendar.setTime(trialTime);
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		if (hour<12)
		{
		     message="Good morning!";
		}
		else        
		{	  
			message="Good afternoon!";
		} 
		//根据实际情况执行跳转
		if(request.getParameter("username").equals("hlzhang")&&request.getParameter("password").equals("whvcse"))
		{
					  
			request.setAttribute("message", message);
			request.getRequestDispatcher("/main.jsp").forward(request,response);
		}
		else
		{
			response.sendRedirect("http://localhost:8080/chap4_Servlet/index.jsp?message=sorry please register");
					
		}
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
