
package com.wys.dao;

import java.sql.*;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.wys.javabean.User;
import com.wys.util.DBUtil;

public class userDao {
	/**
	 * 用户添加
	 * @param user
	 */
	/*public void save(User user) {
		java.sql.Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_users(USER_LOGNAME,USER_PWD,USER_REALNAME,USER_EMAIL,USER_ROLE,USER_STATE"+ ") VALUES(SEQ_USERS.NEXTVAL,?,?,?,?,?,?)";
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
	
	*/
	

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

	
	
	
	
/**
 * 用戶登錄	
 */
	
	public User login(String userLogname,String userPwd) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		User user = null;
		ResultSet rs = null;
		String sql = "SELECT user_id,user_realname,user_email,user_role,user_state FROM tb_users WHERE user_logname=? and user_pwd=?";

						try {
							stmt = conn.prepareStatement(sql);
							stmt.setString(1, userLogname);
							stmt.setString(2, userPwd);
							 rs =  stmt.executeQuery();
							if(rs.next()){
								user = new User();
								user.setUserId(rs.getInt(1));
								user.setUserLogname(rs.getString(2));
								user.setUserPwd(rs.getString(3));
								
								user.setUserRealname(rs.getString(4));
								user.setUserEmail(rs.getString(5));
								user.setUserRole(rs.getInt(6));
								user.setUserState(rs.getInt(7));
								//user.setUserId(rs.getInt(8));
							
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							DBUtil.closeJDBC(rs, stmt, conn);
						}
						return user;
						

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
