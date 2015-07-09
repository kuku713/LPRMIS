package com.lprclient.core.view.frame;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.view.label.InputLabel;
import com.lprclient.core.view.label.NeedLabel;
import com.lprclient.core.view.text.InputText;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月8日 下午11:16:34  
 * @version V1.0    
 */
public class RegistFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static RegistFrame instance = new RegistFrame();
	private JLabel userNameLab = new InputLabel("用户名");
	private JLabel nickNameLab = new InputLabel("昵称");
	private JLabel passwordLab = new InputLabel("密码");
	private JLabel pwdRetypeLab = new InputLabel("确认密码");
	private JTextField userName = new InputText();
	private JPasswordField password;
	private JPasswordField pwdRetype;
	private JTextField nickName;
	private JButton submitButton;
	private JLabel userNameAlert = new NeedLabel();
	private JLabel passwordAlert = new NeedLabel();
	private JLabel pwdRetypeAlert = new NeedLabel();
	private JLabel nickNameAlert = new NeedLabel();
	
	public static RegistFrame getInstance() {
		return instance;
	}
	
	private RegistFrame() {
		super();
		this.setSize(LPRConstant.REGIST_FRAME_SIZE_WIDTH, 
				LPRConstant.REGIST_FRAME_SIZE_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭按钮
		this.setResizable(false);  // 禁止最大化
	}
	
	public void init() {
		this.getContentPane().setLayout(null);
		this.add(getRegistLab());
	}
	
	private JLabel getRegistLab() {
		JLabel registLab = new JLabel("注册");
		registLab.setBounds(100, 20, 200, LPRConstant.REGIST_FRAME_LABEL_HEIGHT);
		registLab.setHorizontalAlignment(JLabel.CENTER);
		Font f = new Font(null, ABORT, 20);
		registLab.setFont(f);
		return registLab;
	}
	
//	private JPanel getMainPanel() {
//		JPanel mainPanel = new JPanel();
//		GridLayout gridLayout = new GridLayout(4, 3);
//		mainPanel.setLayout(gridLayout);
//		
//		
//	}

}
