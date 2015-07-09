package com.lprclient.core.view.table;

import java.awt.Component;
import java.util.Hashtable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午5:05:49  
 * @version V1.0    
 */
public class EachRowRenderer implements TableCellRenderer {
	
	@SuppressWarnings("rawtypes")
	protected Hashtable renderers;
	protected TableCellRenderer renderer;
	protected TableCellRenderer defaultRenderer;

	@SuppressWarnings("rawtypes")
	public EachRowRenderer() {
	    renderers = new Hashtable();
	    defaultRenderer = new DefaultTableCellRenderer();
	}
	  
	@SuppressWarnings("unchecked")
	public void add(int column, TableCellRenderer renderer) {
		renderers.put(new Integer(column),renderer);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		renderer = (TableCellRenderer)renderers.get(new Integer(column));
	    if (renderer == null) {
	      renderer = defaultRenderer;
	    }
	    return renderer.getTableCellRendererComponent(table,
	             value, isSelected, hasFocus, row, column);
	}

}
