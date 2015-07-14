package com.lprclient.core.view.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.service.IUserSV;
import com.lprclient.core.service.impl.UserSVImpl;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.view.label.DisplayLabel;
import com.lprclient.core.view.label.InputLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:40:39  
 * @version V1.0    
 */
public class RightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static RightPanel instance = new RightPanel();
	private JPanel userInfo;
	private JTextField nickNameModify;
	private JPasswordField passwordModify;
	private static final int MODIFY_NICKNAME = 3;
	private static final int MODIFY_PASSWORD = 4;
	private IUserSV userSV = new UserSVImpl();
	
	public static RightPanel getInstance() {
		return instance;
	}
	
	private RightPanel() {
		super();
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder()); // 设置边框
		this.setBounds(LPRConstant.MAIN_FRAME_RIGHT_PANEL_X, LPRConstant.MAIN_FRAME_RIGHT_PANEL_Y, 
				LPRConstant.MAIN_FRAME_RIGHT_PANEL_WIDTH, LPRConstant.MAIN_FRAME_RIGHT_PANEL_HEIGHT);
	}
	
	public void init() {
		this.removeAll();
		this.add(getUserInfo());
	}
	
	private JPanel getUserInfo() {
		userInfo = new JPanel();
		int rowCount = 9;
		int panelHeight = 0;
		GridLayout gridLayout = null;
		gridLayout = new GridLayout(rowCount, 3);
		userInfo.setLayout(gridLayout);
		
		panelHeight = rowCount * LPRConstant.USER_INFO_LABEL_EACH + 35;
		userInfo.setBounds(LPRConstant.USER_INFO_PANEL_BEGIN_X, LPRConstant.USER_INFO_PANEL_BEGIN_Y, 
				LPRConstant.USER_INFO_PANEL_WIDTH, panelHeight);
		
		UserDTO userDTO = LPRUtil.getAdminUser();
		
		JLabel userIdLab = new InputLabel("用户ID");
		JLabel userNameLab = new InputLabel("用户名");
		JLabel nickNameLab = new InputLabel("昵称");
		JLabel passwordLab = new InputLabel("密码");
		JLabel createDateLab = new InputLabel("创建时间");
		JLabel lastLoginDateLab = new InputLabel("最后登录时间");
		JLabel loginTimesLab = new InputLabel("登录次数");
		JLabel statusLab = new InputLabel("用户状态");	
		JLabel roleNameLab = new InputLabel("当前角色");
		
		userInfo.add(userIdLab);
		userInfo.add(new DisplayLabel(userDTO.getUserId()));
		userInfo.add(new JLabel());
		
		userInfo.add(userNameLab);
		userInfo.add(new DisplayLabel(userDTO.getUserName()));
		userInfo.add(new JLabel());
		
		userInfo.add(nickNameLab);
		userInfo.add(new DisplayLabel(userDTO.getNickName()));
		userInfo.add(getCancelPanel(3));
		
		userInfo.add(passwordLab);
		userInfo.add(new DisplayLabel("******"));
		userInfo.add(getCancelPanel(4));
		
		userInfo.add(createDateLab);
		userInfo.add(new DisplayLabel(DateUtil.formatDateLong(userDTO.getCreateDate())));
		userInfo.add(new JLabel());
		
		userInfo.add(lastLoginDateLab);
		userInfo.add(new DisplayLabel(DateUtil.formatDateLong(userDTO.getLastLoginDate())));
		userInfo.add(new JLabel());
		
		userInfo.add(loginTimesLab);
		userInfo.add(new DisplayLabel(String.valueOf(userDTO.getLoginTimes())));
		userInfo.add(new JLabel());
		
		userInfo.add(statusLab);
		userInfo.add(new DisplayLabel(userDTO.getStatusDesc()));
		userInfo.add(new JLabel());
		
		userInfo.add(roleNameLab);
		userInfo.add(new DisplayLabel(userDTO.getRoleDTO().getRoleName()));
		userInfo.add(new JLabel());
		
		userInfo.setBorder(BorderFactory.createTitledBorder("操作员信息"));
		
		return userInfo;
	}
	
	private JPanel getModifyPanel(final int index) {
		final UserDTO userDTO = LPRUtil.getAdminUser();
		JPanel modifyPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(1, 3);
		modifyPanel.setLayout(gridLayout);
		
		JButton submitBtn = new JButton("确定");
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (index) {
				case MODIFY_NICKNAME:
					userInfo.remove(index * 3 - 2);
					userDTO.setNickName(nickNameModify.getText());
					userInfo.add(new DisplayLabel(userDTO.getNickName()), index * 3 - 2);
					break;
				case MODIFY_PASSWORD:
					userInfo.remove(index * 3 - 2);
					userDTO.setPassword(String.valueOf(passwordModify.getPassword()));
					userInfo.add(new DisplayLabel("******"), index * 3 - 2);
					break;
				default:
					break;
				}
				userSV.saveOrUpdate(userDTO);
				LPRUtil.setAdminUser(userDTO);
				userInfo.remove(index * 3 - 1);
				userInfo.add(getCancelPanel(index), index * 3 - 1);
			}
		});
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (index) {
				case MODIFY_NICKNAME:
					userInfo.remove(index * 3 - 2);
					userInfo.add(new DisplayLabel(userDTO.getNickName()), index * 3 - 2);
					break;
				case MODIFY_PASSWORD:
					userInfo.remove(index * 3 - 2);
					userInfo.add(new DisplayLabel("******"), index * 3 - 2);
					break;
				default:
					break;
				}
				userInfo.remove(index * 3 - 1);
				userInfo.add(getCancelPanel(index), index * 3 - 1);
			}
		});
		modifyPanel.add(submitBtn);
		modifyPanel.add(cancelBtn);
		modifyPanel.add(new JLabel());
		return modifyPanel;
	}
	
	private JPanel getCancelPanel(final int index) {
		final UserDTO userDTO = LPRUtil.getAdminUser();
		JPanel cancelPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(1, 3);
		cancelPanel.setLayout(gridLayout);
		JButton submitBtn = new JButton("修改");
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (index) {
				case MODIFY_NICKNAME:
					userInfo.remove(index * 3 - 2);
					nickNameModify = new JTextField(userDTO.getNickName());
					userInfo.add(nickNameModify, index * 3 - 2);
					break;
				case MODIFY_PASSWORD:
					userInfo.remove(index * 3 - 2);
					passwordModify = new JPasswordField();
					userInfo.add(passwordModify, index * 3 - 2);
					break;
				default:
					break;
				}
				userInfo.remove(index * 3 - 1);
				userInfo.add(getModifyPanel(index), index * 3 - 1);
			}
		});
		cancelPanel.add(submitBtn);
		cancelPanel.add(new JLabel());
		cancelPanel.add(new JLabel());
		return cancelPanel;
	}

}
