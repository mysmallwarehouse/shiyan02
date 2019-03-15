package com.wys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itoffer", "root", "123456789");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("打开连接");
		Connection conn = DBUtil.getConnection();
		System.out.println("获取的Connection：" + conn);
		System.out.println("关闭连接");
		DBUtil.closeJDBC(null, null, conn);
	}

}
