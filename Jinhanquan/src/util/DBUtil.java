package util;
import homework.User;

import java.sql.*;
public class DBUtil {
   static{
	   try {
		   Class.forName("com.mysql.jdbc.Driver");   // 加载数据库驱动程序
	   } catch (ClassNotFoundException e) {
		   e.printStackTrace();
	   }
   }
   
   public static Connection getConnection(){
	   Connection conn=null;
	   try {
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456");
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return conn;
   }
   
   // 注册方法
   public static int register(String regName,String regPwd,String job,String note){
	   int count=0;
	   Connection conn=getConnection();
	   PreparedStatement ps=null;
	   if(conn!=null){
		   String sql="insert into user(username,password,job,note)values(?,?,?,?)";
		   try {
			   ps=conn.prepareStatement(sql);
			   ps.setString(1,regName);
			   ps.setString(2,regPwd);
			   ps.setString(3,job);
			   ps.setString(4,note);
			   count=ps.executeUpdate();   // 执行插入语句，返回影响行数
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }finally{
			   try {
				   ps.close();
				   conn.close();
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
		   }
	   }
	   return count;
   }
   
   // 登录
   public static User login(String loginName,String loginPwd){
	   User user=null;
	   Connection conn=getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   if(conn!=null){
		   String sql="select id,username,password from user where username=? and password=?";
		   try {
			  ps=conn.prepareStatement(sql);
			  ps.setString(1,loginName);
			  ps.setString(2,loginPwd);
			  rs=ps.executeQuery();  // 查询，返回结果集
			  if(rs.next()){
				  int id=rs.getInt("id");
				  String username=rs.getString("username");
				  String password=rs.getString("password");
				  user=new User(id,username,password);   // 将查询到的数据库的数据封装到对象中
			  }
	       }catch (SQLException e) {
			  e.printStackTrace();
		   }finally{
			   try {
				   rs.close();
				   ps.close();
				   conn.close();
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
		   }
	   }
	   return user;
   }
}
