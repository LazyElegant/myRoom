package yfj.util;

/**
 * 字符串判断工具类
 * @author Administrator
 *
 */
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
	 * 判断字符串是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if( (str != null) && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}
