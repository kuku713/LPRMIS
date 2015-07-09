package com.lprclient.core.view.text;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月5日 下午7:22:23  
 * @version V1.0    
 */
public class InputText extends JTextField {

	private static final long serialVersionUID = 1L;
	
	public InputText() {
		super();
		super.setHorizontalAlignment(JLabel.LEFT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_INPUT_WIDTH, 
				LPRConstant.SUB_INPUT_HEIGHT));
	}
	
	public InputText(String str) {
		super(str);
		super.setHorizontalAlignment(JLabel.LEFT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_INPUT_WIDTH, 
				LPRConstant.SUB_INPUT_HEIGHT));
	}
	
	public InputText(Integer i) {
		super(i);
		super.setHorizontalAlignment(JLabel.LEFT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_INPUT_WIDTH, 
				LPRConstant.SUB_INPUT_HEIGHT));
	}

}
