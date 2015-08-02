package com.lprclient.core.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.ImgFileFilter;
import com.lprclient.core.util.PropertyUtil;
import com.lprclient.core.util.StringUtil;
import com.lprclient.core.view.frame.MainFrame;
import com.lprclient.core.view.label.ImagePanel;
import com.lprclient.core.view.panel.RightPanel;
import com.lprclient.core.view.scrollpan.LPRScrollPan;
import com.lprclient.core.view.table.CheckBoxListener;
import com.lprclient.core.view.table.CheckBoxRenderer;
import com.lprclient.core.view.table.DataTableModel;
import com.lprclient.core.view.table.EachRowRenderer;
import com.lprclient.core.view.table.LPRTable;

/**     
* @Description:
* @author: kuku713@qq.com    
* @date: 2015年8月2日 下午1:18:03  
* @version V1.0    
*/
public class PicSearchAction extends BaseAction {
	
	private static final Logger log = LoggerFactory.getLogger(ExternalClientAction.class);
	private LPRTable table;
	private ImgFileFilter imgFilter = new ImgFileFilter();
	private JTextField search;
	private JTextField picPath;
	private JScrollPane scroll;
	private String[] fileNames = null;
	private boolean hasSelectColumn = true;  // 是否需要第一列选择列
	
	private PropertyUtil propUtil = new PropertyUtil(LPRConstant.PROPERTY_FILE_NAME, true);

	/**
	 * 目录点击后跳转
	 */
	public void onClick(String[] navArr) {
		this.setNavArr(navArr);
		repaint();
	}
	
	/**
	 * 刷新页面
	 */
	private void repaint() {
		RightPanel right = RightPanel.getInstance();
		right.removeAll();
		right.add(getNavLabel());
		right.add(getPicPathLab());
		right.add(getPicPath());
		right.add(getSelectBtn());
		right.add(getSearchLab());
		right.add(getSearchText());
		right.add(getSearchBtn());
		right.add(getDetailButton());
		right.add(getMainPicList());
		right.repaint();
	}
	
	private JLabel getPicPathLab() {
		JLabel picPathLab = new JLabel("请选择车牌文件夹路径:");
		picPathLab.setBounds(20, 40, 150, 20);
		return picPathLab;
	}
	
	private JTextField getPicPath() {
		picPath = new JTextField();
		picPath.setBounds(160, 40, 300, 20);
		picPath.setEditable(false);
		if (StringUtil.isNotBlank(propUtil.getValue(
				LPRConstant.PROPERTY_ATTR_PICPATH))) {
			picPath.setText(propUtil.getValue(
				LPRConstant.PROPERTY_ATTR_PICPATH));
		}
		return picPath;
	}
	
