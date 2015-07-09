package com.lprclient.core.action;

import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月23日 下午10:23:17  
 * @version V1.0    
 */
public class UserSearchAction extends BaseAction {

	@Override
	public void onClick(String[] navArr) {
		this.setNavArr(navArr);
		RightPanel right = RightPanel.getInstance();
		right.removeAll();
		right.add(getNavLabel(), null);
		right.repaint();
	}

}
