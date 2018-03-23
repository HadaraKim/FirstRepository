<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>登录页面</title>
</head>
<body>
   <form action="login" method="post">
   <table>
      <tr>
      	<td>登录名：</td>  
		<td><input type="text" name="loginName"/></td>
	  </tr>
	  <tr>
      	<td>登录密码：</td>
      	<td><input type="password" name="loginPwd"/></td>
	  </tr>
	  <tr>
        <td colspan="2"><input type="submit" value="登录"/>
        <input type="reset" value="重置"/></td>
      </tr>
   </table>
   </form>
</body>
</html>