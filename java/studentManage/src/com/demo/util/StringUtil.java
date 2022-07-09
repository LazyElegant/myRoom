package com.demo.util;

public class StringUtil {

	/**
	 * 判断字符串是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 创建6位的id
	 *
	 * @return
	 */
	public static String getCode() {
		String u_word = "";
		int num = 0;
		for (int i = 1; i <= 8; i++) {
			num = (int) (Math.random() * 9)+1;
			u_word = u_word + num;
		}
		return u_word;
	}

}
