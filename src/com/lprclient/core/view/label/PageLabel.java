package com.lprclient.core.view.label;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.action.BaseAction;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.Pager;
import com.lprclient.core.util.StringUtil;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月4日 下午10:10:17  
 * @version V1.0    
 */
public class PageLabel extends JLabel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private BaseAction baseAction = null;
	private Pager pager;
	private int pageType;
	/**
	 * [0] ActionClassName
	 * [1..i] NavName
	 */
	private String[] param; 
	
	public PageLabel(Pager pager, int pageType, String[] param) {
		this.pager = pager;
		this.pageType = pageType;
		this.param = param;
		switch(pageType) {
		case LPRConstant.PAGE_TYPE_FIRST:
			this.setText(LPRConstant.PAGE_TYPE_FIRST_DESC);
			if (pager.isFirst()) {
				this.setForeground(Color.BLACK);
			} else {
				this.setForeground(Color.BLUE);
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.addMouseListener(this);
			}
			break;
		case LPRConstant.PAGE_TYPE_PRE:
			this.setText(LPRConstant.PAGE_TYPE_PRE_DESC);
			if (pager.isHasPre()) {
				this.setForeground(Color.BLUE);
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.addMouseListener(this);
			} else {
				this.setForeground(Color.BLACK);
			}
			break;
		case LPRConstant.PAGE_TYPE_NEXT:
			this.setText(LPRConstant.PAGE_TYPE_NEXT_DESC);
			if (pager.isHasNext()) {
				this.setForeground(Color.BLUE);
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.addMouseListener(this);
			} else {
				this.setForeground(Color.BLACK);
			}
			break;
		case LPRConstant.PAGE_TYPE_LAST:
			this.setText(LPRConstant.PAGE_TYPE_LAST_DESC);
			if (pager.isLast()) {
				this.setForeground(Color.BLACK);
			} else {
				this.setForeground(Color.BLUE);
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				this.addMouseListener(this);
			}
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void mouseClicked(MouseEvent e) {
		if (StringUtil.isNotBlank(param[0])) {
			int pageNow = pager.getPageNow();
			try {
				switch(pageType) {
					case LPRConstant.PAGE_TYPE_FIRST:
						pageNow = 1;
						pager.setPageNow(pageNow);
						break;
					case LPRConstant.PAGE_TYPE_PRE:
						pageNow--;
						pager.setPageNow(pageNow);
						break;
					case LPRConstant.PAGE_TYPE_NEXT:
						pageNow++;
						pager.setPageNow(pageNow);
						break;
					case LPRConstant.PAGE_TYPE_LAST:
						pageNow = (int) pager.getTotalPage();
						pager.setPageNow(pageNow);
						break;
					default:
						break;
				}
				if (null == baseAction) {
					Class c = Class.forName(param[0]);
					Object obj = c.newInstance();
					baseAction = (BaseAction) obj;
				}
				baseAction.refreshPage(pager, ArrayUtil.newArrRedHead(param));
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

}
