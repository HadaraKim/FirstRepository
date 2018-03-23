package homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBUtil;
@WebServlet(name="LoginServlet",urlPatterns={"/homework/login"})
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loginName=req.getParameter("loginName");
		String loginPwd=req.getParameter("loginPwd");
		User user=DBUtil.login(loginName, loginPwd);
		if(user!=null){
			HttpSession session=req.getSession();
			session.setAttribute("user",user);   // 只有登录成功后，才设置该session的属性
			req.getRequestDispatcher("/homework/welcome.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/homework/fail.jsp").forward(req, resp);
		}
	}
}
