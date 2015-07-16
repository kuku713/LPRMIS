package com.lprclient.core.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.IUserSV;
import com.lprclient.core.service.impl.RoleSVImpl;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.service.impl.UserSVImpl;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.ComboBoxDataUtil;
import com.lprclient.core.util.DateUtil;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.util.Pager;
import com.lprclient.core.view.combobox.ComboBoxData;
import com.lprclient.core.view.combobox.KeyObjComboBox;
import com.lprclient.core.view.label.DisplayLabel;
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

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午11:45:30  
 * @version V1.0    
 */
public class UserAction extends BaseAction {
	
	public final static String ACTION_CLASS_NAME = "com.lprclient.core.action.UserAction";
	
	private Pager pager;
	private LPRTable table;
	private JScrollPane scroll;
	private int subPanelHeight;
	private boolean hasSelectColumn = true;  // 是否需要第一列选择列
	private IUserSV userSV = new UserSVImpl();
	private IRoleSV roleSV = new RoleSVImpl();
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	private UserDTO userDTO = null;
	private KeyObjComboBox statusCombox;
	private KeyObjComboBox roleCombox;
	
	/**
	 * 目录点击后跳转
	 */
	public void onClick(String[] navArr) {
		System.out.println("This is UserAction.");
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
		editBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click Add Button.");
				if (!isUnique()) {
					JOptionPane.showMessageDialog(null, "请选择一条记录就行操作",
							"错误",JOptionPane.ERROR_MESSAGE);
				} else {
					userDTO = userSV.queryByUserId(getId());
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
					userDTO = userSV.queryByUserId(getId());
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
					int option = JOptionPane.showConfirmDialog(null, "确认删除此用户？", "提示", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						userDTO = userSV.queryByUserId(getId());
						userDTO.setStatus(LPRConstant.ADMIN_USER_STATUS_CANCEL);
						userSV.saveOrUpdate(userDTO);
						UserDTO adminUser = LPRUtil.getAdminUser();
						UserOperateDTO userOperateDTO = new UserOperateDTO(adminUser, 
								LPRConstant.ACTION_TYPE_DELETE_USER, LPRConstant.ACTION_SUCCESS);
						operateSV.saveOrUpdate(userOperateDTO);
						repaint();
					}
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
		long totalSize = userSV.getCount();
		if (null == pager) {
			pager = new Pager(1, totalSize);
		}
		List<UserDTO> dtos = userSV.queryAll(pager.getPageNow(), pager.getPageSize());
		String[] name = {"用户名", "昵称", "用户状态", "角色", "登录次数", "最后登录时间"};
		// 设置列宽，总共100分配各列
		int[] columnPercents = {15, 15, 10, 20, 10, 30};
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
	private Object[][] dtoToObj(List<UserDTO> dtos, int length) {
		// 比表头多一列，为每行的行ID
		length++;
		Object[][] result = null;
		if (null != dtos && dtos.size() > 0) {
			result = new Object[dtos.size()][length];
			for (int i=0; i<dtos.size(); i++) {
				for (int j=0; j<length; j++) {
					switch (j) {
					case 0:
						result[i][j] = dtos.get(i).getUserId();
						break;
					case 1:
						result[i][j] = dtos.get(i).getUserName();
						break;
					case 2:
						result[i][j] = dtos.get(i).getNickName();
						break;
					case 3:
						String status = "";
						if (dtos.get(i).getStatus() == LPRConstant.ADMIN_USER_STATUS_NORMAL) {
							status = LPRConstant.ADMIN_USER_STATUS_NORMAL_DESC;
						} else if (dtos.get(i).getStatus() == LPRConstant.ADMIN_USER_STATUS_CANCEL) {
							status = LPRConstant.ADMIN_USER_STATUS_CANCEL_DESC;
						} else {
							status = LPRConstant.ADMIN_USER_STATUS_OTHER_DESC;
						}
						result[i][j] = status;
						break;
					case 4:
						result[i][j] = roleSV.queryByUserId(dtos.get(i).getUserId()).getRoleName();
						break;
					case 5:
						result[i][j] = dtos.get(i).getLoginTimes();
						break;
					case 6:
						result[i][j] = DateUtil.formatDateLong(dtos.get(i).getLastLoginDate());
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
//			right.add(getSubPanel(subViewType));
//			right.add(getSubBackBtn(subViewType));
//			right.add(getSubmitBtn(subViewType));
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
		int rowCount = 8;
		GridLayout gridLayout = null;
		if (subViewType != LPRConstant.SUB_VIEW_TYPE_DETAIL) {
			gridLayout = new GridLayout(rowCount, 3);
		} else {
			gridLayout = new GridLayout(rowCount, 2);
		}
		
		JLabel userIdLab = new InputLabel("用户ID");
		JLabel userNameLab = new InputLabel("用户名");
		JLabel nickNameLab = new InputLabel("昵称");
		JLabel createDateLab = new InputLabel("创建时间");
		JLabel lastLoginDateLab = new InputLabel("最后登录时间");
		JLabel loginTimesLab = new InputLabel("登录次数");
		JLabel statusLab = new InputLabel("用户状态");	
		JLabel roleNameLab = new InputLabel("当前角色");
//		roleNameTxt = new InputText();
//		roleDescLab = new InputLabel("角色描述");
//		roleDescTxt = new InputText();
		Vector<ComboBoxData> roleData = ComboBoxDataUtil.listToData(roleSV.queryAll());
		Vector<ComboBoxData> statusData = ComboBoxDataUtil.getAdminUserStatus();
		roleCombox = new KeyObjComboBox(roleData);
		statusCombox = new KeyObjComboBox(statusData);
		
		subPanel.setLayout(gridLayout);
		
		subPanelHeight = rowCount * LPRConstant.SUB_LABEL_EACH + 35;
		subPanelHeight = subPanelHeight < LPRConstant.SUB_PANEL_HEIGHT_MAX ? subPanelHeight
				: LPRConstant.SUB_PANEL_HEIGHT_MAX;
		subPanel.setBounds(LPRConstant.SUB_PANEL_BEGIN_X, LPRConstant.SUB_PANEL_BEGIN_Y, 
				LPRConstant.SUB_PANEL_WIDTH, subPanelHeight);

		if (null == userDTO
				|| null == userDTO.getEntity()) {
		} else {
			roleCombox.setSelectedKey(roleSV.queryByUserId(userDTO.getUserId()).getRoleId());
			statusCombox.setSelectedKey(userDTO.getStatus());
		}
		
		subPanel.add(userIdLab);
		subPanel.add(new DisplayLabel(userDTO.getUserId()));
		subPanel.add(new JLabel());
		subPanel.add(userNameLab);
		subPanel.add(new DisplayLabel(userDTO.getUserName()));
		subPanel.add(new JLabel());
		subPanel.add(nickNameLab);
		subPanel.add(new DisplayLabel(userDTO.getNickName()));
		subPanel.add(new JLabel());
		subPanel.add(createDateLab);
		subPanel.add(new DisplayLabel(DateUtil.formatDateLong(userDTO.getCreateDate())));
		subPanel.add(new JLabel());
		subPanel.add(lastLoginDateLab);
		subPanel.add(new DisplayLabel(DateUtil.formatDateLong(userDTO.getLastLoginDate())));
		subPanel.add(new JLabel());
		subPanel.add(loginTimesLab);
		subPanel.add(new DisplayLabel(String.valueOf(userDTO.getLoginTimes())));
		subPanel.add(new JLabel());
		subPanel.add(statusLab);
		
		
		if (subViewType != LPRConstant.SUB_VIEW_TYPE_DETAIL) {
			subPanel.add(statusCombox);
			subPanel.add(new NeedLabel());
			subPanel.add(roleNameLab);
			subPanel.add(roleCombox);
			subPanel.add(new NeedLabel());
		} else {
			subPanel.add(new DisplayLabel(userDTO.getStatusDesc()));
			subPanel.add(new JLabel());
			subPanel.add(roleNameLab);
			subPanel.add(new DisplayLabel(userDTO.getRoleDTO().getRoleName()));
			subPanel.add(new JLabel());
		}
		subPanel.setBorder(BorderFactory.createTitledBorder("管理员信息"));
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
//				String roleName = roleNameTxt.getText().trim();
//				String roleDesc = roleDescTxt.getText().trim();
//				if (StringUtil.isBlank(roleName)) {
//					JOptionPane.showMessageDialog(null, "请输入角色名称",
//							"错误",JOptionPane.ERROR_MESSAGE);
//					
//					roleNameTxt.requestFocus();
//					return;
//				} else {
//					subDTO.setRoleName(roleName);
//					subDTO.setRoleDesc(roleDesc);
//					roleSV.saveOrUpdate(subDTO);
//					if (subViewType == LPRConstant.SUB_VIEW_TYPE_ADD) {
//						JOptionPane.showMessageDialog(null, "新增成功",
//								"提示",JOptionPane.INFORMATION_MESSAGE);
//					} else if (subViewType == LPRConstant.SUB_VIEW_TYPE_EDIT) {
//						JOptionPane.showMessageDialog(null, "修改成功",
//								"提示",JOptionPane.INFORMATION_MESSAGE);
//					}
//					onClick(ArrayUtil.newArrRedHead(getNavArr()));
//				}
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
