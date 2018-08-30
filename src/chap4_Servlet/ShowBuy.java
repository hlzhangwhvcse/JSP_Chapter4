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
 * Servlet implementation class ShowBuy
 */
@WebServlet("/ShowBuy")
public class ShowBuy extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBuy() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//上午，下午有不同的商品
		String[] morningItem = { "糖果", "牛奶", "苹果" };
		String[] afternoonItem = { "计算器", "收音机", "练习簿" };
		
		
		//取得Session对象, 如果Session不存在，为本次会话创建此对象
		HttpSession session = request.getSession(true);
//		session.invalidate(); //清除session对象中的所有信息
		Integer hour = (Integer)session.getAttribute("hour");
		
		
		Integer itemCount = (Integer) session.getAttribute("itemCount");//获取选择的商品数目

		//如果没放入商品则数目为0		
		if (null == itemCount) 
		{
//			itemCount = new Integer(0);//Be deprecated since java 9
			itemCount = Integer.valueOf(0);
		}

		//Set the content type of the response
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();

		//取得前端POST的表单信息
		String itemName = "";	
		String[] itemsSelected = request.getParameterValues("item");//itemsSelected[0]=2,表示只选中了value=2的item			
		//将选中的商品放入会话对
		if (itemsSelected != null) 
		{
			for (int i = 0; i < itemsSelected.length; i++) 
			{
				itemName = itemsSelected[i];
//				itemCount = new Integer(itemCount.intValue() + 1);
				itemCount = Integer.valueOf(itemCount.intValue() + 1);//intValue()把Integer对象类型变成int基础数据类型
				
				session.setAttribute("Item" + itemCount, itemName);//购买的条目
				session.setAttribute("itemCount", itemCount);//总条目

			}
		}

		//Write the page header
		out.println("<html>");
		out.println("<head>");
		out.println("<title>购物袋的内容</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center><h1>你放在购物袋中的商品是： </h1></center>");
		
		//将购物袋的内容写入页面
//		for(int i = 1; i < itemCount.intValue(); i++) //教材89页印刷错误，应该为<=
		for(int i = 1; i <= itemCount.intValue(); i++) //i的范围从第1个item到第itemCount个item,应该为<=
		{
			String items = (String) session.getAttribute("Item" + i);
			
			//取出商品名称,如果是下午，取出下午商品名称
			if(hour < 12) 
			{
				out.println(morningItem[Integer.parseInt(items)]);
			} 
			else 
			{
				out.println(afternoonItem[Integer.parseInt(items)]);
			}
			out.println("<BR>");
		}
		
		//Wrap up
		out.println("</body>");
		out.println("</html>");
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
