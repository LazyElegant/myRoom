package com.demo.teacher;

import com.demo.Admin.AdminAddStudent;
import com.demo.Admin.AdminDeleteStudent;
import com.demo.Admin.AdminIndex;
import com.demo.Admin.AdminUpdateStudent;

import java.util.Scanner;

public class TeacherCourseManagement {

	public static void App() {
		System.out.println("查看所教课程请输入1");
		System.out.println("录入成绩请输入2");
		System.out.println("返回上一级请输入quit");
		System.out.println("退出系统输入exit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			TeacherCourseList.App();
		} else if(userInput.equals("2")) {
			TeacherAddScore.App();
		} else if(userInput.equals("3")) {
			AdminUpdateStudent.App();
		} else if(userInput.equals("quit")) {
			TeacherIndex.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			TeacherCourseManagement.App();
		}
	}

}


