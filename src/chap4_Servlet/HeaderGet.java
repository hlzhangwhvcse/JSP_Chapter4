package chap4_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * Servlet implementation class HeaderGet
 */
@WebServlet("/HeaderGet")
public class HeaderGet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderGet() 
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
		
		Enumeration params = request.getParameterNames();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println(" <HTML> ");
		out.println(" <HEAD>");
		out.println(" <TITLE>HeaderGet</TITLE> ");
		out.println(" </HEAD> ");
		out.println(" <BODY BGCOLOR=white align = 'center' > ");
		out.println(" <CENTER> ");
		out.println(" <FONT COLOR='#009999' SIZE='4' face='Arial' align = 'center' > ");
		out.println(" <STRONG>List of all Headers in Servlet Request</STRONG> ");
		out.println(" </FONT> ");
		out.println(" </CENTER> ");
		out.println(" <HR> ");
		out.println("<B>Method: </B>" + request.getMethod() + " + ");
		out.println("<B>URI: </B>" + request.getRequestURI() + " + ");
		out.println("<B>Protocol: </B>" + request.getProtocol() + "<BR>");
		out.println("<B>QueryString: </B>" + request.getQueryString() + "<BR>");
		out.println("<B>ContentType: </B>" + request.getContentType() + "<BR>");
		out.println("<B>ContextPath: </B>" + request.getContextPath() + "<BR>");
		out.println("<CENTER><H3> Header Name and Values </H3></CENTER>");
		out.println("<TABLE BORDER=1 ALIGN=CENTER >");
		out.println("<TR BGCOLOR='#99cee6'> <TH> Name</TH> <TH>Value </TH> </TR> ");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) 
		{
			String headerName = (String) headerNames.nextElement();
			out.println("<TR><TD>" + headerName + "</TD>");
			out.println("    <TD>" + request.getHeader(headerName) + "</TD>");
		}
		out.println("</TABLE>"	);
		out.println("</BODY></HTML>");
		out.flush();
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
