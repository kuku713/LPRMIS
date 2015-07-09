package com.lprclient.core.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.ContentDTO;
import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.DTO.admin.RolePermRelDTO;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.service.IContentSV;
import com.lprclient.core.service.IRolePermRelSV;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.IUserSV;
import com.lprclient.core.service.impl.ContentSVImpl;
import com.lprclient.core.service.impl.RolePermRelSVImpl;
import com.lprclient.core.service.impl.RoleSVImpl;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.service.impl.UserSVImpl;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.util.StringUtil;
import com.lprclient.core.view.frame.LoginFrame;
import com.lprclient.core.view.frame.MainFrame;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午9:23:09  
 * @version V1.0    
 */
public class LoginAction implements ActionListener {
	
	private IUserSV userSV = new UserSVImpl();
	private IRoleSV roleSV = new RoleSVImpl();
	private IContentSV contentSV = new ContentSVImpl();
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	private IRolePermRelSV permSV = new RolePermRelSVImpl();

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginFrame loginFrame = LoginFrame.getInstance();
		// 页面校验
		String userName = loginFrame.getUserName().getText();
		char[] password = loginFrame.getPassword().getPassword();
		if (StringUtil.isBlank(userName)) {
			loginFrame.getAlertLab().setText("请输入用户名");
			loginFrame.getUserName().requestFocus();
			return;
		}
		if (StringUtil.isBlank(password)) {
			loginFrame.getAlertLab().setText("请输入密码");
			loginFrame.getPassword().requestFocus();
			return;
		}
		// 数据库校验用户名密码
		UserDTO userDTO = userSV.login(userName, String.valueOf(password));
		if (null != userDTO.getEntity()) {
			// 校验成功，更新静态变量
			RoleDTO roleDTO = roleSV.queryByUserId(userDTO.getUserId());
			userDTO.setRoleDTO(roleDTO);
			LPRUtil.setIsLogin(LPRConstant.ISLOGIN_YES);
			LPRUtil.setUserName(userName);
			LPRUtil.setAdminUser(userDTO);
			// 更新用户数据
			int count = userDTO.getLoginTimes();
			count++;
			userDTO.setLoginTimes(count);
			userDTO.setLastLoginDate(new Date());
			userSV.saveOrUpdate(userDTO);
			UserOperateDTO userOperateDTO = new UserOperateDTO(userDTO, 
					LPRConstant.ACTION_TYPE_LOGIN, LPRConstant.ACTION_SUCCESS);
			operateSV.saveOrUpdate(userOperateDTO);
		} else {
			loginFrame.getAlertLab().setText("用户名或密码错误，请重新输入");
			loginFrame.getUserName().requestFocus();
			return;
		}
		
		// 查询用户基本信息
		// 查询用户权限列表
		List<ContentDTO> contentDTOs = new ArrayList<ContentDTO>();
		List<RolePermRelDTO> permDTOs = permSV.queryByRoleId(userDTO.getRoleDTO().getRoleId());
		if (null != permDTOs && permDTOs.size() > 0) {
			for (RolePermRelDTO dto : permDTOs) {
				if (LPRConstant.ROLE_PERM_YES == dto.getPermPage()) {
					contentDTOs.add(dto.getContentDTO());
				}
			}
		}
		
		LPRUtil.setContentDTO(contentDTOs);
		
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.init();
		mainFrame.setVisible(true);
		mainFrame.showTimer();
		loginFrame.dispose();
	}

}
