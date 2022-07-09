package com.demo.Admin;

import java.util.Scanner;

public class AdminStudentManagement {

	public static void App() {
		System.out.println("添加学生请输入1");
		System.out.println("删除学生请输入2");
		System.out.println("信息修改请输入3");
		System.out.println("查看学生请输入4");
		System.out.println("禁用学生账号请输入5");
		System.out.println("重置密码请输入6");
		System.out.println("返回上一级请输入quit");
		System.out.println("退出系统输入exit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			AdminAddStudent.App();
		} else if(userInput.equals("2")) {
			AdminDeleteStudent.App();
		} else if(userInput.equals("3")) {
			AdminUpdateStudent.App();
		} else if(userInput.equals("4")) {
			AdminStudentList.App();
		} else if(userInput.equals("5")) {
			AdminBanStudent.App();
		} else if(userInput.equals("6")) {
			AdminUpdatePasswordStudent.App();
		} else if(userInput.equals("quit")) {
			AdminIndex.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			AdminStudentManagement.App();
		}
	}

}


