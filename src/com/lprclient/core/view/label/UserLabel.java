package com.lprclient.core.view.label;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.lprclient.core.action.BaseAction;
import com.lprclient.core.util.StringUtil;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午10:52:25  
 * @version V1.0    
 */
public class UserLabel extends JLabel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private String actionClassName;

	public UserLabel(String urlStr, String actionClassName) {
		this.setText(urlStr);
		this.actionClassName = actionClassName;
		this.setForeground(Color.blue); //设置链接颜色
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标样式
		this.addMouseListener(this);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void mouseClicked(MouseEvent e) {
		if (StringUtil.isNotBlank(actionClassName)) {
			Class c = null;
			try {
				c = Class.forName(actionClassName);
				Object obj = c.newInstance();
				BaseAction base = (BaseAction) obj;
				base.onClick(null);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e2) {
				e2.printStackTrace();
			} catch (IllegalAccessException e3) {
				e3.printStackTrace();
			}  
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public String getActionClassName() {
		return actionClassName;
	}

	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}

}
