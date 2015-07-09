package com.lprclient.core.view.table;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午5:26:04  
 * @version V1.0    
 */
public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public CheckBoxRenderer() {
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
	    } else {
	    		setForeground(table.getForeground());
	    		setBackground(table.getBackground());
	    	}
	    	setSelected((value != null && ((Boolean)value).booleanValue()));
	    return this;
	}

}
