package com.lprclient.core.action;

import com.lprclient.core.view.panel.RightPanel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月14日 下午7:24:49  
 * @version V1.0    
 */
public class UserInfoAction extends BaseAction {
	
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
		right.add(right.getUserInfo());
		right.repaint();
	}

}
