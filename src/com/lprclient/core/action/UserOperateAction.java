package com.lprclient.core.action;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.util.Pager;
import com.lprclient.core.view.label.PageInfoLabel;
import com.lprclient.core.view.panel.PageLabelPanel;
import com.lprclient.core.view.panel.PagePanel;
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
 * @date: 2015年7月7日 下午11:20:00  
 * @version V1.0    
 */
public class UserOperateAction extends BaseAction {
	
	public static final String ACTION_CLASS_NAME = "com.lprclient.core.action.UserOperateAction";
	
	private Pager pager;
	private LPRTable table;
	private JScrollPane scroll;
	private boolean hasSelectColumn = false;  // 是否需要第一列选择列
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	
	/**
	 * 目录点击后跳转
	 */
	public void onClick(String[] navArr) {
		System.out.println("This is UserOperateAction.");
		this.setNavArr(navArr);
		repaint();
	}
	
	/**
	 * 刷新查询结果
	 */
	public void refreshPage(Pager pager, String[] navArr) {
		this.pager = pager;
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
		right.add(getAddButton());
		right.add(getEditButton());
		right.add(getDetailButton());
		right.add(getDelButton());
		right.add(getMainRoleList());
		right.add(getPageInfoLab());
		right.add(getPageLabelPanel());
		right.add(getPagePanel());
		right.repaint();
	}
	
	/**
	 * 新增按钮
	 * @return
	 */
	private JButton getAddButton() {
		JButton addBtn = new JButton("新增");
		int begin_x = LPRConstant.TABLE_BUTTON_BEGIN_X;
		addBtn.setBounds(begin_x, LPRConstant.TABLE_BUTTON_BEGIN_Y, 
				LPRConstant.TABLE_BUTTON_WIDTH, LPRConstant.TABLE_BUTTON_HEIGHT);
		addBtn.setEnabled(false);
		return addBtn;
	}
	
	/**
	 * 编辑按钮
	 * @return
	 */
	private JButton getEditButton() {
		JButton editBtn = new JButton("编辑");
		int begin_x = LPRConstant.TABLE_BUTTON_BEGIN_X 
				+ 1 * LPRConstant.TABLE_BUTTON_FLOAT;
		editBtn.setBounds(begin_x, LPRConstant.TABLE_BUTTON_BEGIN_Y, 
				LPRConstant.TABLE_BUTTON_WIDTH, LPRConstant.TABLE_BUTTON_HEIGHT);
		editBtn.setEnabled(false);
		return editBtn;
	}
	
	/**
	 * 查看按钮
	 * @return
	 */
	private JButton getDetailButton() {
		JButton detailBtn = new JButton("查看");
		int begin_x = LPRConstant.TABLE_BUTTON_BEGIN_X 
				+ 2 * LPRConstant.TABLE_BUTTON_FLOAT;
		detailBtn.setBounds(begin_x, LPRConstant.TABLE_BUTTON_BEGIN_Y, 
				LPRConstant.TABLE_BUTTON_WIDTH, LPRConstant.TABLE_BUTTON_HEIGHT);
		detailBtn.setEnabled(false);
		return detailBtn;
	}
	
	/**
	 * 删除按钮
	 * @return
	 */
	private JButton getDelButton() {
		JButton delBtn = new JButton("删除");
		int begin_x = LPRConstant.TABLE_BUTTON_BEGIN_X 
				+ 3 * LPRConstant.TABLE_BUTTON_FLOAT;
		delBtn.setBounds(begin_x, LPRConstant.TABLE_BUTTON_BEGIN_Y, 
				LPRConstant.TABLE_BUTTON_WIDTH, LPRConstant.TABLE_BUTTON_HEIGHT);
		delBtn.setEnabled(false);
		return delBtn;
	}
	
	/**
	 * 总记录信息标签
	 * @return
	 */
	private JLabel getPageInfoLab() {
		JLabel pageInfoLab = new PageInfoLabel(table, pager, null);
		return pageInfoLab;
	}
	
	/**
	 * 首上下尾页标签
	 * @return
	 */
	private JPanel getPageLabelPanel() {
		JPanel pageLabelPanel = new PageLabelPanel(table, pager, 
				ArrayUtil.newArrAddHead(ACTION_CLASS_NAME, getNavArr()));
		return pageLabelPanel;
	}
	
	/**
	 * 当前页面和跳转页面标签
	 * @return
	 */
	private JPanel getPagePanel() {
		JPanel pagePanel = new PagePanel(table, pager, 
				ArrayUtil.newArrAddHead(ACTION_CLASS_NAME, getNavArr()));
		return pagePanel;
	}
	
	/**
	 * 查询结果页
	 * @return
	 */
	private JScrollPane getMainRoleList() {
		long totalSize = operateSV.getCount();
		if (null == pager) {
			pager = new Pager(1, totalSize);
		}
		List<UserOperateDTO> dtos = operateSV.queryAll(pager.getPageNow(), pager.getPageSize());
		String[] name = {"用户名", "昵称", "角色", "操作类型", "操作结果", "操作时间"};
		// 设置列宽，总共100分配各列
		int[] columnPercents = {15, 15, 20, 10, 10, 30};
		Object[][] data = dtoToObj(dtos, name.length);
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
		    table.addMouseListener(new CheckBoxListener(table));
		}
		
		table.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("宋体", Font.BOLD, 15);
		table.getTableHeader().setFont(font);
		
		scroll = new LPRScrollPan(table);
		return scroll;
	}
	
	/**
	 * 数据格式转换
	 * @param dtos
	 * @param length
	 * @return
	 */
	private Object[][] dtoToObj(List<UserOperateDTO> dtos, int length) {
		// 比表头多一列，为每行的行ID
		length++;
		Object[][] result = null;
		if (null != dtos && dtos.size() > 0) {
			result = new Object[dtos.size()][length];
			for (int i=0; i<dtos.size(); i++) {
				for (int j=0; j<length; j++) {
					switch (j) {
					case 0:
						result[i][j] = dtos.get(i).getOperateId();
						break;
					case 1:
						result[i][j] = dtos.get(i).getUserDTO().getUserName();
						break;
					case 2:
						result[i][j] = dtos.get(i).getUserDTO().getNickName();
						break;
					case 3:
						result[i][j] = dtos.get(i).getUserDTO().getRoleDTO().getRoleName();
						break;
					case 4:
						result[i][j] = dtos.get(i).getOperateType();
						break;
					case 5:
						result[i][j] = dtos.get(i).getOperateResultDesc();
						break;
					case 6:
						result[i][j] = DateUtil.formatDateLong(dtos.get(i).getOperateDate());
						break;
					default:
						break;
					}
				}
			}
		}
		return result;
	}

}
