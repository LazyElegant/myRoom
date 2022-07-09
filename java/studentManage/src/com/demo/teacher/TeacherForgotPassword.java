package com.demo.teacher;

import com.demo.Admin.AdminManager;
import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherForgotPassword {
	public static void App() {
		System.out.println("欢迎进入教师找回密码界面！");
		// 获取学号
		System.out.println("请输入工号：");
		String code = CodeVerify.App();
		// 获取手机号
		String tel = StuTelVerify.App();
		
		// 调用数据库查看是否拥有具有当前信息的用户
		String sql = "SELECT code FROM teacher WHERE CODE = '"+code+"' AND tel ='"+tel+"'";
		ResultSet result = Sql_Statement_Query.App(sql);
		Scanner sc = new Scanner(System.in);
		try {
			if(result.next()) {
				System.out.println("用户信息对比成功，请输入密码：");
				String password = PasswordVerify.App();
				// 调用数据库，更改密码
				String sql1 = "UPDATE teacher SET password = '"+MD5Util.getMD5(password.getBytes())+"' WHERE code='"+code+"'";
				int result1 = Sql_Statement_Update.App(sql1);
				// 7、对返回结果进行处理
				if(result1 == 1) {
					System.out.println("修改成功！");
					System.out.println("输入quit返回上一级！");
					// 使用 sc.nextLine(); 来读取缓存中的残留回车
					String userInput = sc.nextLine();
					while(!userInput.equals("quit")) {
						System.err.println("你输入有误");
						System.out.println("输入quit返回上一级！");
						userInput = sc.nextLine();
					}
				} else {
					System.err.println("修改失败！自动返回上一级");
				}
			} else {
				System.err.println("用户不存在，请查看工号或手机号是否正确！");
				System.out.println("返回上一级请输入quit");
				String userInput = sc.nextLine();
				while(!userInput.equals("quit")) {
					System.out.println("输入错误，返回上一级请输入quit");
					userInput = sc.nextLine();
				}
			}
			TeacherManager.App();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}