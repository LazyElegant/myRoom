package util;

import java.sql.*;

public class DbUtil {

	private static String dbUrl = "jdbc:mysql://localhost:3306/bookManage?characterEncoding=utf8";
	private static String dbUserName = "zxwl";
	private static String dbPassword = "ZXWL@1702b";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName(jdbcName);
			con = DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @param pst
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs, PreparedStatement pst){
		if (conn!=null){
			try {
				conn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (stmt!=null){
			try {
				stmt.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (rs!=null){
			try {
				rs.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (pst!= null){
			try {
				pst.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	/**
	 * 捕获异常
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
}
