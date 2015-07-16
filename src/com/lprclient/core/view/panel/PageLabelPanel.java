package com.lprclient.core.view.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.Pager;
import com.lprclient.core.view.label.PageLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月4日 下午10:07:23  
 * @version V1.0    
 */
public class PageLabelPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Pager pager;
	private int begin_y;
	/**
	 * [0] ActionClassName
	 * [1..i] NavName
	 */
	private String[] param;
	
	public PageLabelPanel(JTable table, Pager pager, String[] param) {
		super();
		this.pager = pager;
		this.param = param;
		int rowCount = table.getRowCount();
		begin_y = rowCount * LPRConstant.TABLE_CELL_HEIGHT 
				+ LPRConstant.TABLE_HEAD_HEIGHT + 5;
		begin_y = begin_y < LPRConstant.SCROLLPAN_HEIGHT_MAX ? begin_y : LPRConstant.SCROLLPAN_HEIGHT_MAX;
		begin_y = begin_y + LPRConstant.SCROLLPAN_BEGIN_Y + 5;
		this.setBounds(LPRConstant.PAGE_LABEL_PANEL_BEGIN_X, begin_y, 
				LPRConstant.PAGE_LABEL_PANEL_WIDTH, LPRConstant.PAGE_LABEL_PANEL_HEIGHT);
		this.add(getFirstPage());
		this.add(getPrePage());
		this.add(getNextPage());
		this.add(getLastPage());
	}
	
	private JLabel getFirstPage() {
		JLabel firstPage = new PageLabel(pager, LPRConstant.PAGE_TYPE_FIRST, param);
		firstPage.setBounds(LPRConstant.PAGE_LABEL_PANEL_BEGIN_X, begin_y,
				50, 20);
		return firstPage;
	}
	
	private JLabel getPrePage() {
		JLabel prePage = new PageLabel(pager, LPRConstant.PAGE_TYPE_PRE, param);
		prePage.setBounds(LPRConstant.PAGE_LABEL_PANEL_BEGIN_X + 50, begin_y,
				50, 20);
		return prePage;
	}
	
	private JLabel getNextPage() {
		JLabel nextPage = new PageLabel(pager, LPRConstant.PAGE_TYPE_NEXT, param);
		nextPage.setBounds(LPRConstant.PAGE_LABEL_PANEL_BEGIN_X + 100, begin_y,
				50, 20);
		return nextPage;
	}
	
	private JLabel getLastPage() {
		JLabel lastPage = new PageLabel(pager, LPRConstant.PAGE_TYPE_LAST, param);
		lastPage.setBounds(LPRConstant.PAGE_LABEL_PANEL_BEGIN_X + 150, begin_y,
				50, 20);
		return lastPage;
	}

}
