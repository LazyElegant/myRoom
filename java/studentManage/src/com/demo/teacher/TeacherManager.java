package com.demo.teacher;

import com.demo.Admin.AdminForgotPassword;
import com.demo.Admin.AdminLogin;
import com.demo.Index;

import java.util.Scanner;

public class TeacherManager {

	public static void App() {
		System.out.println("=====欢迎教师用学生管理系统=====");
		System.out.println("登录请输入1");
		System.out.println("找回密码请输入2");
		System.out.println("返回上一级，请输入quit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			TeacherLogin.App();
		} else if(userInput.equals("2")) {
			TeacherForgotPassword.App();
		} else if(userInput.equals("quit")) {
			Index.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			TeacherManager.App();
		}
	}

}