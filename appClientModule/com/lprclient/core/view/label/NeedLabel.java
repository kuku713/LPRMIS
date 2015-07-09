package com.lprclient.core.view.label;

import java.awt.Color;

import javax.swing.JLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月5日 下午10:47:21  
 * @version V1.0    
 */
public class NeedLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public NeedLabel() {
		super("*");
		super.setForeground(Color.RED);
	}
	
	public NeedLabel(String str) {
		super(str);
		super.setForeground(Color.RED);
	}
	
	public void setText(String str) {
		super.setText("*" + str);
		super.setForeground(Color.RED);
	}

}
