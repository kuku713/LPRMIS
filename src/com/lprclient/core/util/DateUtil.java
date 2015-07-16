package com.lprclient.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午9:39:59  
 * @version V1.0    
 */
public class DateUtil {
	
	private static final String LONG_DATE = "yyyy-MM-dd HH:mm:ss";
	private static final String SHORT_DATE = "yyyy-MM-dd";
	private static final String SHORT_TIME = "HH:mm:ss";

	public static String getCurrentTime() {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat(LONG_DATE);
		return df.format(currentTime);
	}
	
	public static String getCurrentShortDate() {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat(SHORT_DATE);
		return df.format(currentTime);
	}
	
	public static String getCurrentShortTime() {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat(SHORT_TIME);
		return df.format(currentTime);
	}
	
	public static String formatDateLong(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(LONG_DATE);
		if (null == date) {
			return LPRConstant.NA;
		}
		return df.format(date);
	}
	
}
