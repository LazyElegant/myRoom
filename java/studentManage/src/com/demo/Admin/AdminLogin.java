package com.demo.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.util.CodeVerify;
import com.demo.util.MD5Util;
import com.demo.util.PasswordVerify;
import com.demo.util.Sql_Statement_Query;

public class AdminLogin {

	public static void App() {
		System.out.println("欢迎进入管理员登录页面");
		// 获取登录的工号
		System.out.println("请输入工号:");
		String AdminCode = CodeVerify.App();
		// 获取登录的密码
		String password = PasswordVerify.App();
		// 调用数据库对比工号和密码
		String sql = "SELECT code FROM admin WHERE CODE = '"+AdminCode+"' AND PASSWORD = '"+MD5Util.getMD5(password.getBytes())+"'";
//		System.out.println(sql);
		ResultSet result = Sql_Statement_Query.App(sql);
		try {
			// next()用来控制数据的行，只能从上到下，调用一次光标就向下挪动一行
			// next()的返回结果为布尔型，如果光标挪动后有数据则 返回true，否则返回false
			// result.getString(1)  取当前行的具体列，参数为1则取第一例，列的类型必须与调用的方法对应
//			System.out.println(result.next());
//			System.out.println(result.next());
//			System.out.println(result.next());
//			System.out.println(result.getString(1));
			
			if(result.next()) {
				System.out.println("管理员登录成功！");
				AdminIndex.App();
			} else {
				System.err.println("管理员登录失败，自动跳转到上一级！");
				AdminManager.App();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("管理员登录成功！");
//		AdminIndex.App();
	}

}