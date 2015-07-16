package com.lprclient.core.view.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午7:09:00  
 * @version V1.0    
 */
public class CheckBoxListener extends MouseAdapter {
	
	private JTable table;
	private List<Integer> colEditable = new ArrayList<Integer>();
	
	public CheckBoxListener(JTable table) {
		this.table = table;
		colEditable.add(0);
	}
	
	public CheckBoxListener(JTable table, List<Integer> colEditable) {
		this.table = table;
		this.colEditable = colEditable;
	}
	
	public void mouseClicked(MouseEvent e) {
        int rowIndex = table.rowAtPoint(e.getPoint()); //获取点击的行
        int columnIndex = table.columnAtPoint(e.getPoint()); //获取点击的列
        
        if (null != colEditable
        			&& colEditable.contains(Integer.valueOf(columnIndex))) {
			if(((Boolean)table.getValueAt(rowIndex,columnIndex)).booleanValue()){ //原来选中
                  table.setValueAt(false, rowIndex, columnIndex); //点击后，取消选中
              }
            else {//原来未选中
                  table.setValueAt(true, rowIndex, columnIndex);
              }
		}
	}

}
