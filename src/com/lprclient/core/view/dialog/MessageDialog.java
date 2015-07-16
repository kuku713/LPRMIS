package com.lprclient.core.view.dialog;

import javax.swing.JDialog;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月6日 上午1:27:32  
 * @version V1.0    
 */
public class MessageDialog extends JDialog implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public MessageDialog() {
		super();
		super.setTitle("1111");
		super.setVisible(true);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
			super.dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MessageDialog s = new MessageDialog();
		s.run();
	}

}
