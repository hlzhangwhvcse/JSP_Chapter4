package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
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
		
		HttpSession session = request.getSession();
		String sessionId = session.getId();//可用debug模式查看值
		//request.getRequestDispatcher("ForwardShow").forward(request, response);
				
//		response.sendRedirect("ForwardShow?username=jack&password=123456");//使用response.sendRedirect()，如果是跨域跳转，则session会丢失，如果不跨域，仍然是同一个session
//		response.sendRedirect("http://localhost:8080/chap4_Servlet/ForwardShow?username=Jack&password=123456");//在本地机上有web1和web2的两个不同项目同时运行，从web1跳转到web2是跨域跳转，session丢失。
		response.sendRedirect("http://127.0.0.1:8080/chap4_Servlet/ForwardShow?username=Jack&password=123456");//但如果是同一个项目，从地址http://localhost:8080/web1跳转到http://127.0.0.1:8080/web2也同样会丢失session
		
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
