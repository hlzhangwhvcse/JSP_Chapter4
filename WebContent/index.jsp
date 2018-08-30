<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"  import="java.net.URLDecoder" %>
<!DOCTYPE html>

<%
String username="";
String password="";
Cookie cookies[]=request.getCookies();

if(cookies!=null)
{
	for(int i=0; i<cookies.length; i++)
    {	
		if(cookies[i].getName().equals("Name"))
     	{
	   		username = URLDecoder.decode(cookies[i].getValue(),"utf-8");
       		System.out.print(username);
     	}
     	if(cookies[i].getName().equals("Password"))
     	{
       		password = cookies[i].getValue(); 
      	 	System.out.print(password);
     	}
   }
}
 %>



<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
</head>
<body>
    <form action="LoginServlet" method="post" >
      	用户名：<input type="text"  name="username"  value="<%out.print(username);%>">
                     密     码：<input type="password"  name="password"  value="<%out.print(password);%>">
        Cookie：
      <select name="cookietime">
        <option value="0">不保存</option>
        <option value="10">10秒</option>
        <option value="30">30秒</option>
        <option value="60">1分钟</option>
      </select>
        <input type="submit" name="login" value="登录">
        <input type="reset"  value="重置">
    </form>
     <h4><%=request.getParameter("message") == null ? "" : request.getParameter("message")%></h4>
</body>
</html>