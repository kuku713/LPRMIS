package com.lprclient.core.view.panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:40:39  
 * @version V1.0    
 */
public class RightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static RightPanel instance = new RightPanel();
	
	public static RightPanel getInstance() {
		return instance;
	}
	
	private RightPanel() {
		super();
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder()); // 设置边框
		this.setBounds(LPRConstant.MAIN_FRAME_RIGHT_PANEL_X, LPRConstant.MAIN_FRAME_RIGHT_PANEL_Y, 
				LPRConstant.MAIN_FRAME_RIGHT_PANEL_WIDTH, LPRConstant.MAIN_FRAME_RIGHT_PANEL_HEIGHT);
		JButton jb1 = new JButton("11111");
		JButton jb2 = new JButton("22222");
		JButton jb3 = new JButton("33333");
		jb1.setBounds(0, 0, 80, 20);
		jb2.setBounds(0, 20, 80, 20);
		jb3.setBounds(0, 40, 80, 20);
		this.add(jb1, null);
		this.add(jb2, null);
		this.add(jb3, null);
	}

}
