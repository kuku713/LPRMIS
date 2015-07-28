package com.lprclient.core.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.ContentDTO;
import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.DTO.admin.RolePermRelDTO;
import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.service.IContentSV;
import com.lprclient.core.service.IRolePermRelSV;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.IUserOperateSV;
import com.lprclient.core.service.impl.ContentSVImpl;
import com.lprclient.core.service.impl.RolePermRelSVImpl;
import com.lprclient.core.service.impl.RoleSVImpl;
import com.lprclient.core.service.impl.UserOperateSVImpl;
import com.lprclient.core.util.ArrayUtil;
import com.lprclient.core.util.ComboBoxDataUtil;
import com.lprclient.core.util.LPRUtil;
import com.lprclient.core.util.NumUtil;
import com.lprclient.core.view.combobox.ComboBoxData;
import com.lprclient.core.view.combobox.KeyObjComboBox;
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
 * @date: 2015年6月23日 下午10:30:35  
 * @version V1.0    
 */
public class RolePermAction extends BaseAction {
	
	public final static String ACTION_CLASS_NAME = "com.lprclient.core.action.RolePermAction";
	
	private LPRTable table;
	private JScrollPane scroll;
	private boolean hasSelectColumn = false; // 是否需要第一列选择列
	private IRoleSV roleSV = new RoleSVImpl();
	private IContentSV contentSV = new ContentSVImpl();
	private IRolePermRelSV permSV = new RolePermRelSVImpl();
	private IUserOperateSV operateSV = new UserOperateSVImpl();
	private RoleDTO roleDTO = null;
	private KeyObjComboBox roleCombox;

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
		right.add(getRoleCombox());
		right.add(getSaveButton());
		right.add(getRolePermList());
		right.repaint();
	}
	
	@SuppressWarnings("rawtypes")
	private JComboBox getRoleCombox() {
		if (roleDTO == null) {
			roleDTO = LPRUtil.getAdminUser().getRoleDTO();
		}
		Vector<ComboBoxData> roleData = ComboBoxDataUtil.listToData(roleSV.queryAll());
		roleCombox = new KeyObjComboBox(roleData);
		roleCombox.setSelectedKey(roleDTO.getRoleId());
		roleCombox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				roleDTO = roleSV.queryByRoleId(roleCombox.getSelectedKey());
				repaint();
			}
		});
		roleCombox.setBounds(20, 40, 150, 20);
		return roleCombox;
	}
	
	/**
	 * 保存按钮
	 * @return
	 */
	private JButton getSaveButton() {
		JButton saveBtn = new JButton("保存");
		saveBtn.setBounds(875, 40, 60, 20);
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object[][] obj = table.getAllObject();
				List<RolePermRelDTO> list = new ArrayList<RolePermRelDTO>();
				for (int i=0; i<table.getRowCount(); i++) {
					RolePermRelDTO dto = permSV.queryByRoleAndContentId(roleDTO.getRoleId(), 
							(Integer) table.getRowIdByIndex(i));
					if (null == dto || null == dto.getEntity()) {
						dto = new RolePermRelDTO();
						dto.setRoleId(roleDTO.getRoleId());
						dto.setContentId((Integer) table.getRowIdByIndex(i));
					}
					dto.setCreateDate(new Date());
					dto.setPermPage(NumUtil.boolToInt(obj[i][1]));
					dto.setPermAdd(NumUtil.boolToInt(obj[i][2]));
					dto.setPermUpdate(NumUtil.boolToInt(obj[i][3]));
					dto.setPermDel(NumUtil.boolToInt(obj[i][4]));
					dto.setPermDetail(NumUtil.boolToInt(obj[i][5]));
					dto.setPermOther(NumUtil.boolToInt(obj[i][6]));
					list.add(dto);
				}
				for (RolePermRelDTO dto : list) {
					System.out.println(dto.getContentId() + "," + dto.getPermAdd() + "," + 
							dto.getPermPage() + "," + dto.getPermDel() + "," + dto.getPermDetail() + "," + dto.getPermOther());
				}
				permSV.saveOrUpdate(list);
				UserDTO adminUser = LPRUtil.getAdminUser();
				UserOperateDTO userOperateDTO = new UserOperateDTO(adminUser, 
						LPRConstant.ACTION_TYPE_MODIFY_PERM, LPRConstant.ACTION_SUCCESS);
				operateSV.saveOrUpdate(userOperateDTO);
				repaint();
			}
		});
		return saveBtn;
	}

	/**
	 * 权限结果页
	 * @return
	 */
	private JScrollPane getRolePermList() {
		List<ContentDTO> main = contentSV.queryAllMain();
		String[] name = {"权限名称","页面权限","新增权限","修改权限","删除权限", "详细权限", "其他权限"};
		Object[][] data = dtoToObj(main, name.length);
		Object[] rowId = ArrayUtil.getFirstColumn(data);
		data = ArrayUtil.redColumn(data);
		int nameLen = name.length;
	    
	    // 是否需要第一列选择列
		DataTableModel model = new DataTableModel(data, name, hasSelectColumn);
		model.setTableEditable(true);
		table = new LPRTable(model, rowId, hasSelectColumn);
		if (hasSelectColumn) {
			nameLen++;
			CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
		    EachRowRenderer rowRenderer = new EachRowRenderer();
		    rowRenderer.add(0, checkBoxRenderer);
		    table.getColumnModel().getColumn(0).setCellRenderer(rowRenderer);
		    table.getColumnModel().getColumn(0).setPreferredWidth(LPRConstant.TABLE_SELECT_COL_WIDTH);
		}
		
		CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
	    EachRowRenderer rowRenderer = new EachRowRenderer();
	    List<Integer> colEditable = new ArrayList<Integer>();
	    for (int i=0; i<nameLen; i++) {
	    		if (hasSelectColumn && i == 1) {
	    			continue;
	    		}
	    		if (!hasSelectColumn && i == 0) {
	    			continue;
	    		}
	    		colEditable.add(i);
	    		rowRenderer.add(i, checkBoxRenderer);
	    		table.getColumnModel().getColumn(i).setCellRenderer(rowRenderer);
	    }
		
		table.addMouseListener(new CheckBoxListener(table, colEditable));
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
	private Object[][] dtoToObj(List<ContentDTO> main, int length) {
		List<ContentDTO> dtos = new ArrayList<ContentDTO>();
		for (ContentDTO dto : main) {
			dtos.add(dto);
			List<ContentDTO> subs = contentSV.querySubByMainId(dto.getContentId());
			dtos.addAll(subs);
		}
		// 比表头多一列，为每行的行ID
		length++;
		Object[][] result = new Object[dtos.size()][length];
		RolePermRelDTO dto = null;
		for (int i=0; i<dtos.size(); i++) {
			dto = permSV.queryByRoleAndContentId(roleDTO.getRoleId(), dtos.get(i).getContentId());
			for (int j=0; j<length; j++) {
				switch (j) {
				case 0:
					// 每行的行ID
					result[i][j] = dtos.get(i).getContentId();
					break;
				case 1:
					result[i][j] = dtos.get(i).getContentName();
					break;
				case 2:
					// 页面权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermPage()));
					}
					break;
				case 3:
					// 新增权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermAdd()));
					}
					break;
				case 4:
					// 修改权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermUpdate()));
					}
					break;
				case 5:
					// 删除权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermDel()));
					}
					break;
				case 6:
					// 详细权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermDetail()));
					}
					break;
				case 7:
					// 其他权限
					if (null == dto || null == dto.getEntity()) {
						result[i][j] = new Boolean(false);
					} else {
						result[i][j] = new Boolean(NumUtil.intToBool(dto.getPermOther()));
					}
					break;
				default:
					break;
				}
			}
		}
		return result;
	}
}
