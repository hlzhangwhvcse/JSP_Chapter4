package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Date;
import java.util.Calendar;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopppingLogin
 */
@WebServlet("/ShopppingLogin")
public class ShopppingLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopppingLogin() 
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
		
		Calendar calendar = Calendar.getInstance();//getInstance方法返回一个Calendar对象（该对象为Calendar的子类对象），其日历字段已由当前日期和时间初始化,可以进行时间计算，时区指定
		Date currentDate = new Date();//设置为当前日期
//		Date currentDate = new Date(118, 8, 29, 17, 30, 30);//设置年月日时分秒2018-08-29 17:30:30  从1900年开始的年数
		calendar.setTime(currentDate);//Date转换为Calendar
		int hour = calendar.get(Calendar.HOUR_OF_DAY);//HOUR_OF_DAY 获取一天中的小时数  24 小时制
		
		HttpSession session = request.getSession(true);
		session.setAttribute("hour", hour);
		
		if (hour < 12)
		{
			response.sendRedirect("morningShow.html");
		} 
		else 
		{
			response.sendRedirect("afternoonShow.html");
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
