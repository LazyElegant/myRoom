package com.demo.util;

import java.util.Scanner;

public class CodeVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		String stuCode = sc.nextLine();
		while(stuCode.length() != 8) {
			System.err.println("你输入有误，不满足8位，请查证后重试！");
			System.out.println("请重新输入：");
			stuCode = sc.nextLine();
		}
		return stuCode;
	}

}