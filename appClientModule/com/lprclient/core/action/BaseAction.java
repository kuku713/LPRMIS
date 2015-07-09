package com.lprclient.core.action;

import javax.swing.JLabel;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.Pager;
import com.lprclient.core.view.label.NavLabel;


/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月23日 下午10:20:28  
 * @version V1.0    
 */
public class BaseAction {
	
	private String[] navArr;

	public void onClick(String[] navArr){};
	
	public void refreshPage(Pager pager, String[] navArr){};
	
	public JLabel getNavLabel() {
		JLabel navLab = new NavLabel(navArr);
		navLab.setBounds(LPRConstant.RIGHT_PANEL_NAV_BEGIN_X, LPRConstant.RIGHT_PANEL_NAV_BEGIN_Y, 
				LPRConstant.RIGHT_PANEL_NAV_WIDTH, LPRConstant.RIGHT_PANEL_NAV_HEIGHT);
		return navLab;
	}

	public String[] getNavArr() {
		return navArr;
	}

	public void setNavArr(String[] navArr) {
		this.navArr = navArr;
	}

}
