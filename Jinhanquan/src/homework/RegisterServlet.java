package homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
@WebServlet(name="RegisterServlet",urlPatterns={"/homework/register"})
public class RegisterServlet extends HttpServlet {
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
		String regName=req.getParameter("regName");
		String regPwd=req.getParameter("regPwd");
		String job=req.getParameter("job");
		String note=req.getParameter("note");
		int count=DBUtil.register(regName,regPwd,job,note);
		if(count>0){
			resp.sendRedirect("/Jinhanquan/homework/login.jsp");  // 重定向到登录页面
		}
	}
}
