package com.lprclient.main;

import com.lprclient.core.view.frame.LoginFrame;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月19日 下午2:23:08  
 * @version V1.0    
 */
public class LPRClient {
	
	public static void main(String[] args) {
		LoginFrame loginFrame = LoginFrame.getInstance();
		loginFrame.setVisible(true);
	}

}
