package com.lprclient.core.view.panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:46:47  
 * @version V1.0    
 */
public class FootPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static FootPanel instance = new FootPanel();
	
	public static FootPanel getInstance() {
		return instance;
	}
	
	private FootPanel() {
		super();
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder()); // 设置边框
		this.setBounds(LPRConstant.MAIN_FRAME_FOOT_PANEL_X, LPRConstant.MAIN_FRAME_FOOT_PANEL_Y,
				LPRConstant.MAIN_FRAME_FOOT_PANEL_WIDTH, LPRConstant.MAIN_FRAME_FOOT_PANEL_HEIGHT);
		this.add(getCopyrightLab(), null);
	}
	
	private JLabel getCopyrightLab() {
		JLabel copyrightLab = new JLabel();
		copyrightLab.setText(LPRConstant.COPYRIGHT_DESC);
		copyrightLab.setBounds(LPRConstant.FOOT_PANEL_COPY_BEGIN_X, LPRConstant.FOOT_PANEL_COPY_BEGIN_Y, 
				LPRConstant.FOOT_PANEL_COPY_WIDTH, LPRConstant.FOOT_PANEL_COPY_HEIGHT);
		return copyrightLab;
	}

}
