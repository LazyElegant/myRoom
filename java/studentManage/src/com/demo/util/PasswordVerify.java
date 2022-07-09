package com.demo.util;

import java.util.Scanner;

public class PasswordVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		while(password.length() > 18 || password.length() < 6) {
			System.err.println("你输入不满足6-18位，请查证后重试！");
			System.out.println("请重新输入密码：");
			password = sc.nextLine();
		}
		return password;
	}

}