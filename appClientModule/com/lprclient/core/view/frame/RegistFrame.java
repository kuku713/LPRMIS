package com.lprclient.core.view.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.DTO.admin.UserRoleRelDTO;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.IUserRoleRelSV;
import com.lprclient.core.service.IUserSV;
import com.lprclient.core.service.impl.RoleSVImpl;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.service.impl.UserRoleRelSVImpl;
import com.lprclient.core.service.impl.UserSVImpl;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.util.StringUtil;
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
	private JPasswordField password = new JPasswordField();
	private JPasswordField pwdRetype = new JPasswordField();
	private JTextField nickName = new InputText();
	private JButton submitButton;
	private JButton backButton;
	private JLabel userNameAlert = new NeedLabel();
	private JLabel passwordAlert = new NeedLabel();
	private JLabel pwdRetypeAlert = new NeedLabel();
	private JLabel nickNameAlert = new NeedLabel();
	private boolean userNameFlag = false;
	private boolean passwordFlag = false;
	private boolean nickNameFlag = false;
	private boolean pwdRetypeFlag = false;
	private IUserSV userSV = new UserSVImpl();
	private IRoleSV roleSV = new RoleSVImpl();
	private IUserRoleRelSV userRoleSV = new UserRoleRelSVImpl();
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	
	public static RegistFrame getInstance() {
		return instance;
	}
	
	private RegistFrame() {
		super();
		this.setSize(LPRConstant.REGIST_FRAME_SIZE_WIDTH, 
				LPRConstant.REGIST_FRAME_SIZE_HEIGHT);
		this.getContentPane().setLayout(null);
		this.add(getRegistLab());
		this.add(getMainPanel());
		this.add(getBackBtn());
		this.add(getSubmitBtn());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭按钮
		this.setResizable(false);  // 禁止最大化
	}
	
	private JLabel getRegistLab() {
		JLabel registLab = new JLabel("注册");
		registLab.setBounds(100, 20, 200, LPRConstant.REGIST_FRAME_LABEL_HEIGHT);
		registLab.setHorizontalAlignment(JLabel.CENTER);
		Font f = new Font(null, ABORT, 20);
		registLab.setFont(f);
		return registLab;
	}
	
	private JPanel getMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(LPRConstant.REGIST_PANEL_BEGIN_X, LPRConstant.REGIST_PANEL_BEGIN_Y, 
				LPRConstant.REGIST_PANEL_WIDTH, LPRConstant.REGIST_PANEL_HEIGHT);
		GridLayout gridLayout = new GridLayout(4, 3, 5, 10);
		mainPanel.setLayout(gridLayout);
		
		mainPanel.add(userNameLab);
		mainPanel.add(userName);
		mainPanel.add(userNameAlert);
		userName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String userNameStr = userName.getText();
				if (StringUtil.isBlank(userNameStr)) {
					userNameAlert.setText("×请输入用户名");
					userNameAlert.setForeground(Color.RED);
					userNameFlag = false;
					return;
				}
				if (userNameStr.length() < 2) {
					userNameAlert.setText("×长度至少为2位");
					userNameAlert.setForeground(Color.RED);
					userNameFlag = false;
					return;
				}
				long users = userSV.queryCountByUserName(userName.getText());
				if (users != 0) {
					userNameAlert.setText("×该用户名已注册");
					userNameAlert.setForeground(Color.RED);
					userNameFlag = false;
					return;
				}
				userNameAlert.setText("√");
				userNameAlert.setForeground(Color.GREEN);
				userNameFlag = true;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mainPanel.add(nickNameLab);
		mainPanel.add(nickName);
		mainPanel.add(nickNameAlert);
		nickName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String nickNameStr = nickName.getText();
				if (StringUtil.isBlank(nickNameStr)) {
					nickNameAlert.setText("×请输入昵称");
					nickNameAlert.setForeground(Color.RED);
					nickNameFlag = false;
					return;
				}
				if (nickNameStr.length() < 2) {
					nickNameAlert.setText("×长度至少为2位");
					nickNameAlert.setForeground(Color.RED);
					nickNameFlag = false;
					return;
				}
				nickNameAlert.setText("√");
				nickNameAlert.setForeground(Color.GREEN);
				nickNameFlag = true;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mainPanel.add(passwordLab);
		mainPanel.add(password);
		mainPanel.add(passwordAlert);
		password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String passwordStr = String.valueOf(password.getPassword());
				System.out.println(passwordStr);
				if (StringUtil.isBlank(passwordStr)) {
					passwordAlert.setText("×请输入密码");
					passwordAlert.setForeground(Color.RED);
					passwordFlag = false;
					return;
				}
				if (passwordStr.length() < 6) {
					passwordAlert.setText("×长度至少为6位");
					passwordAlert.setForeground(Color.RED);
					passwordFlag = false;
					return;
				}
				passwordAlert.setText("√");
				passwordAlert.setForeground(Color.GREEN);
				passwordFlag = true;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mainPanel.add(pwdRetypeLab);
		mainPanel.add(pwdRetype);
		mainPanel.add(pwdRetypeAlert);
		pwdRetype.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String pwdRetypeStr = String.valueOf(pwdRetype.getPassword());
				String passwordStr = String.valueOf(password.getPassword());
				if (StringUtil.isBlank(pwdRetypeStr)) {
					pwdRetypeAlert.setText("×请输入确认密码");
					pwdRetypeAlert.setForeground(Color.RED);
					pwdRetypeFlag = false;
					return;
				}
				if (!pwdRetypeStr.equals(passwordStr)) {
					pwdRetypeAlert.setText("×两次密码输入不一致");
					pwdRetypeAlert.setForeground(Color.RED);
					pwdRetypeFlag = false;
					return;
				}
				pwdRetypeAlert.setText("√");
				pwdRetypeAlert.setForeground(Color.GREEN);
				pwdRetypeFlag = true;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return mainPanel;
	}
	
	private JButton getBackBtn() {
		backButton = new JButton("返回");
		backButton.setBounds(LPRConstant.REGIST_PANEL_BUTTON_BEGIN_X, LPRConstant.REGIST_PANEL_BUTTON_BEGIN_Y, 
				LPRConstant.REGIST_PANEL_BUTTON_WIDTH, LPRConstant.REGIST_PANEL_BUTTON_HEIGHT);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = getInstance().getLocation().x;
				int y = getInstance().getLocation().y;
				System.out.println(x + "," + y);
				LoginFrame loginFrame = LoginFrame.getInstance();
				loginFrame.setVisible(true);
				RegistFrame registFrame = RegistFrame.getInstance();
				registFrame.dispose();
			}
		});
		
		return backButton;
	}
	
	private JButton getSubmitBtn() {
		submitButton = new JButton("确定");
		submitButton.setBounds(LPRConstant.REGIST_PANEL_BUTTON_BEGIN_X + LPRConstant.REGIST_PANEL_BUTTON_WIDTH 
				+ LPRConstant.REGIST_PANEL_BUTTON_INTERVAL, LPRConstant.REGIST_PANEL_BUTTON_BEGIN_Y, 
				LPRConstant.REGIST_PANEL_BUTTON_WIDTH, LPRConstant.REGIST_PANEL_BUTTON_HEIGHT);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!userNameFlag) {
					userName.requestFocus();
					return;
				}
				if (!nickNameFlag) {
					nickName.requestFocus();
					return;
				}
				if (!passwordFlag) {
					password.requestFocus();
					return;
				}
				if (!pwdRetypeFlag) {
					pwdRetype.requestFocus();
					return;
				}
				// 保存用户信息
				UserDTO userDTO = new UserDTO();
				userDTO.setUserName(userName.getText());
				userDTO.setNickName(nickName.getText());
				userDTO.setPassword(String.valueOf(password.getPassword()));
				userDTO.setStatus(LPRConstant.ADMIN_USER_STATUS_NORMAL);
				userDTO.setCreateDate(new Date());
				userDTO.setLoginTimes(0);
				userSV.saveOrUpdate(userDTO);
				
				userDTO = userSV.login(userName.getText(), String.valueOf(password.getPassword()));
				
				// 保存用户角色信息
				UserRoleRelDTO relDTO = new UserRoleRelDTO();
				relDTO.setStatus(LPRConstant.ADMIN_USER_ROLE_STATUS_NORMAL);
				relDTO.setCreateDate(new Date());
				relDTO.setRoleId(LPRConstant.ADMIN_USER_ROLE_DEFAULT_ID);
				relDTO.setUserId(userDTO.getUserId());
				userRoleSV.saveOrUpdate(relDTO);
				
				// 校验成功，更新静态变量
				RoleDTO roleDTO = roleSV.queryByUserId(userDTO.getUserId());
				userDTO.setRoleDTO(roleDTO);
				LPRUtil.setIsLogin(LPRConstant.ISLOGIN_YES);
				LPRUtil.setUserName(userDTO.getUserName());
				LPRUtil.setAdminUser(userDTO);
				// 更新用户数据
				int count = userDTO.getLoginTimes();
				count++;
				userDTO.setLoginTimes(count);
				userDTO.setLastLoginDate(new Date());
				userSV.saveOrUpdate(userDTO);
				
				// 保存用户注册信息
				UserOperateDTO userOperateDTO = new UserOperateDTO(userDTO, 
						LPRConstant.ACTION_TYPE_REGIST, LPRConstant.ACTION_SUCCESS);
				operateSV.saveOrUpdate(userOperateDTO);
				
				// 保存用户登录信息
				userOperateDTO = new UserOperateDTO(userDTO, 
						LPRConstant.ACTION_TYPE_LOGIN, LPRConstant.ACTION_SUCCESS);
				operateSV.saveOrUpdate(userOperateDTO);
				
				// 页面跳转
				MainFrame mainFrame = MainFrame.getInstance();
				mainFrame.init();
				mainFrame.setVisible(true);
				mainFrame.showTimer();
				RegistFrame registFrame = RegistFrame.getInstance();
				registFrame.dispose();
			}
		});
		return submitButton;
	}
	
}
