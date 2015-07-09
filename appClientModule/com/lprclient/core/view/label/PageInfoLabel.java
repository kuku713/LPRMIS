package com.lprclient.core.view.label;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.Pager;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月4日 下午4:07:11  
 * @version V1.0    
 */
public class PageInfoLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	public PageInfoLabel(JTable table, Pager pager, String[] param) {
		int rowCount = table.getRowCount();
		int begin_y = rowCount * LPRConstant.TABLE_CELL_HEIGHT 
				+ LPRConstant.TABLE_HEAD_HEIGHT + 5;
		begin_y = begin_y < LPRConstant.SCROLLPAN_HEIGHT_MAX ? begin_y : LPRConstant.SCROLLPAN_HEIGHT_MAX;
		begin_y = begin_y + LPRConstant.SCROLLPAN_BEGIN_Y + 5;
		if (null != pager) {
			StringBuffer sbff = new StringBuffer();
			sbff.append("共查询到").append(pager.getTotalSize()).append("条记录。");
			super.setText(sbff.toString());
		}
		super.setBounds(LPRConstant.PAGE_INFO_LABEL_BEGIN_X, begin_y, 	
				+ LPRConstant.PAGE_INFO_LABEL_WIDTH, LPRConstant.PAGE_INFO_LABEL_HEIGHT);
	}

}
