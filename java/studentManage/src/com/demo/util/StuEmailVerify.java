package com.demo.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StuEmailVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		
		String reg_email = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+\\.([a-zA-Z0-9_-])+";
		System.out.println("请输入邮箱：");
		String stuEmail = sc.nextLine();
		while(!Pattern.matches(reg_email, stuEmail)) {
			System.err.println("邮箱格式不正确");
			System.out.println("请重新输入邮箱：");
			stuEmail = sc.nextLine();
		}
		return stuEmail;
	}

}
