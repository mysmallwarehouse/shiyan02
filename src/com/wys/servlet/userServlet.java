package com.wys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wys.dao.userDao;
import com.wys.javabean.User;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//准备工作		
		// 设置请求字符编码
		request.setCharacterEncoding("utf-8");
		// 设置响应字符编码
		response.setContentType("text/html;charset=utf-8");

		// 读取数据,获取操作类型
		String type = request.getParameter("type");
		if ("login".equals(type)) {
			// 登陸驗證
			String userLogname = request.getParameter("userLogname");
			String userPwd = request.getParameter("userPwd");
			// 調用dao 數據訪問層
			userDao dao = new userDao();
			User user = dao.login(userLogname, userPwd);
			if (user != null) {
				// 登录成功，使用会话域属性记录用户信息，进入管理主界面
				request.getSession().setAttribute("user", user);
				response.sendRedirect("manage/main.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert(用戶或密碼有誤！)");
				out.println("window.location='login.jsp");
				out.println("</script>");

			}

			// 跳轉
		} else if ("logout".equals(type)) {
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");

		}

	}

}
