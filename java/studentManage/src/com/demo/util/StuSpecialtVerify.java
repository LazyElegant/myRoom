package com.demo.util;

import java.util.Scanner;

public class StuSpecialtVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请选择专业：");
		System.out.println("1、软件工程");
		System.out.println("2、计算机科学与技术");
		String stuSpecialty = sc.nextLine();
		while(!(stuSpecialty.equals("1") || stuSpecialty.equals("2"))) {
//		while(!stuSpecialty.equals("1") &&  !stuSpecialty.equals("2")) {
			System.err.println("你输入不正确，请查看提示后重新输入！");
			System.out.println("请选择专业：");
			System.out.println("1、软件工程");
			System.out.println("2、计算机科学与技术");
			stuSpecialty = sc.nextLine();
		}
		return stuSpecialty;
	}

}
