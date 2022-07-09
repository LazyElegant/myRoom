package com.demo;

import com.demo.Admin.AdminManager;
import com.demo.student.StudentManager;
import com.demo.teacher.TeacherManager;

import java.util.Scanner;

public class Index {

	public static void App() {
		System.out.println("跳转到管理员请输入 1");
		System.out.println("跳转到教师请输入 2");
		System.out.println("跳转到学生请输入 3");
		Scanner sc = new Scanner(System.in);
		int userInput = Integer.parseInt(sc.nextLine());
		// 基本数据类型，引用数据类型    == 值相等、内存地址（使用equals）
		switch (userInput){
			case 1:
				AdminManager.App();
				break;
			case 2:
				TeacherManager.App();
				break;
			case 3:
				StudentManager.App();
				break;
			default:
				System.out.println("您输入有误，请按照提示进行输入！");
				Index.App();
		}
	}

}
