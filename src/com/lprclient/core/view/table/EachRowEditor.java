package com.lprclient.core.view.table;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Hashtable;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月1日 下午5:09:34  
 * @version V1.0    
 */
public class EachRowEditor implements TableCellEditor {
	@SuppressWarnings("rawtypes")
	protected Hashtable editors;
	protected TableCellEditor editor;
	protected TableCellEditor defaultEditor;
    public JTable table;
    
    @SuppressWarnings("rawtypes")
	public EachRowEditor(JTable table) {
        this.table = table;
        editors = new Hashtable();
        defaultEditor = new DefaultCellEditor(new JTextField());
    }
    
    @SuppressWarnings("unchecked")
	public void setEditorAt(int row, TableCellEditor editor) {
        editors.put(new Integer(row),editor);
     }

	@Override
	public Object getCellEditorValue() {
		return editor.getCellEditorValue();
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		selectEditor((MouseEvent)anEvent);
	    return editor.isCellEditable(anEvent);
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		selectEditor((MouseEvent)anEvent);
	    return editor.shouldSelectCell(anEvent);
	}

	@Override
	public boolean stopCellEditing() {
		return editor.stopCellEditing();
	}

	@Override
	public void cancelCellEditing() {
		editor.cancelCellEditing();
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		editor.addCellEditorListener(l);
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		editor.removeCellEditorListener(l);
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		//editor = (TableCellEditor)editors.get(new Integer(row));
	    //if (editor == null) {
	    //  editor = defaultEditor;
	    //}
	    return editor.getTableCellEditorComponent(table,
	             value, isSelected, row, column);
	}
	
	protected void selectEditor(MouseEvent e) {
		int row;
		if (e == null) {
			row = table.getSelectionModel().getAnchorSelectionIndex();
		} else {
			row = table.rowAtPoint(e.getPoint());
		}
		editor = (TableCellEditor)editors.get(new Integer(row));
		if (editor == null) {
			editor = defaultEditor;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void add(int row, TableCellEditor editor) {
		editors.put(new Integer(row), editor);
	}

}
