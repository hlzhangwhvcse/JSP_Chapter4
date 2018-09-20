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
//		response.setContentType("text/html; charset=GB2312");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>SessionTest</title>");
		out.println("</head>");
		out.println("<body>");
		
		
		/*getSession(boolean create)意思是返回当前request中的HttpSession ，
		 * 如果当前request中的HttpSession 为null，当create为true，就创建一个新的Session，否则返回null；
		 *  简而言之： HttpServletRequest.getSession(true)等同于 HttpServletRequest.getSession() 
		 *HttpServletRequest.getSession(false)等同于 如果当前Session没有就为null；
	     */
		HttpSession session = request.getSession();
//		HttpSession session = request.getSession(true);
//		HttpSession session = request.getSession(false);
		
		/* 设置session超时的三种方式
		 * 1. 在Tomcat容器中设置：在config\web.xml中设置Tomcat默认session超时时间为30分钟，可以根据需要修改，负数或0为不限制session失效时间。
		 * 2. 在项目的web.xml文件中设置，单位为分钟
		 * <session-config>  
        			<session-timeout>30</session-timeout>  
			</session-config> 
		 * 3.通过Java代码设置session.setMaxInactiveInterval(20)单位为秒
		 * 4.优先级：  3 > 2 > 1
		 * */
		session.setMaxInactiveInterval(20);//setMaxInactiveInterval()设置的是当前会话的失效时间，不是整个web的时间，单位为以秒计算。如果设置的值为零或负数，则表示会话将永远不会超时 常用于设置当前会话时间。
		
		
		
		/*在B/S架构中，客户端与服务器连接，在服务器就会自动创建一个session对象。
		 * session.setAttribute(“username”, "zhangsan")就是将username保存到session中，session的key值为username，其value值为zhangsan，
		 * 这样以后可以通过session.getAttribute(“username”)的方法来获取这个对象。
		 * 通常，当用户已经登录系统后，就可以在session中存储一个用户信息对象，伺候可以随时从session中将这个对象取出来进行一些操作，比如身份验证等等
	    */
		Object obj = session.getAttribute("num");
		int val = 1;
		if (obj != null) 
		{
			String str = obj.toString();
			val = Integer.parseInt(str) + 1;
		}
		session.setAttribute("num", String.valueOf(val));

		String sessionId = session.getId();
		long createTime =  session.getCreationTime();
		long lastAccessedTime =  session.getLastAccessedTime();
		int maxInactiveInterval =  session.getMaxInactiveInterval();
		long predictInvalidTime =  lastAccessedTime + maxInactiveInterval*1000;
		
		out.println("<table><tr><td>");
		out.println("ID编号：</td><td>");
		out.println(sessionId + "</td></tr>");
		out.println("<tr><td>");
		out.println("session创建时间：</td><td> ");
		out.println(new Date(createTime));
		out.println(" </td></tr> <tr><td> ");
		out.println("session的最后访问时间：</td><td>");
		out.println(new Date(lastAccessedTime));
		out.println(" </td></tr> <tr><td> ");
		out.println("session的客户端无动作最大生存时间：</td><td> ");
		out.println((maxInactiveInterval));
		out.println("秒" + "</td></tr><tr><td>");
		out.println("session的预计失效时间：</td><td> ");
		out.println(new Date(predictInvalidTime));
		out.println("</td></tr><tr><td>");
		out.println("对session最大生存时间的解释：</td><td> ");
		out.println("WEB服务器采用“超时限制”的办法来判断客户端是否还在继续访问，如果某个客户端在一定的时间之内没有发出后续请求，WEB服务器则认为客户端已经停止了活动，结束与该客户端的会话并将与之对应的HttpSession对象销毁" + "</td></tr></table>");
		
		

		String strName = request.getParameter("txtName");
		String strValue = request.getParameter("txtValue");
		if (strName != null && strValue != null) 
		{
			session.setAttribute(strName, strValue);
		}
		
		Enumeration <?> attrNames = session.getAttributeNames();//返回Session中存在的属性名
		
		
		out.println("==============================");
		out.println("<table>");
		out.print("<tr><td>已添加的session属性：</td><tr>");
		while (attrNames.hasMoreElements()) 
		{	
			String attrName = (String)attrNames.nextElement();
			String attrValue = session.getAttribute(attrName).toString();
			out.print("<tr><td><b><font size=5 color=blue>属性名：" + attrName + "</font></b></td>");
			out.print("<td><b><font size=5 color=red>属性值：" + attrValue + "</font></b></td></tr>");		
		}
		out.println("</table>");

		out.println("==============================");
		out.println("<br>添加新的Session属性（name, value）：");
		out.println("<form action = 'SessionTest'");
		out.println("method= get>");
		out.println("名称：");
		out.println("<input type=text size=15 name=txtName>");
		out.println("<br>");
		out.println("数值：");
		out.println("<input type=text size=15 name=txtValue>");
		out.println("<br><br>");
		out.println("<input type=submit value=添加>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
