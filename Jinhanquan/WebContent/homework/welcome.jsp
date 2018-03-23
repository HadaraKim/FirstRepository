<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="homework.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>欢迎页面</title>
</head>
<body>
    <%
        User user=(User)session.getAttribute("user");
        if(user!=null){
    %>
        	<h3>欢迎<%=user.getUsername()%>访问本网站！</h3>
    <%
        }else{
     %>
            <h3>您还未登录，请先<a href="/Jinhanquan/homework/login.jsp">登录</a></h3>
    <% 
        }
    %>
</body>
</html>