package com.lprclient.core.view.label;

import java.awt.Dimension;

import javax.swing.JLabel;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月7日 下午10:29:48  
 * @version V1.0    
 */
public class DisplayLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	public DisplayLabel(String title) {
		super(LPRConstant.BLANK + title);
		super.setHorizontalAlignment(JLabel.LEFT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_LABEL_WIDTH,
				LPRConstant.SUB_LABEL_HEIGHT));
	}
	
	public DisplayLabel(Integer i) {
		super(LPRConstant.BLANK + String.valueOf(i));
		super.setHorizontalAlignment(JLabel.LEFT);
		super.setPreferredSize(new Dimension(LPRConstant.SUB_LABEL_WIDTH,
				LPRConstant.SUB_LABEL_HEIGHT));
	}

}
