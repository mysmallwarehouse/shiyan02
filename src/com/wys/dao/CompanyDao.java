package com.wys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import com.wys.javabean.Company;
import com.wys.util.DBUtil;

public class CompanyDao {

	/**
	 * 企业信息添加
	 * 
	 * @param company
	 */
	public void save(Company company) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_company("
				+ "company_id,company_name,company_area,company_size,company_type,company_brief,company_state,company_sort,company_viewnum,company_pic"
				+ ") VALUES(SEQ_ITOFFER_COMPANY.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getCompanyArea());
			pstmt.setString(3, company.getCompanySize());
			pstmt.setString(4, company.getCompanyType());
			pstmt.setString(5, company.getCompanyArea());
			pstmt.setInt(6, company.getCompanyState());
			pstmt.setInt(7, company.getCompanySort());
			pstmt.setInt(8, company.getCompanyViewnum());
			pstmt.setString(9, company.getCompanyPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
