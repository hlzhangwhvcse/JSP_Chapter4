package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() 
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
		
		HttpSession session_1 = request.getSession();
		String sessionId_1 = session_1.getId();//可用debug模式查看session ID值
		request.setAttribute("sessionId_1", sessionId_1);//将sessionId设置为为request的一个属性值,其属性名为sessionId_1
		
//		request.getRequestDispatcher("ForwardShow").forward(request, response);
		
		
		//使用response.sendRedirect()跳转，必然不是同一个request
		//如果是跨域跳转（不同项目），则不是同一个session，如果不跨域（同一个项目），仍然是同一个session
//		response.sendRedirect("ForwardShow?username=jack&password=123456&sessionId_1=" + sessionId_1);//不跨域跳转（同一个项目），不指定完整的URL，仍然是同一个session
//		response.sendRedirect("http://localhost:8080/chap4_Servlet/ForwardShow?username=Jack&password=123456&&sessionId_1=" + sessionId_1);//不跨域跳转（同一个项目），指定完整的URL，仍然是同一个session
//		response.sendRedirect("http://localhost:8080/chap4_test/ForwardShow?username=Jack&password=123456&&sessionId_1=" + sessionId_1);//跨域跳转（不同项目），在服务器上有project1和project2的两个不同项目同时运行，从project1跳转到project2是跨域跳转，不是同一个session。
//		response.sendRedirect("http://127.0.0.1:8080/chap4_Servlet/ForwardShow?username=Jack&password=123456&&sessionId_1=" + sessionId_1);//但如果同一个项目，URL地址从http://localhost:8080/project1跳转到http://127.0.0.1:8080/project2，视同跨域跳转，也不是同一个session
		
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
