package com.demo.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StuTelVerify {

	public static String App() {
		Scanner sc = new Scanner(System.in);
		
		String reg_tel = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
		System.out.println("请输入手机号：");
		String stuTel = sc.nextLine();
		while(stuTel.length() != 11 || !Pattern.matches(reg_tel, stuTel)) {
			if(stuTel.length() != 11) {				
				System.err.println("手机号位数不正确");
			}  else if(!Pattern.matches(reg_tel, stuTel)) {
				System.err.println("手机号格式不正确");
			}
			System.out.println("请输入手机号：");
			stuTel = sc.nextLine();
		}
		return stuTel;
	}

}