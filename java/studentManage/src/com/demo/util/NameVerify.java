package com.demo.util;

import java.util.Scanner;

public class NameVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);

		String stuName = sc.nextLine();
		while(stuName.length() > 8 ||  stuName.length() < 2) {
			System.err.println("你输入不满足2-8位，请查证后重试！");
			System.out.println("请重新输入：");
			stuName = sc.nextLine();
		}
		return stuName;
	}

}
