package com.wys.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wys.dao.CompanyDao;
import com.wys.javabean.Company;

/**
 * 企业信息添加Servlet
 * 
 */
@WebServlet("/companyAddServlet")
@MultipartConfig
public class companyAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求字符编码
		request.setCharacterEncoding("UTF-8");
		// 设置响应字符编码
		response.setContentType("text/html;charset=UTF-8");
		// 获取响应字符输出流
		PrintWriter out = response.getWriter();
		// 获取企业添加信息
		String companyName = request.getParameter("companyName");
		String companyArea = request.getParameter("companyArea");
		String companySize = request.getParameter("companySize");
		String companyType = request.getParameter("companyType");
		String companyBrief = request.getParameter("companyBrief");
		int companyState = (request.getParameter("companyState") == null) ? 1
				: Integer.parseInt(request.getParameter("companyState"));
		int companySort = (request.getParameter("companySort") == null) ? 0
				: Integer.parseInt(request.getParameter("companySort"));
		// 获取上传文件域
		Part part = request.getPart("companyPic");
		// 获取上传文件名称
		String fileName = part.getSubmittedFileName();
		// 为防止上传文件重名，对文件进行重命名
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// 将上传的文件保存在服务器根目录下的upload/companyPic子目录下
		String filepath = getServletContext().getRealPath("/");
		filepath = filepath.substring(0, filepath.indexOf(getServletContext().getServletContextName()));
		filepath = filepath + "upload/companyPic";
		getServletContext().log("上传路径为：" + filepath);
		File f = new File(filepath);
		if (!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		// 定义一个用来封装企业信息的JavaBean
		Company company = new Company(companyName, companyArea, companySize, companyType, companyBrief, companyState,
				companySort, 0, newFileName);

		
		// 企业信息添加
		CompanyDao dao = new CompanyDao();

		dao.save(company);
		// 添加成功提示和响应结果导向
		out.print("<script type='text/javascript'>");
		out.print("alert('企业信息添加成功！');");
		out.print("window.location='manage/companyList.html';");
		out.print("</script>");
	}
}
