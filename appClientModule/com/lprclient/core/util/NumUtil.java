package com.lprclient.core.util;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月4日 下午6:22:45  
 * @version V1.0    
 */
public class NumUtil {
	
	public static boolean intToBool(Integer i) {
		if (null != i
				&& i == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int boolToInt(Boolean bool) {
		if (null != bool
				&& bool.equals(new Boolean(true))) {
			System.out.println(1);
			return 1;
		} else {
			System.out.println(0);
			return 0;
		}
	}
	
	public static int boolToInt(Object obj) {
		if ((Boolean) obj == true){
			return 1;
		}
		return 0;
	}

	public static int length(long l) {
		int length = 1;
		while(l/10 > 0) {
			length++;
			l/=10;
		}
		return length;
	}
	
	public static boolean isNum(String str) {
		try {
			str = str.trim();
			Long.parseLong(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isNotNum(String str) {
		if (isNum(str)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(boolToInt(false));
		System.out.println(boolToInt(true));
		System.out.println(intToBool(111));
	}
	
}
