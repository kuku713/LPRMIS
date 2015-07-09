package com.lprclient.core.view.label;

import java.awt.Dimension;

import javax.swing.JLabel;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月5日 下午7:16:31  
 * @version V1.0    
 */
public class InputLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public InputLabel(String title) {
		super(title);
		super.setHorizontalAlignment(JLabel.RIGHT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_LABEL_WIDTH,
				LPRConstant.SUB_LABEL_HEIGHT));
	}

}
