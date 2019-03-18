
package com.wys.dao;

import java.sql.*;


import com.wys.javabean.User;
import com.wys.util.DBUtil;

public class userDao {
	/**
	 * ÓÃ»§Ìí¼Ó
	 * @param user
	 */
	/*public void save(User user) {
		java.sql.Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_users(USER_LOGNAME,USER_PWD,USER_REALNAME,USER_EMAIL,USER_ROLE,USER_STATE"+ ") VALUES(?,?,?,?,?,?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserLogname());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserRealname());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setInt(5, user.getUserRole());
			pstmt.setInt(6, user.getUserState());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public int addUser(User user) {
		int n = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO tb_users(USER_LOGNAME,USER_PWD,USER_REALNAME,USER_EMAIL,USER_ROLE,USER_STATE"+ ") VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserLogname());
			stmt.setString(2, user.getUserPwd());
			stmt.setString(3, user.getUserRealname());
			stmt.setString(4, user.getUserEmail());
			stmt.setInt(5, user.getUserRole());
			stmt.setInt(6, user.getUserState());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, stmt, conn);
		}
		
		
		return n;
	}
}
