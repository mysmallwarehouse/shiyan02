package com.wys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wys.javabean.User;

/**
 * Servlet implementation class userAddServlet
 */
@WebServlet("/userAddServlet")
public class userAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置读取编码
		request.setCharacterEncoding("utf-8");
		
		//读取请求信息
		String userLogname = request.getParameter("userLogname");
		String userPwd = request.getParameter("userPwd");
		String userRealname = request.getParameter("userRealname");
		String userEmail = request.getParameter("userEmail");
		int userRole = (request.getParameter("userRole")==null)?1:
		Integer.parseInt(request.getParameter("userRole"));
		
		int userState = (request.getParameter("userState")==null)?1:
			Integer.parseInt(request.getParameter("userState"));
		
		User user = new User(userLogname,userPwd,userRealname,userEmail);
		
		//读取用户信息
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
