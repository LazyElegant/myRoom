package com.demo.student;

import com.demo.teacher.TeacherIndex;
import com.demo.teacher.TeacherPersonal;
import com.demo.teacher.TeacherUpdatePersonal;

import java.util.Scanner;

public class StudentOptionManagement {

	public static void App() {
		System.out.println("查看课程请输入1");
		System.out.println("查看成绩请输入2");
		System.out.println("返回上一级请输入quit");
		System.out.println("退出系统输入exit");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			StudentCourseList.App();
		} else if(userInput.equals("2")) {
			StudentScoreList.App();
		} else if(userInput.equals("quit")) {
			TeacherIndex.App();
		} else {
			System.err.println("您输入有误，请按照提示进行输入！");
			StudentOptionManagement.App();
		}
	}

}


