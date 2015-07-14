package com.lprclient.core.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月14日 下午7:49:21  
 * @version V1.0    
 */
public class ExternalClientAction extends BaseAction {
	
	/**
	 * 目录点击后跳转
	 */
	public void onClick(String[] navArr) {
		System.out.println("This is UserAction.");
		this.setNavArr(navArr);
		repaint();
	}
	
	/**
	 * 刷新页面
	 */
	private void repaint() {
		RightPanel right = RightPanel.getInstance();
		right.removeAll();
		right.add(getNavLabel());
		right.add(getStartBtn());
		right.repaint();
	}
	
	private JButton getStartBtn() {
		JButton startBtn = new JButton("启动");
		startBtn.setBounds(350, 250, 80, 20);
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(1111);
			}
		});
		return startBtn;
	}

}
