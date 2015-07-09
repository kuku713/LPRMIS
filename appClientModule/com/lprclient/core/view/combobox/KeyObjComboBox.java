package com.lprclient.core.view.combobox;

import java.awt.Component;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月6日 下午3:20:19  
 * @version V1.0    
 */
@SuppressWarnings("rawtypes")
public class KeyObjComboBox extends JComboBox {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public KeyObjComboBox(Vector data) {
		super(data);
		initData();
	}
	
	@SuppressWarnings({ "unchecked", "serial" })
	private void initData() {
		ListCellRenderer render = new DefaultListCellRenderer() {
			
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){  
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);  
				if (value instanceof ComboBoxData){  
					ComboBoxData data = (ComboBoxData) value;  
					this.setText(data.getText());  
				}  
				return this;  
			} 
		};
		this.setRenderer(render);
	}
	
	/**
	 * 修改Combox中的数据 
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public void updateData(Vector data) {
		setModel(new DefaultComboBoxModel(data));
		initData();
	}
	
	/**
	 * 选中与传入的对象相同的项
	 */
	public void setSelectedItem(Object anObject) {
		if (null != anObject){  
			if (anObject instanceof ComboBoxData){  
				super.setSelectedItem(anObject);  
            }  
            if(anObject instanceof String){  
            		for (int index = 0; index < getItemCount(); index++) {  
            			ComboBoxData data = (ComboBoxData) getItemAt(index);  
            			if (data.getText().equals(anObject.toString())) {  
            				super.setSelectedIndex(index);  
            			}  
            		}  
            }  
		} else {  
			super.setSelectedIndex(0); 
		} 
	}
	
	/**
	 * 选中与传入的key相同的项
	 */
	public void setSelectedKey(Integer key) {
		if (null != key) {
			for (int index=0; index<getItemCount(); index++) {
				ComboBoxData data = (ComboBoxData) getItemAt(index);
				if (data.getKey().equals(key)) {
					super.setSelectedIndex(index);
				}
			}
		} else {
			super.setSelectedIndex(0); 
		}
	}
	
	/**
	 * 返回选中项的key
	 * @return
	 */
	public Integer getSelectedKey() {
		if (getSelectedItem() instanceof ComboBoxData) {
			ComboBoxData data = (ComboBoxData) getSelectedItem();
			return data.getKey();
		}
		return 0;
	}
	
	/**
	 * 返回选中项的text
	 * @return
	 */
	public String getSelectedText() {
		if (getSelectedItem() instanceof ComboBoxData) {
			ComboBoxData data = (ComboBoxData) getSelectedItem();
			return data.getText();
		}
		return "";
	}
	
	/**
	 * 返回选中项的对象
	 * @return
	 */
	public Object getSelectedObj() {
		if (getSelectedItem() instanceof ComboBoxData) {
			ComboBoxData data = (ComboBoxData) getSelectedItem();
			return data.getObj();
		}
		return null;
	}

}
