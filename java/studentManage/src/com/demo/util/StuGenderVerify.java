package com.demo.util;

import java.util.Scanner;

public class StuGenderVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请选择性别：");
		System.out.println("1、男");
		System.out.println("2、女");
		int stuGender = Integer.parseInt(sc.nextLine());
		while(stuGender != 1 && stuGender !=2) {
			System.err.println("你输入不正确，请查看提示后重新输入！");
			System.out.println("请选择性别：");
			System.out.println("1、男");
			System.out.println("2、女");
			stuGender = Integer.parseInt(sc.nextLine());
		}
		return stuGender == 1?"男":"女";

	}

}