<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>注册页面</title>
</head>
<body>
   <form action="register" method="post">
     <table>
   		<tr>
      		<td>请输入注册用户名：</td>  
			<td><input type="text" name="regName"/></td>
	  	</tr>
	  	<tr>
      		<td>请输入注册密码：</td>  
			<td><input type="password" name="regPwd"/></td>
	  	</tr>
	  	<tr>
      		<td>职业:</td>
      		<td><input type="text" name="job"></td>
        </tr>
        <tr>
      		<td>签名:</td>
      		<td><input type="text" name="note"></td>
        </tr>
	    <tr>
        	<td colspan="2"><input type="submit" value="注册"/>
        	<input type="reset" value="重置"/></td>
        </tr>
     </table>
   </form>
</body>
</html>