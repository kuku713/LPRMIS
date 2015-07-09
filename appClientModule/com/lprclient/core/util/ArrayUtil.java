package com.lprclient.core.util;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午10:43:37  
 * @version V1.0    
 */
public class ArrayUtil {
	
	/**
	 * 增加尾后的新数组
	 * @param strs
	 * @param str
	 * @return
	 */
	public static String[] newArrAddFoot(String[] strs, String str) {
		int length = 0;
		if (null != strs) {
			length = strs.length;
		}
		String[] result = new String[length+1];
		System.arraycopy(strs, 0, result, 0, length);
		result[length] = str;
		return result;
	}
	
	/**
	 * 去掉尾后的新数组
	 * @param strs
	 * @return
	 */
	public static String[] newArrRedFoot(String[] strs) {
		int length = 0;
		if (null != strs) {
			length = strs.length;
		}
		length--;
		String[] result = new String[length];
		System.arraycopy(strs, 0, result, 0, length);
		return result;
	}
	
	/**
	 * 增加头后的新数组
	 * [0] = str
	 * @param str
	 * @param strs
	 * @return
	 */
	public static String[] newArrAddHead(String str, String[] strs) {
		int length = 1;
		if (null != strs) {
			length = length + strs.length;
		}
		String[] result = new String[length];
		result[0] = str;
		System.arraycopy(strs, 0, result, 1, length-1);
		return result;
	}
	
	/**
	 * 去掉头后的新数组
	 * @param strs
	 * @return
	 */
	public static String[] newArrRedHead(String[] strs) {
		String[] result = null;
		if (null != strs) {
			result = new String[strs.length-1];
			System.arraycopy(strs, 1, result, 0, strs.length-1);
		}
		return result;
	}
	
	/**
	 * 二维数组增加第一列
	 * @param obj
	 * @return
	 */
	public static Object[] getFirstColumn(Object[][] obj) {
		int rowCount = 0;
		if (null != obj
				&& obj.length > 0) {
			rowCount = obj.length;
		}
		Object[] result = new Object[rowCount];
		for (int i=0; i<rowCount; i++) {
			result[i] = obj[i][0];
		}
		return result;
	}
	
	/**
	 * 二维数组去掉第一列
	 * @param obj
	 * @return
	 */
	public static Object[][] redColumn(Object[][] obj) {
		int rowCount = 0;
		int colCount = 0;
		if (null != obj
				&& obj.length > 0) {
			rowCount = obj.length;
			colCount = obj[0].length;
		}
		colCount--;
		colCount = colCount<0?0:colCount;
		Object[][] result = new Object[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				result[i][j] = obj[i][j+1];
			}
		}
		return result;
	}
	
	/**
	 * 增加列名
	 * @param arr
	 * @return
	 */
	public static String[] addColumnName(String[] arr) {
		int arrCount = 0;
		if (null != arr
				&& arr.length > 0) {
			arrCount = arr.length;
		}
		arrCount++;
		String[] result = new String[arrCount];
		result[0] = "请选择";
		for (int i=1; i<arrCount; i++) {
			result[i] = arr[i-1];
		}
		return result;
	}
	
	/**
	 * 二维数组增加第一列布尔值
	 * @param obj
	 * @return
	 */
	public static Object[][] addColumnData(Object[][] obj) {
		int rowCount = 0;
		int colCount = 0;
		if (null != obj
				&& obj.length > 0) {
			rowCount = obj.length;
			colCount = obj[0].length;
		}
		colCount++;
		Object[][] result = new Object[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				if (j==0) {
					// 第一列加入Boolean类型的值
					result[i][j] = new Boolean(false);
				} else {
					result[i][j] = obj[i][j-1];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] s = new String[]{"1", "2", "4", "8"};
		String[] sn = newArrRedHead(s);
		for (String s2 : sn) {
			System.out.println(s2);
		}
	}

}
