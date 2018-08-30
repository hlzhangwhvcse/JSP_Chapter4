<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"  import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
</head>
<body>
	HELLO, <%=request.getParameter("username") == null ? "" : request.getParameter("username")%><br>
</body>
 <h4><%=request.getAttribute("message") == null ? "" : request.getAttribute("message")%></h4>
</html>