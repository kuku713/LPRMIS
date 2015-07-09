package com.lprclient.core.view.panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.view.label.UserLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:46:22  
 * @version V1.0    
 */
public class HeadPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static HeadPanel instance = new HeadPanel();
	private JPanel timerPanel;
	private JPanel userPanel;
	private JPanel logoutPanel;
	private JLabel timerDes = new JLabel("当前时间:");
	private JLabel timerLab = new JLabel(DateUtil.getCurrentTime());
	
	public static HeadPanel getInstance() {
		return instance;
	}
	
	private HeadPanel() {
		super();
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder()); // 设置边框
		this.setBounds(LPRConstant.MAIN_FRAME_HEAD_PANEL_X, LPRConstant.MAIN_FRAME_HEAD_PANEL_Y, 
				LPRConstant.MAIN_FRAME_HEAD_PANEL_WIDTH, LPRConstant.MAIN_FRAME_HEAD_PANEL_HEIGHT);
	}
	
	public void init() {
		this.add(getTimerPanel(), null);
		this.add(getUserPanel(), null);
		this.add(getLogoutPanel(), null);
	}
	
	private JPanel getTimerPanel() {
		if (null == timerPanel) {
			timerPanel = new JPanel();
			timerPanel.add(timerDes);
			timerPanel.add(timerLab);
			timerPanel.setBounds(LPRConstant.HEAD_PANEL_TIMER_BEGIN_X, LPRConstant.HEAD_PANEL_TIMER_BEGIN_Y, 
					LPRConstant.HEAD_PANEL_TIMER_WIDTH, LPRConstant.HEAD_PANEL_TIMER_HEIGHT);
		}
		return timerPanel;
	}
	
	private JPanel getUserPanel() {
		userPanel = new JPanel();
		userPanel.setBounds(LPRConstant.HEAD_PANEL_USER_BEGIN_X, LPRConstant.HEAD_PANEL_USER_BEGIN_Y, 
				LPRConstant.HEAD_PANEL_USER_WIDTH, LPRConstant.HEAD_PANEL_USER_HEIGHT);
		UserDTO userDTO = LPRUtil.getAdminUser();
		JLabel roleName = new JLabel(userDTO.getRoleDTO().getRoleName() + ":");
		JLabel nickName = new UserLabel(userDTO.getNickName(), "com.lprclient.core.action.UserInfoAction");
		JLabel welDesc = new JLabel(",你好!");
		userPanel.removeAll();
		userPanel.add(roleName, null);
		userPanel.add(nickName, null);
		userPanel.add(welDesc, null);
		return userPanel;
	}
	
	private JPanel getLogoutPanel() {
		logoutPanel = new JPanel();
		logoutPanel.setBounds(LPRConstant.HEAD_PANEL_LOGOUT_BEGIN_X, LPRConstant.HEAD_PANEL_LOGOUT_BEGIN_Y, 
				LPRConstant.HEAD_PANEL_LOGOUT_WIDTH, LPRConstant.HEAD_PANEL_LOGOUT_HEIGHT);
		UserLabel logout = new UserLabel("退出", "com.lprclient.core.action.LogoutAction");
		logoutPanel.add(logout, null);
		return logoutPanel;
	}
	
	public JLabel getTimerLab() {
		return timerLab;
	}

}
