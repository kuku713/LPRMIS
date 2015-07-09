package com.lprclient.core.view.label;

import javax.swing.JLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月23日 下午10:53:22  
 * @version V1.0    
 */
public class NavLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;

	public NavLabel(String[] navArr) {
		if (null != navArr && navArr.length > 0) {
			StringBuffer sbff = new StringBuffer();
			for (int i=navArr.length-1; i>=0; i--) {
				sbff.append(navArr[i]).append(">>");
			}
			this.setText(sbff.substring(0, sbff.length()-2));
		}
	}

}
