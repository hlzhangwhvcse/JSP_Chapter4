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
 * Servlet implementation class ListParameter
 */
@WebServlet("/ListParameter")
public class ListParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListParameter() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ListParameter</title></head><body><table>");
		
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) 
		{
			String paramName = (String) paramNames.nextElement();
			out.println("<TR><TD>" + paramName + "<TD>");
			String[] paramValues = request.getParameterValues(paramName);
			if (1 == paramValues.length) 
			{
				String paramValue = paramValues[0];
				if (0 == paramValue.length()) 
				{
					out.print("<I>NoValue</I>");
				}
				else 
				{
					out.print(paramValue);
				}
			} 
			else 
			{
				out.println("<UL>");
				for (int i = 0; i < paramValues.length; i++) 
				{
					out.println("<LI>" + paramValues[i]);
				}
				out.println("</UL>");
			}
		}
		out.println("</table></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
