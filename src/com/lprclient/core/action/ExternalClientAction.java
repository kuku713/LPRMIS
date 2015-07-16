package com.lprclient.core.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月14日 下午7:49:21  
 * @version V1.0    
 */
public class ExternalClientAction extends BaseAction {
	
	private static Process process = null;
	
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
		right.add(getStopBtn());
		right.repaint();
	}
	
	private JButton getStartBtn() {
		JButton startBtn = new JButton("启动");
		startBtn.setBounds(350, 250, 80, 20);
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] strs = System.getProperty("java.class.path").split(";");
					System.out.println(strs[0]);
					String filePath = strs[0] + "\\external\\lab";
					System.out.println(filePath);
					process = Runtime.getRuntime().exec(filePath + "\\load.exe", null, new File(filePath));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return startBtn;
	}
	
	private JButton getStopBtn() {
		JButton stopBtn = new JButton("停止");
		stopBtn.setBounds(450, 250, 80, 20);
		stopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != process) {
					process.destroy();
				}
			}
		});
		return stopBtn;
	}

}
