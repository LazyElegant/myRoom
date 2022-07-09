package com.demo.teacher;

import com.demo.Admin.AdminIndex;
import com.demo.Admin.AdminManager;
import com.demo.util.CodeVerify;
import com.demo.util.MD5Util;
import com.demo.util.PasswordVerify;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherLogin {

	public static String code = "";

	public static void App() {
		System.out.println("欢迎进入教师登录页面");
		// 获取登录的工号
		System.out.println("请输入工号:");
		String AdminCode = CodeVerify.App();
		// 获取登录的密码
		String password = PasswordVerify.App();
		// 调用数据库对比工号和密码
		String sql = "SELECT code FROM teacher WHERE CODE = '"+AdminCode+"' AND PASSWORD = '"+MD5Util.getMD5(password.getBytes())+"' AND state = 1";
		ResultSet result = Sql_Statement_Query.App(sql);
		try {
			if(result.next()) {
				System.out.println("教师登录成功！");
				code = AdminCode;
				TeacherIndex.App();
			} else {
				System.err.println("教师登录失败，自动跳转到上一级！");
				TeacherManager.App();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}