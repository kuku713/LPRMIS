package com.lprclient.core.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.impl.RoleSVImpl;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.Pager;
import com.lprclient.core.util.StringUtil;
import com.lprclient.core.view.label.InputLabel;
import com.lprclient.core.view.label.NeedLabel;
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
import com.lprclient.core.view.text.InputText;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月2日 下午11:46:53  
 * @version V1.0    
 */
public class RoleAction extends BaseAction {
	
	public final static String ACTION_CLASS_NAME = "com.lprclient.core.action.RoleAction";
	
	private Pager pager;
	private LPRTable table;
	private JScrollPane scroll;
	private int subPanelHeight;
	private boolean hasSelectColumn = true;  // 是否需要第一列选择列
	private IRoleSV roleSV = new RoleSVImpl();
	private RoleDTO subDTO = null;
	private JTextField roleNameTxt;
	private JTextField roleDescTxt;
	
	/**
	 * 目录点击后跳转
	 */
	public void onClick(String[] navArr) {
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
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Add Button.");
				subDTO = null;
				subView(LPRConstant.SUB_VIEW_TYPE_ADD);
			}
		});
		addBtn.setEnabled(true);
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
		editBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Add Button.");
				if (!isUnique()) {
					JOptionPane.showMessageDialog(null, "请选择一条记录就行操作",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					subDTO = roleSV.queryByRoleId(getId());
					subView(LPRConstant.SUB_VIEW_TYPE_EDIT);
				}
			}
		});
		editBtn.setEnabled(true);
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
		detailBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Add Button.");
				if (!isUnique()) {
					JOptionPane.showMessageDialog(null, "请选择一条记录就行操作",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					subDTO = roleSV.queryByRoleId(getId());
					subView(LPRConstant.SUB_VIEW_TYPE_DETAIL);
				}
			}
		});
		detailBtn.setEnabled(true);
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
		delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Del Button.");
				if (!hasSelected()) {
					JOptionPane.showMessageDialog(null, "请选择需要删除的记录",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					
				}
			}
		});
		delBtn.setEnabled(true);
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
		long totalSize = roleSV.getCount();
		if (null == pager) {
			pager = new Pager(1, totalSize);
		}
		List<RoleDTO> dtos = roleSV.queryByPage(pager.getPageNow(), pager.getPageSize());
		System.out.println("dtos.len:" + dtos.size());
		String[] name = {"角色名称", "角色描述"};
		// 设置列宽，总共100分配各列
		int[] columnPercents = {30, 70};
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
		}
		
		table.addMouseListener(new CheckBoxListener(table));
		table.setBackground(Color.LIGHT_GRAY);
		Font font = new Font(null, Font.BOLD, 15);
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
	private Object[][] dtoToObj(List<RoleDTO> dtos, int length) {
		// 比表头多一列，为每行的行ID
		length++;
		Object[][] result = null;
		if (null != dtos && dtos.size() > 0) {
			result = new Object[dtos.size()][length];
			for (int i=0; i<dtos.size(); i++) {
				for (int j=0; j<length; j++) {
					switch (j) {
					case 0:
						result[i][j] = dtos.get(i).getRoleId();
						break;
					case 1:
						result[i][j] = dtos.get(i).getRoleName();
						break;
					case 2:
						result[i][j] = dtos.get(i).getRoleDesc();
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
	 * 增删改查子页面
	 * @param subViewType
	 */
	protected void subView(int subViewType) {
		RightPanel right = RightPanel.getInstance();
		right.removeAll();
		switch (subViewType) {
		case LPRConstant.SUB_VIEW_TYPE_ADD:
			this.setNavArr(ArrayUtil.newArrAddHead(
					LPRConstant.SUB_VIEW_TYPE_ADD_DESC, getNavArr()));
			right.add(getSubPanel(subViewType));
			right.add(getSubBackBtn(subViewType));
			right.add(getSubmitBtn(subViewType));
			break;
		case LPRConstant.SUB_VIEW_TYPE_EDIT:
			this.setNavArr(ArrayUtil.newArrAddHead(
					LPRConstant.SUB_VIEW_TYPE_EDIT_DESC, getNavArr()));
			right.add(getSubPanel(subViewType));
			right.add(getSubBackBtn(subViewType));
			right.add(getSubmitBtn(subViewType));
			break;
		case LPRConstant.SUB_VIEW_TYPE_DETAIL:
			this.setNavArr(ArrayUtil.newArrAddHead( 
					LPRConstant.SUB_VIEW_TYPE_DETAIL_DESC, getNavArr()));
			right.add(getSubPanel(subViewType));
			right.add(getSubBackBtn(subViewType));
//			right.add(getSubmitBtn(subViewType));
			break;
		default:
			break;
		}
		right.add(getNavLabel());
		right.repaint();
	}
	
	/**
	 * 子页面
	 * @param subViewType
	 * @return
	 */
	private JPanel getSubPanel(int subViewType) {
		subPanelHeight = 0;
		JPanel subPanel = new JPanel();
		int rowCount = 2;
		GridLayout gridLayout = null;
		if (subViewType != LPRConstant.SUB_VIEW_TYPE_DETAIL) {
			gridLayout = new GridLayout(rowCount, 3);
		} else {
			gridLayout = new GridLayout(rowCount, 2);
		}
		
		
		JLabel roleNameLab = new InputLabel("角色名称");
		roleNameTxt = new InputText();
		JLabel roleDescLab = new InputLabel("角色描述");
		roleDescTxt = new InputText();
//		Vector<ComboBoxData> data = ComboBoxDataUtil.listToData(roleSV.queryAll());
//		combox = new KeyObjComboBox(data);
//		combox.setSelectedKey(5);
		
		subPanel.setLayout(gridLayout);
		
		subPanelHeight = rowCount * LPRConstant.SUB_LABEL_EACH + 35;
		subPanelHeight = subPanelHeight < LPRConstant.SUB_PANEL_HEIGHT_MAX ? subPanelHeight
				: LPRConstant.SUB_PANEL_HEIGHT_MAX;
		subPanel.setBounds(LPRConstant.SUB_PANEL_BEGIN_X, LPRConstant.SUB_PANEL_BEGIN_Y, 
				LPRConstant.SUB_PANEL_WIDTH, subPanelHeight);

		if (null == subDTO
				|| null == subDTO.getEntity()) {
			roleNameTxt.setText("");
			roleDescTxt.setText("");
		} else {
			roleNameTxt.setText(subDTO.getRoleName());
			roleDescTxt.setText(subDTO.getRoleDesc());
		}
		
		if (subViewType != LPRConstant.SUB_VIEW_TYPE_DETAIL) {
			subPanel.add(roleNameLab);
			subPanel.add(roleNameTxt);
			subPanel.add(new NeedLabel());
			subPanel.add(roleDescLab);
			subPanel.add(roleDescTxt);
			subPanel.add(new JLabel());
		} else {
			subPanel.add(roleNameLab);
			subPanel.add(new JLabel(subDTO.getRoleName()));
			subPanel.add(roleDescLab);
			subPanel.add(new JLabel(subDTO.getRoleDesc()));
		}
		subPanel.setBorder(BorderFactory.createTitledBorder("角色信息"));
		return subPanel;
	}
	
	/**
	 * 子页面返回按钮
	 * @param subViewType
	 * @return
	 */
	private JButton getSubBackBtn(int subViewType) {
		System.out.println(subPanelHeight);
		JButton backBtn = new JButton("返回");
		backBtn.setBounds(LPRConstant.SUB_BUTTON_BACK_BEGIN_X, LPRConstant.SUB_PANEL_BEGIN_Y + subPanelHeight + 10, 
				LPRConstant.SUB_BUTTON_WIDTH, LPRConstant.SUB_BUTTON_HEIGHT);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onClick(ArrayUtil.newArrRedHead(getNavArr()));
			}
		});
		return backBtn;
	}
	
	/**
	 * 子页面提交按钮
	 * @param subViewType
	 * @return
	 */
	private JButton getSubmitBtn(final int subViewType) {
		JButton submitBtn = new JButton("确定");
		submitBtn.setBounds(LPRConstant.SUB_BUTTON_BACK_BEGIN_X + LPRConstant.SUB_BUTTON_WIDTH + 10,
				LPRConstant.SUB_PANEL_BEGIN_Y + subPanelHeight + 10, LPRConstant.SUB_BUTTON_WIDTH, LPRConstant.SUB_BUTTON_HEIGHT);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String roleName = roleNameTxt.getText().trim();
				String roleDesc = roleDescTxt.getText().trim();
				if (StringUtil.isBlank(roleName)) {
					JOptionPane.showMessageDialog(null, "请输入角色名称",
							"错误",JOptionPane.ERROR_MESSAGE);
					
					roleNameTxt.requestFocus();
					return;
				} else {
					subDTO.setRoleName(roleName);
					subDTO.setRoleDesc(roleDesc);
					roleSV.saveOrUpdate(subDTO);
					if (subViewType == LPRConstant.SUB_VIEW_TYPE_ADD) {
						JOptionPane.showMessageDialog(null, "新增成功",
								"提示",JOptionPane.INFORMATION_MESSAGE);
					} else if (subViewType == LPRConstant.SUB_VIEW_TYPE_EDIT) {
						JOptionPane.showMessageDialog(null, "修改成功",
								"提示",JOptionPane.INFORMATION_MESSAGE);
					}
					onClick(ArrayUtil.newArrRedHead(getNavArr()));
				}
			}
		});
		return submitBtn;
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
	 * 是否勾选
	 * @return
	 */
	private boolean hasSelected() {
		List<Object> ids = table.getSelectRowIds();
		if (null != ids && ids.size() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取选择列ID
	 * @return
	 */
	private Integer getId() {
		if (isUnique()) {
			return (Integer) table.getSelectRowIds().get(0);
		}
		return 0;
	}

}
