package com.lprclient.core.view.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.action.BaseAction;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.NumUtil;
import com.lprclient.core.util.Pager;
import com.lprclient.core.util.StringUtil;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月4日 下午4:53:51  
 * @version V1.0    
 */
public class PagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Pager pager;
	private int begin_y;
	private JTextField pageGo;
	private BaseAction baseAction = null;
	/**
	 * [0] ActionClassName
	 * [1..i] NavName
	 */
	private String[] param;
	
	public PagePanel(JTable table, Pager pager, String[] param) {
		super();
		this.pager = pager;
		this.param = param;
		int rowCount = table.getRowCount();
		begin_y = rowCount * LPRConstant.TABLE_CELL_HEIGHT 
				+ LPRConstant.TABLE_HEAD_HEIGHT + 5;
		begin_y = begin_y < LPRConstant.SCROLLPAN_HEIGHT_MAX ? begin_y : LPRConstant.SCROLLPAN_HEIGHT_MAX;
		begin_y = begin_y + LPRConstant.SCROLLPAN_BEGIN_Y + 5;
		this.setBounds(LPRConstant.PAGE_PANEL_BEGIN_X, begin_y, 
				LPRConstant.PAGE_PANEL_WIDTH, LPRConstant.PAGE_PANEL_HEIGHT);
		this.add(getPageNow(), null);
		this.add(getPageGo(), null);
		this.add(getTotalPage(), null);
		this.add(getGoButton(), null);
	}
	
	private JLabel getPageNow() {
		JLabel pageNow = new JLabel("第" + pager.getPageNow() + "页");
		pageNow.setBounds(LPRConstant.PAGE_PANEL_BEGIN_X, begin_y, 
				80, 20);
		return pageNow;
	}
	
	private JTextField getPageGo() {
		pageGo = new JTextField();
		pageGo.setBounds(LPRConstant.PAGE_PANEL_BEGIN_X + 80, begin_y + 5, 
				40, 20);
		int width = 10 * NumUtil.length(pager.getTotalPage()) + 20;
		pageGo.setPreferredSize(new Dimension(width, 20));
		pageGo.setText(String.valueOf(pager.getPageNow()));
		return pageGo;
	}
	
	private JLabel getTotalPage() {
		JLabel totalPage = new JLabel("/" + pager.getTotalPage() + "页");
		totalPage.setBounds(LPRConstant.PAGE_PANEL_BEGIN_X + 120, begin_y, 
				80, 20);
		return totalPage;
	}
	
	private JButton getGoButton() {
		JButton go = new JButton("Go");
		go.setBounds(LPRConstant.PAGE_PANEL_BEGIN_X + 200, begin_y,
				50, 20);
		go.setPreferredSize(new Dimension(50, 20));
		go.addActionListener(new ActionListener() {
			
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (NumUtil.isNotNum(pageGo.getText())) {
					JOptionPane.showMessageDialog(null, "请输入数字",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					int pageNow = Integer.parseInt(pageGo.getText());
					if (pageNow > pager.getTotalPage()) {
						StringBuffer sbff = new StringBuffer();
						sbff.append("请输入小于等于").append(pager.getTotalPage())
							.append("的页码");
						JOptionPane.showMessageDialog(null, sbff.toString(),
								"错误",JOptionPane.ERROR_MESSAGE);
					} else {
						if (StringUtil.isNotBlank(param[0])) {
							pager.setPageNow(pageNow);
							try {
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
				}
			}
		});
		return go;
	}

}
