package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beans.User;
import com.utils.DbUtil;
import com.utils.StringUtil;

public class UserDao  {

	public static ResultSet getUser(String userName, String password) throws SQLException {
		
		String sql = "select * from user where `name` = ? AND password = ?" ;
		Connection con = DbUtil.getCon();
		PreparedStatement ptst = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1,userName);
			ptst.setString(2,password);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ptst.executeQuery();
	}

	public static int insertUser(User user) throws SQLException {

		String sql = "insert into `user` values (?,?,?)" ;
		Connection con = DbUtil.getCon();
		PreparedStatement ptst = null;
		Integer id = StringUtil.getID();
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1,id);
			ptst.setString(2,user.getUsername());
			ptst.setString(3,user.getPassword());
			ptst.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return id;
	}

	public static int update(Integer id, String password,String old) throws SQLException {

		String sql = "update  `user` set password=? where id = ? AND password=? " ;
		Connection con = DbUtil.getCon();
		PreparedStatement ptst = null;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1,password);
			ptst.setInt(2,id);
			ptst.setString(3,old);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ptst.executeUpdate();
	}

}