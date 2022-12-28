package com.utils;

public class StringUtil {
	/**
	 * Éú³Éid
	 * @return
	 */
	public static Integer getID(){
		String u_word = "";
		int num = 0;
		for(int i = 0; i < 6; i++) {
			num = (int)(Math.random()*9)+1;
			u_word = u_word + num;
		}
		return Integer.valueOf(u_word);
	}

	public static boolean isNullAndEmpty(String str) {
		if("".equals(str) || str == null) {
			return true;
		}else {
			return false;
		}
	}


}
