package yfj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yfj.model.User;

public class UserDao {

	/**
	 * 用户登录Dao
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public User login(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql = " select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
	
	/**
	 * 用户注册Dao
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(Connection con,User user) throws Exception{
		String sql = " insert into t_user values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户修改密码
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int update(Connection con,User user) throws Exception{
		String sql = " update t_user set userName=?,password=? where id=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3, user.getId());
		return pstmt.executeUpdate();
	}
}
