package com.lprclient.main;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.lprclient.core.view.frame.LoginFrame;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月19日 下午2:23:08  
 * @version V1.0    
 */
public class LPRClient {
	
	public static void main(String[] args) {
		// 设置统一字体
		Font font = new Font("宋体", Font.PLAIN, 12);
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys();
		     keys.hasMoreElements(); ) {
		  Object key = keys.nextElement();
		  Object value = UIManager.get(key);
		  if (value instanceof FontUIResource) {
		    UIManager.put(key, fontRes);
		  }
		}
		LoginFrame loginFrame = LoginFrame.getInstance();
		loginFrame.setVisible(true);
	}

}
