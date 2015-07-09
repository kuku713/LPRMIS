package com.lprclient.core.view.scrollpan;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午10:13:32  
 * @version V1.0    
 */
public class LPRScrollPan extends JScrollPane {
	
	private static final long serialVersionUID = 1L;

	public LPRScrollPan(JTable table) {
		super(table);
		int rowCount = table.getRowCount();
		int height = rowCount * LPRConstant.TABLE_CELL_HEIGHT 
				+ LPRConstant.TABLE_HEAD_HEIGHT + 5;
		height = height < LPRConstant.SCROLLPAN_HEIGHT_MAX ? height : LPRConstant.SCROLLPAN_HEIGHT_MAX;
		super.setBounds(LPRConstant.SCROLLPAN_BEGIN_X, LPRConstant.SCROLLPAN_BEGIN_Y, 
				LPRConstant.SCROLLPAN_WIDTH, height);
	}

}
