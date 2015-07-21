package com.lprclient.core.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.PropertyUtil;
import com.lprclient.core.util.StringUtil;
import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月14日 下午7:49:21  
 * @version V1.0    
 */
public class ExternalClientAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(ExternalClientAction.class);
	private static Process process = null;
	private JTextField labPath;
	private PropertyUtil propUtil = new PropertyUtil(LPRConstant.PROPERTY_FILE_NAME, true);
	
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
		right.add(getLabPathLab());
		right.add(getLabPath());
		right.add(getSelectBtn());
		right.add(getStartBtn());
		right.add(getStopBtn());
		right.repaint();
	}
	
	private JLabel getLabPathLab() {
		JLabel labPathLab = new JLabel("请选择lab文件路径:");
		labPathLab.setBounds(250, 200, 120, 20);
		return labPathLab;
	}
	
	private JTextField getLabPath() {
		labPath = new JTextField();
		labPath.setBounds(360, 200, 180, 20);
		labPath.setEditable(false);
		if (StringUtil.isNotBlank(propUtil.getValue(
				LPRConstant.PROPERTY_ATTR_LABPATH))) {
			labPath.setText(propUtil.getValue(
				LPRConstant.PROPERTY_ATTR_LABPATH));
		}
		return labPath;
	}
	
	private JButton getSelectBtn() {
		JButton selectBtn = new JButton("选择");
		selectBtn.setBounds(550, 200, 80, 20);
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
		        jfc.showDialog(new JLabel(), "选择"); 
		        File file = jfc.getSelectedFile();
		        if (null != file && file.isFile()) {
		        		labPath.setText(file.getAbsolutePath());
		        		labPath.setEditable(false);
		        }
			}
		});
		return selectBtn;
	}

	private JButton getStartBtn() {
		JButton startBtn = new JButton("启动");
		startBtn.setBounds(350, 250, 80, 20);
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (StringUtil.isBlank(labPath.getText())) {
					JOptionPane.showMessageDialog(null, "请选择正确的路径",
							"错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					String path = labPath.getText();
					process = Runtime.getRuntime().exec(path, null, new File(path.replace("\\load.exe", "")));
					if (null != process) {
						propUtil.setValue(LPRConstant.PROPERTY_ATTR_LABPATH, path);
						propUtil.saveFile(LPRConstant.PROPERTY_FILE_NAME, "SAVE LABPATH");
					}
					log.error("============车牌识别程序成功启动");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "请选择正确的路径",
							"错误",JOptionPane.ERROR_MESSAGE);
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
					process = null;
					log.error("============车牌识别程序成功关闭");
				}
			}
		});
		return stopBtn;
	}

}
