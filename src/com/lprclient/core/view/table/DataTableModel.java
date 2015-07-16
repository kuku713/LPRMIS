package com.lprclient.core.view.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lprclient.core.util.ArrayUtil;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午3:45:21  
 * @version V1.0    
 */
public class DataTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Object[][] data = null;
	private String[] columnName = null;
	private boolean tableEditable = false;
	private List<Integer> colEditable = new ArrayList<Integer>();
	
	public DataTableModel(Object[][] data, String[] columnName) {
		this.data = data;
		this.columnName = columnName;
	}
	
	public DataTableModel(Object[][] data, String[] columnName,
			boolean hasSelectColumn) {
		// 需要第一列选择列
		if (hasSelectColumn) {
			this.data = ArrayUtil.addColumnData(data);
			this.columnName = ArrayUtil.addColumnName(columnName);
		} else {
			this.data = data;
			this.columnName = columnName;
		}
	}

	@Override
	public int getRowCount() {
		if (null != data) {
			return data.length;
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		if (null != columnName) {
			return columnName.length;
		}
		return 0;
	}
	
	public String getColumnName(int column) {
		return columnName[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex <= getRowCount()
				&& columnIndex <= getColumnCount()) {
			return data[rowIndex][columnIndex];
		}
		return null;
	}
	
	public void setTableEditable(boolean tableEditable) {
		this.tableEditable = tableEditable;
	}
	
	public boolean getTableEditable() {
		return tableEditable;
	}

	public void setColEditable(int columnIndex) {
		if (columnIndex <= getColumnCount()
				&& !colEditable.contains(Integer.valueOf(columnIndex))) {
			colEditable.add(Integer.valueOf(columnIndex));
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    if (tableEditable
	    			&& colEditable.contains(Integer.valueOf(columnIndex))) {
	    		return true;
	    }
		return false;
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		if (rowIndex <= getRowCount()
				&& columnIndex <= getColumnCount()) {
			data[rowIndex][columnIndex] = value;
			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}

}
