package util;
import homework.User;

import java.sql.*;
public class DBUtil {
   static{
	   try {
		   Class.forName("com.mysql.jdbc.Driver");   // �������ݿ���������
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
   
   // ע�᷽��
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
			   count=ps.executeUpdate();   // ִ�в�����䣬����Ӱ������
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
   
   // ��¼
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
			  rs=ps.executeQuery();  // ��ѯ�����ؽ����
			  if(rs.next()){
				  int id=rs.getInt("id");
				  String username=rs.getString("username");
				  String password=rs.getString("password");
				  user=new User(id,username,password);   // ����ѯ�������ݿ�����ݷ�װ��������
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
