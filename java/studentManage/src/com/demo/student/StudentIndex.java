package com.demo.student;

import com.demo.teacher.TeacherCourseManagement;
import com.demo.teacher.TeacherPersonalManagement;

import java.util.Scanner;

public class StudentIndex {

	public static void App() {
		System.out.println("查看学生信息请输入1");
		System.out.println("选修课程请输入2");
		System.out.println("退出系统输入exit"); 
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			StudentOptionManagement.App();
		}else if(userInput.equals("2")) {
			StudentAddOption.App();
		} else if(userInput.equals("exit")) {
			System.out.println("退出系统成功!");
		}else {
		     System.err.println("您输入有误，请按照提示进行输入!");
		     StudentIndex.App();
		}
	}
}
