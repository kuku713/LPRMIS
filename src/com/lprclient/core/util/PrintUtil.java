package com.lprclient.core.util;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月2日 上午1:06:44  
 * @version V1.0    
 */
public class PrintUtil {
	
	public static void print(Object[][] obj) {
		if (null != obj) {
			for (int i=0; i<obj.length; i++) {
				for (int j=0; j<obj[i].length; j++) {
					System.out.print(obj[i][j] + "|");
				}
				System.out.println();
			}
		}
	}
	
	public static void print(Object[] obj) {
		if (null != obj) {
			for (int i=0; i<obj.length; i++) {
				System.out.println(obj[i]);
			}
		}
	}

}
