package com.utils;

import java.sql.*;

public class DbUtil {

	private static String dbUrl = "jdbc:mysql://localhost:3306/waterManage?characterEncoding=utf8";
	private static String dbUserName = "zxwl";
	private static String dbPassword = "ZXWL@1702b";
	private static String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * ��ȡ���ݿ�����
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
	 * �ر����ݿ�����
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
	 * �����쳣
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}

}
