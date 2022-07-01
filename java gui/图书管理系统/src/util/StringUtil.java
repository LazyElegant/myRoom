package util;

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
	public static Integer getID() {
		String u_word = "";
		int num = 0;
		for (int i = 0; i < 6; i++) {
			num = (int) (Math.random() * 10);
			u_word = u_word + num;
		}
		return Integer.valueOf(u_word);
	}

}
