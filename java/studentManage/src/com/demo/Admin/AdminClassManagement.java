package com.demo.Admin;

import java.util.Scanner;

public class AdminClassManagement {

	public static void App() {
		System.out.println("展示班级列表请输入1");
		System.out.println("添加班级请输入2");
		System.out.println("删除班级请输入3");
		System.out.println("修改班级信息请输入4");
		System.out.println("查询班级请输入5");
		System.out.println("返回上一级请输入quit");
		System.out.println("退出系统输入exit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			AdminClassList.App();
		} else if(userInput.equals("2")) {
			AdminAddClass.App();
		} else if(userInput.equals("3")) {
			AdminDeleteClass.App();
		} else if(userInput.equals("4")) {
			AdminUpdateClass.App();
		} else if(userInput.equals("5")) {
			AdminGetClass.App();
		} else if(userInput.equals("quit")) {
			AdminIndex.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			AdminStudentManagement.App();
		}
	}
}


