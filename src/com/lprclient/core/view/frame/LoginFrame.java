package com.lprclient.core.view.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.action.LoginAction;
import com.lprclient.core.view.label.URLLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月19日 下午4:42:02  
 * @version V1.0    
 */
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static LoginFrame instance = new LoginFrame();
	private JLabel loginLab;            // 登录
	private JLabel alertLab;            // 提醒
	private JLabel userNameLab;         // 用户名
	private JLabel passwordLab;         // 密码
	private URLLabel forgotPSW;         // 忘记密码
	private URLLabel regist;            // 注册
	private JTextField userName;        // 用户名输入框    
	private JPasswordField password;    // 密码输入框
	private JButton loginButton;        // 登录按钮
	
	public static LoginFrame getInstance() {
		return instance;
	}
	
	private LoginFrame() {
		super();
		this.setSize(LPRConstant.LOGIN_FRAME_SIZE_WIDTH, LPRConstant.LOGIN_FRAME_SIZE_HEIGHT);
		this.getContentPane().setLayout(null);
		this.add(getLoginLab(), null);
		this.add(getAlertLab(), null);
		this.add(getUserNameLab(), null);
		this.add(getPasswordLab(), null);
		this.add(getUserName(), null);
		this.add(getPassword(), null);
//		this.add(getForgotPSW(), null);
		this.add(getRegist(), null);
		this.add(getLoginButton(), null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭按钮
		this.setResizable(false);  // 禁止最大化
	}
	
	public JLabel getLoginLab() {
		if (null == loginLab) {
			loginLab = new JLabel();
			loginLab.setBounds(100, 20, 200, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			loginLab.setText("请登录");
			loginLab.setHorizontalAlignment(JLabel.CENTER);
			Font f = new Font(null, ABORT, 20);
			loginLab.setFont(f);
		}
		return loginLab;
	}
	
	public JLabel getAlertLab() {
		if (null == alertLab) {
			alertLab = new JLabel();
			alertLab.setBounds(100, 50, 200, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			alertLab.setText("");
			alertLab.setHorizontalAlignment(JLabel.CENTER);
			alertLab.setForeground(Color.RED);
		}
		return alertLab;
	}
	
	public JLabel getUserNameLab() {
		if (null == userNameLab) {
			userNameLab = new JLabel();
			userNameLab.setBounds(60, 80, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			userNameLab.setText("用户名：");
			userNameLab.setHorizontalAlignment(JLabel.RIGHT);
		}
		return userNameLab;
	}
	
	public JLabel getPasswordLab() {
		if (null == passwordLab) {
			passwordLab = new JLabel();
			passwordLab.setBounds(60, 120, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			passwordLab.setText("密码：");
			passwordLab.setHorizontalAlignment(JLabel.RIGHT);
		}
		return passwordLab;
	}
	
	public JTextField getUserName() {
		if (null == userName) {
			userName = new JTextField();
			userName.setBounds(200, 80, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
		}
		return userName;
	}
	
	public JPasswordField getPassword() {
		if (null == password) {
			password = new JPasswordField();
			password.setBounds(200, 120, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
		}
		return password;
	}
	
	public URLLabel getRegist() {
		if (null == regist) {
			regist = new URLLabel("注册", "注册");
			regist.setBounds(50, 160, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			regist.setHorizontalAlignment(JLabel.RIGHT);
			regist.setActionType(LPRConstant.ACTION_TYPE_REGIST);
		}
		return regist;
	}
	
	public URLLabel getForgotPSW() {
		if (null == forgotPSW) {
			forgotPSW = new URLLabel("忘记密码", "忘记密码");
			forgotPSW.setBounds(210, 160, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			forgotPSW.setHorizontalAlignment(JLabel.LEFT);
			forgotPSW.setActionType(LPRConstant.ACTION_TYPE_FORGOT_PASSWORD);
		}
		return forgotPSW;
	}

	public JButton getLoginButton() {
		if (null == loginButton) {
			loginButton = new JButton();
			loginButton.setText("登录");
			loginButton.setBounds(150, 200, LPRConstant.LOGIN_FRAME_LABEL_WIDTH, LPRConstant.LOGIN_FRAME_LABEL_HEIGHT);
			loginButton.addActionListener(new LoginAction());
		}
		return loginButton;
	}

}
