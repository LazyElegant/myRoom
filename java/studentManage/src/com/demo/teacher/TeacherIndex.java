package com.demo.teacher;

import com.demo.Admin.AdminClassManagement;
import com.demo.Admin.AdminCourseManagement;
import com.demo.Admin.AdminStudentManagement;
import com.demo.Admin.AdminTeacherManagement;

import java.util.Scanner;

public class TeacherIndex {

	public static void App() {
		System.out.println("个人中心请输入1");
		System.out.println("课程管理请输入2");
		System.out.println("退出系统输入exit"); 
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		if(userInput.equals("1")) {
			TeacherPersonalManagement.App();
		}else if(userInput.equals("2")) {
			TeacherCourseManagement.App();
		} else if(userInput.equals("exit")) {
			System.out.println("退出系统成功!");
		}else {
		     System.err.println("您输入有误，请按照提示进行输入!");
		     TeacherIndex.App();
		}

	}

}
