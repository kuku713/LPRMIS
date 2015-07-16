package com.lprclient.core.action;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.view.frame.LoginFrame;
import com.lprclient.core.view.frame.MainFrame;


/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午11:45:06  
 * @version V1.0    
 */
public class LogoutAction extends BaseAction {
	
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	
	@Override
	public void onClick(String[] navArr) {
		// 退出登录
		UserDTO userDTO = LPRUtil.getAdminUser();
		UserOperateDTO userOperateDTO = new UserOperateDTO(userDTO, 
				LPRConstant.ACTION_TYEP_LOGOUT, LPRConstant.ACTION_SUCCESS);
		operateSV.saveOrUpdate(userOperateDTO);
		LPRUtil.setIsLogin(LPRConstant.ISLOGIN_NO);
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.dispose();
		LoginFrame loginFrame = LoginFrame.getInstance();
		loginFrame.setVisible(true);
	}

}
