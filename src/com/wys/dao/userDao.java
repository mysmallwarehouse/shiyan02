
package com.wys.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.wys.javabean.User;
import com.wys.util.DBUtil;

public class userDao {
	/**
	 * ÓÃ»§Ìí¼Ó
	 * @param user
	 */
	public void save(User user) {
		java.sql.Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_users(user_id,user_logname,user_pwd,user_realname,user_email,user_role,user_state"+ ") VALUES(SEQ_ITOFFER_USERS.NEXTVAL,?,?,?,?,?,?)";
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
	}
}
