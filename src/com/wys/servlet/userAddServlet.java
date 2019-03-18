package com.wys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wys.dao.userDao;
import com.wys.javabean.User;

@WebServlet("/userAddServlet")
public class userAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求字符编码
				request.setCharacterEncoding("UTF-8");
				// 获取用户添加信息
				String userLogname = request.getParameter("userLogname");
				String userPwd = request.getParameter("userPwd");
				String userRealname = request.getParameter("userRealname");
				String userEmail = request.getParameter("userEmail");
				int userRole = (request.getParameter("userRole") == null) ? 3
						: Integer.parseInt(request.getParameter("userRole"));
				int userState = (request.getParameter("userState") == null) ? 1
						: Integer.parseInt(request.getParameter("userState"));
				// 定义一个用来封装用户信息的JavaBean
				User user = new User(userLogname, userPwd, userRealname, userEmail, userRole, userState);
				// 用户信息添加
				userDao dao = new userDao();
				int n = dao.addUser(user);
				//dao.save(user);
				//跳转
				// 添加成功，重定向到响应页面
				//if(n==1) {
					response.sendRedirect(request.getContextPath()+"/manage/userList.html");
					//request.getRequestDispatcher("/manage/userList.html").forward(request, response);
		//		}else {
			//		response.sendRedirect(request.getContextPath()+"/manage/error.jsp");
			//	}
				
				
			
				

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
