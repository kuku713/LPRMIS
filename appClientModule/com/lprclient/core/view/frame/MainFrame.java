package com.lprclient.core.view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.view.panel.FootPanel;
import com.lprclient.core.view.panel.HeadPanel;
import com.lprclient.core.view.panel.LeftPanel;
import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:28:26  
 * @version V1.0    
 */
public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static MainFrame instance = new MainFrame();
	private HeadPanel head = HeadPanel.getInstance();
	private LeftPanel left = LeftPanel.getInstance();
	private RightPanel right = RightPanel.getInstance();
	private FootPanel foot = FootPanel.getInstance();
	
	public static MainFrame getInstance() {
		return instance;
	}
	
	private MainFrame() {
		super();
		this.setSize(LPRConstant.MAIN_FRAME_SIZE_WIDTH, LPRConstant.MAIN_FRAME_SIZE_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭按钮
		this.setResizable(false);  // 禁止最大化
	}
	
	public void init() {
		head.init();
		left.init();
		this.add(head, null);
		this.add(left, null);
		this.add(right, null);
		this.add(foot, null);
	}
	
	public void showTimer() {
		Timer timerAction = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HeadPanel.getInstance().getTimerLab().setText(DateUtil.getCurrentTime());
			}
		});
		timerAction.start();
	}

}
