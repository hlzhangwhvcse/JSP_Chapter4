package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//    需要把Servlet做成既能处理GET请求，也能够处理POST请求（eg：Servlet要处理GET和POST两种请求），这只需要在doPost方法中调用doGet方法，或者覆盖 service方法（service方法调用doGet、doPost、doHead等方法）。在实际编程中这是一种标准的方法，因为它只需要很少的额外工作，却能够增加客户端编码的灵活性。
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>SessionTest</title>");
		out.println("</head>");
		out.println("<body>");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("num");
		int val = 1;
		if (obj != null) 
		{
			String str = obj.toString();
			val = Integer.parseInt(str) + 1;
		}
		session.setAttribute("num", String.valueOf(val));

		out.println("<table><tr><td>");
		out.println("ID编号：</td><td>");
		out.println(session.getId() + "</td></tr>");
		out.println("<tr><td>");
		out.println("创建时间：</td><td> ");
		out.println(new Date(session.getCreationTime()));
		out.println(" </td></tr> <tr><td> ");
		out.println("最后访问时间：</td><td>");
		out.println(new Date(session.getLastAccessedTime()));
		out.println(" </td></tr> <tr><td> ");
		out.println("有效时间：</td><td> ");
		out.println((session.getMaxInactiveInterval()));
		out.println("秒" + "</td></tr></table>");

		String txtNam = request.getParameter("txtnam");
		String txtVal = request.getParameter("txtval");
		if (txtNam != null && txtVal != null) 
		{
			session.setAttribute(txtNam, txtVal);
		}
			Enumeration valueNames = session.getAttributeNames();
	
		while (valueNames.hasMoreElements()) 
		{
			out.println("<table>");
			String valuename = (String)valueNames.nextElement();
			String value = session.getAttribute(valuename).toString();
			out.print("<tr><td>名称：</td><td>" + valuename);
			out.println("</td><td>数值：");
			out.println("</td><td><b><font size=2 color=red>");
			out.println(value + "</font></b></td></tr>");	
			out.println("</table>");
		}

		out.println("<br>添加Session数据：");
		out.println("<form action = 'SessionTest'");
		out.println("method= get>");
		out.println("名称：");
		out.println("<input type=text size=15 name=txtnam>");
		out.println("<br>");
		out.println("数值：");
		out.println("<input type=text size=15 name=txtval>");
		out.println("<br><br>");
		out.println("<input type=submit value=添加>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
