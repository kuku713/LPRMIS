package com.lprclient.core.view.label;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.StringUtil;
import com.lprclient.core.view.frame.LoginFrame;
import com.lprclient.core.view.frame.RegistFrame;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午5:15:00  
 * @version V1.0    
 */
public class URLLabel extends JLabel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private String actionType;

	public URLLabel(String urlStr, String tipTextStr) {
		this.setText(urlStr);
		this.setForeground(Color.blue); //设置链接颜色
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标样式
		this.setToolTipText(tipTextStr); //设置提示文字
		Font f = new Font(null, Font.ITALIC, 12);
		this.setFont(f);
		this.addMouseListener(this);
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (StringUtil.isNotBlank(actionType)) {
			if (LPRConstant.ACTION_TYPE_REGIST.equals(actionType)) {
				LoginFrame loginFrame = LoginFrame.getInstance();
				loginFrame.dispose();
				RegistFrame registFrame = RegistFrame.getInstance();
				registFrame.init();
				registFrame.setVisible(true);
			} else if (LPRConstant.ACTION_TYPE_FORGOT_PASSWORD.equals(actionType)) {
				System.out.println(LPRConstant.ACTION_TYPE_FORGOT_PASSWORD);
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
