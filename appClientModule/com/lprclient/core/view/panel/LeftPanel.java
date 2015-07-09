package com.lprclient.core.view.panel;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.ContentDTO;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.view.label.ContentLabel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午10:36:52  
 * @version V1.0    
 */
public class LeftPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static LeftPanel instance = new LeftPanel();
	private List<ContentDTO> mainDTOs;
	private List<ContentDTO> subDTOs;
	private JPanel contentPanel;
	
	public static LeftPanel getInstance() {
		return instance;
	}
	
	private LeftPanel() {
		super();
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder()); // 设置边框
		this.setBounds(LPRConstant.MAIN_FRAME_LEFT_PANEL_X, LPRConstant.MAIN_FRAME_LEFT_PANEL_Y, 
				LPRConstant.MAIN_FRAME_LEFT_PANEL_WIDTH, LPRConstant.MAIN_FRAME_LEFT_PANEL_HEIGHT);
	}
	
	public void init() {
		this.removeAll();
		this.add(getContentPanel(), null);
	}
	
	private JPanel getContentPanel() {
		mainDTOs = LPRUtil.getContentDTO();
		subDTOs = LPRUtil.getContentDTO();
		contentPanel = new JPanel();
		contentPanel.setBounds(10, LPRConstant.MAIN_FRAME_LEFT_PANEL_Y + 20, 140, 400);
		if (mainDTOs != null && mainDTOs.size() >0) {
			int contents = 2;
			int mainContent = 0;
			for (ContentDTO mainDTO : mainDTOs) {
				// 过滤子目录
				if (mainDTO.getContentLevel() != LPRConstant.CONTENT_LEVEL_MAIN) {
					continue;
				}
				ContentLabel mainLab = new ContentLabel(new String[]{mainDTO.getContentName()}, null);
				mainLab.setBounds(40, contents * 25 + mainContent * 10, 80, 20);
				this.add(mainLab);
				contents++;
				if (null != subDTOs && subDTOs.size() > 0)
				for (ContentDTO subDTO : subDTOs) {
					if (subDTO.getParentContentId().equals(mainDTO.getContentId())) {
						String[] navArr = new String[]{subDTO.getContentName(), mainDTO.getContentName()};
						ContentLabel subLab = new ContentLabel(navArr, subDTO.getContentAction());
						subLab.setBounds(60, contents * 25 + 5 + mainContent * 10, 80, 20);
						this.add(subLab);
						contents++;
					}
				}
				mainContent++;
			}
		}
		return contentPanel;
	}

}
