package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

/**
 * Servlet implementation class ForwardShow
 */
@WebServlet("/ForwardShow")
public class ForwardShow extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardShow() 
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String sessionId_1 = (String)request.getAttribute("sessionId_1");//获取ForwardServlet的sessionId
		
		if(null == sessionId_1)//如果sessionId_1为null，说明已经不是同一个request，是sendRedirect方式跳转过来的
		{
			sessionId_1 = request.getParameter("sessionId_1");//从sendRedirect所传的参数值获取ForwardServlet的sessionId
		}
		
		HttpSession session_2 = request.getSession();//获取ForwardShow的sessionId
		String sessionId_2 = session_2.getId();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>forword</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>这是通过forword后的界面</p>");
		out.println("姓名：" + username + "<br>");
		out.println("密码：" + password + "<br>");
		out.println("ForwardServlet的sessionId值为：" + sessionId_1 + "<br>");
		out.println("ForwardShow的sessionId值为：" + sessionId_2 + "<br>");
		out.println("</body>");
		out.println("</html>");
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
