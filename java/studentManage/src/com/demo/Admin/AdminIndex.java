package com.demo.Admin;

import java.util.Scanner;

public class AdminIndex {

	public static void App() {
		System.out.println("学生管理请输入1");
		System.out.println("班级管理请输入2");
		System.out.println("教师管理请输入3");
		System.out.println("课程管理请输入4");
		System.out.println("退出系统输入exit"); 
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			AdminStudentManagement.App();
		}else if(userInput.equals("2")) {
		    AdminClassManagement.App();
		} else if(userInput.equals("3")) {
			AdminTeacherManagement.App();
		} else if(userInput.equals("4")) {
			AdminCourseManagement.App();
		} else if(userInput.equals("exit")) {
			System.out.println("退出系统成功!");
		}else {
		     System.err.println("您输入有误，请按照提示进行输入!");
		     AdminIndex.App();
		}

	}

}
