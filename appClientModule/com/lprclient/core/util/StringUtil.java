package com.lprclient.core.util;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午9:44:08  
 * @version V1.0    
 */
public class StringUtil {
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (null == str) {
			return true;
		} else if (str.length() == 0) {
			return true;
		} else if (str.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		if (isBlank(str)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 判断字符数组是否为空
	 * 
	 * @param chs
	 * @return
	 */
	public static boolean isBlank(char[] chs) {
		if (null == chs) {
			return true;
		} else if (chs.length == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符数组是否不为空
	 * 
	 * @param chs
	 * @return
	 */
	public static boolean isNotBlank(char[] chs) {
		if (isBlank(chs)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void doStr(String str) {
		str = str + "aaa";
	}
	
	public static void main(String[] args) {
		char[] ch = null;
		char[] ch1 = new char[0];
		System.out.println(isBlank(ch));
		System.out.println(isBlank(ch1));
	}

}
