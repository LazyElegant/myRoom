package com.demo.teacher;

import com.demo.Admin.*;

import java.util.Scanner;

public class TeacherPersonalManagement {

	public static void App() {
		System.out.println("查看个人信息请输入1");
		System.out.println("修改个人信息请输入2");
		System.out.println("返回上一级请输入quit");
		System.out.println("退出系统输入exit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			TeacherPersonal.App();
		} else if(userInput.equals("2")) {
			TeacherUpdatePersonal.App();
		} else if(userInput.equals("quit")) {
			TeacherIndex.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			TeacherPersonalManagement.App();
		}
	}

}