	private JButton getSelectBtn() {
		JButton selectBtn = new JButton("选择");
		selectBtn.setBounds(460, 40, 80, 20);
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();  
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showDialog(new JLabel(), "选择"); 
				File file = jfc.getCurrentDirectory();
				if (null != file && file.isDirectory()) {
					picPath.setText(file.getAbsolutePath());
					picPath.setEditable(false);
					propUtil.setValue(LPRConstant.PROPERTY_ATTR_PICPATH, file.getAbsolutePath());
					propUtil.saveFile(LPRConstant.PROPERTY_FILE_NAME, "SAVE PICPATH");
					// 显示图片列表
					imgFilter.setSearchStr(null);
					fileNames = file.list(imgFilter);
					repaint();
		        } else {
		        		System.out.println("11111");
		        }
			}
		});
		return selectBtn;
	}
	
	private JLabel getSearchLab() {
		JLabel searchLab = new JLabel("关键字:");
		searchLab.setBounds(580, 40, 40, 20);
		return searchLab;
	}
	
	private JTextField getSearchText() {
		if (null == search) {
			search = new JTextField();
			search.setBounds(625, 40, 120, 20);
		}
		return search;
	}
	
	private JButton getSearchBtn() {
		JButton searchBtn = new JButton("查询");
		searchBtn.setBounds(750, 40, 60, 20);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != picPath &&
						StringUtil.isNotBlank(picPath.getText())) {
					File file = new File(picPath.getText());
					if (file.isDirectory()) {
						imgFilter.setSearchStr(search.getText());
						fileNames = file.list(imgFilter);
						repaint();
					}
				}
			}
		});
		return searchBtn;
	}
	
	/**
	 * 查看按钮
	 * @return
	 */
	private JButton getDetailButton() {
		JButton detailBtn = new JButton("查看");
		int begin_x = LPRConstant.TABLE_BUTTON_BEGIN_X 
				+ 3 * LPRConstant.TABLE_BUTTON_FLOAT;
		detailBtn.setBounds(begin_x, LPRConstant.TABLE_BUTTON_BEGIN_Y, 
				LPRConstant.TABLE_BUTTON_WIDTH, LPRConstant.TABLE_BUTTON_HEIGHT);
		detailBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Detail Button.");
				if (!isUnique()) {
					JOptionPane.showMessageDialog(null, "请选择一条记录就行操作",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					// TODO
					JDialog jd = new JDialog(MainFrame.getInstance(), "查看", false);
					ImagePanel imgPanel = new ImagePanel(picPath.getText() + "/" + getId());
					jd.setSize(300, 300);
					jd.add(imgPanel);
					jd.setVisible(true);
					jd.setResizable(false);
				}
			}
		});
		detailBtn.setEnabled(true);
		return detailBtn;
	}
	
	private JScrollPane getMainPicList() {
		String[] name = {"图片名", "路径", "图片格式"};
		// 设置列宽，总共100分配各列
		int[] columnPercents = {30, 60, 10};
		if (null != picPath &&
				StringUtil.isNotBlank(picPath.getText())) {
			File file = new File(picPath.getText());
			if (file.isDirectory()) {
				fileNames = file.list(imgFilter);
			}
		}
		Object[][] data = dtoToObj(fileNames, name.length, picPath.getText());
		Object[] rowId = ArrayUtil.getFirstColumn(data);
		data = ArrayUtil.redColumn(data);
		
		DataTableModel model = new DataTableModel(data, name, hasSelectColumn);
		table = new LPRTable(model, rowId, hasSelectColumn);
		table.setColumnPercents(columnPercents);
		
		if (hasSelectColumn) {
			CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
		    EachRowRenderer rowRenderer = new EachRowRenderer();
		    rowRenderer.add(0, checkBoxRenderer);
		    table.getColumnModel().getColumn(0).setCellRenderer(rowRenderer);
		}
		
		table.addMouseListener(new CheckBoxListener(table));
		table.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("宋体", Font.BOLD, 15);
		table.getTableHeader().setFont(font);
		
		scroll = new LPRScrollPan(table);
		return scroll;
	}
	
	private Object[][] dtoToObj(String[] dtos, int length, String path) {
		// 比表头多一列，为每行的行ID
		length++;
		Object[][] result = null;
		if (null != dtos && dtos.length > 0) {
			result = new Object[dtos.length][length];
			for (int i=0; i<dtos.length; i++) {
				for (int j=0; j<length; j++) {
					switch (j) {
					case 0:
						result[i][j] = dtos[i];
						break;
					case 1:
						result[i][j] = dtos[i];
						break;
					case 2:
						result[i][j] = path + "/" + dtos[i];
						break;
					case 3:
						int index = dtos[i].lastIndexOf(".");
						result[i][j] = dtos[i].substring(index + 1);
						break;
					default:
						break;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 选择是否唯一
	 * @return
	 */
	private boolean isUnique() {
		List<Object> ids = table.getSelectRowIds();
		if (null != ids && ids.size() == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取选择列ID
	 * @return
	 */
	private String getId() {
		if (isUnique()) {
			return (String) table.getSelectRowIds().get(0);
		}
		return "";
	}

}
