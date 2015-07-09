package com.lprclient.core.view.table;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import com.lprclient.core.LPRConstant;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月2日 下午6:50:48  
 * @version V1.0    
 */
public class LPRTable extends JTable {

	private static final long serialVersionUID = 1L;
	
	private List<Object> selectRowIds = null;
	private Object[] rowIds = null;
	private boolean hasSelectColumn = false;
	private TableModel tableModel = null;
	
	public LPRTable(TableModel tb, Object[] rowIds, boolean hasSelectColumn) {
		super(tb);
		this.rowIds = rowIds;
		this.hasSelectColumn = hasSelectColumn;
		this.tableModel = tb;
		setHeadHeight();
		setRowHeight();
		setTableContentCenter();
		setTableHeadCenter();
	}
	
	/**
	 * 设置表头高度
	 */
	private void setHeadHeight() {
		Dimension size = super.getTableHeader().getPreferredSize();
		size.height = LPRConstant.TABLE_HEAD_HEIGHT;
		super.getTableHeader().setPreferredSize(size);
	}
	
	/**
	 * 设置行高
	 */
	private void setRowHeight() {
		super.setRowHeight(LPRConstant.TABLE_CELL_HEIGHT);
	}
	
	/**
	 * 设置表内容居中
	 */
	private void setTableContentCenter() {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		super.setDefaultRenderer(Object.class, tcr);
	}
	
	/**
	 * 设置表头位置
	 */
	private void setTableHeadCenter() {
		DefaultTableCellRenderer tcr = (DefaultTableCellRenderer) super
				.getTableHeader().getDefaultRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		super.getTableHeader().setDefaultRenderer(tcr);
		super.getTableHeader().setReorderingAllowed(false); //表格列不可移动
	}
	
	public List<Object> getSelectRowIds() {
		if (hasSelectColumn) {
			selectRowIds = new ArrayList<Object>();
			for (int i=0; i<tableModel.getRowCount(); i++) {
				if ((Boolean) tableModel.getValueAt(i, 0)) {
					selectRowIds.add(rowIds[i]);
				}
			}
			return selectRowIds;
		} else {
			return null;
		}
	}
	
	/**
	 * 获取rowId
	 * @param index
	 * @return
	 */
	public Object getRowIdByIndex(int index) {
		if (null == rowIds) {
			return null;
		}
		if (index > rowIds.length) {
			return null;
		} else {
			return rowIds[index];
		}
	}
	
	public Object[][] getAllObject() {
		int rowCount = tableModel.getRowCount();
		int colCount = tableModel.getColumnCount();
		Object[][] result = new Object[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				result[i][j] = tableModel.getValueAt(i, j);
			}
		}
		return result;
	}

	public void setColumnPercents(int[] columnPercents) {
		if (null != columnPercents) {
			if (hasSelectColumn) {
				// 有选择列
				int width = LPRConstant.TABLE_WIDTH - LPRConstant.TABLE_SELECT_COL_WIDTH;
				super.getColumnModel().getColumn(0).setPreferredWidth(LPRConstant.TABLE_SELECT_COL_WIDTH);
				super.getColumnModel().getColumn(0).setMaxWidth(LPRConstant.TABLE_SELECT_COL_WIDTH);
				super.getColumnModel().getColumn(0).setMinWidth(LPRConstant.TABLE_SELECT_COL_WIDTH);
				for (int i=0; i<columnPercents.length; i++) {
					int preWidth = width*columnPercents[i]/100;
					super.getColumnModel().getColumn(i+1)
						.setPreferredWidth(preWidth);
				}
			} else {
				// 没有选择列
				int width = LPRConstant.TABLE_WIDTH;
				for (int i=0; i<columnPercents.length; i++) {
					super.getColumnModel().getColumn(i)
						.setPreferredWidth(width*columnPercents[i]/100);
				}
			}
		}
	}

}
