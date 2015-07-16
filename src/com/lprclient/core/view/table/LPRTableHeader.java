package com.lprclient.core.view.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午7:55:10  
 * @version V1.0    
 */
public class LPRTableHeader extends JTableHeader {
	
	private static final long serialVersionUID = 1L;

	public LPRTableHeader(JTable table) {
		table.getTableHeader().setReorderingAllowed(false);    //表格列不可移动
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) table
				.getTableHeader().getDefaultRenderer(); 
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//列名居中
		table.getTableHeader().setDefaultRenderer(hr);
		
		DefaultTableCellRenderer t = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		t.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getTableHeader().setDefaultRenderer(t);
	}

}
