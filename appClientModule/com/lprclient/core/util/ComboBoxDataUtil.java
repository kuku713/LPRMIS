package com.lprclient.core.util;

import java.util.List;
import java.util.Vector;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.view.combobox.BaseData;
import com.lprclient.core.view.combobox.ComboBoxData;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月7日 下午2:04:35  
 * @version V1.0    
 */
public class ComboBoxDataUtil {
	
	/**
	 * 返回角色下拉列表数据
	 * @param dtos
	 * @return
	 */
	public static Vector<ComboBoxData> listToData(List<RoleDTO> dtos) {
		Vector<ComboBoxData> result = new Vector<ComboBoxData>();
		if (null != dtos) {
			for (RoleDTO dto : dtos) {
				result.add(new ComboBoxData(dto.getEntity()));
			}
		}
		return result;
	}
	
	/**
	 * 返回是否下拉列表
	 * @return
	 */
	public static Vector<ComboBoxData> getYesOrNo() {
		Vector<ComboBoxData> result = new Vector<ComboBoxData>();
		BaseData yes = new BaseData(1, "是");
		BaseData no = new BaseData(0, "否");
		result.add(new ComboBoxData(yes));
		result.add(new ComboBoxData(no));
		return result;
	}
	
	/**
	 * 返回用户状态下拉列表
	 * @return
	 */
	public static Vector<ComboBoxData> getAdminUserStatus() {
		Vector<ComboBoxData> result = new Vector<ComboBoxData>();
		BaseData normal = new BaseData(LPRConstant.ADMIN_USER_STATUS_NORMAL, 
				LPRConstant.ADMIN_USER_STATUS_NORMAL_DESC);
		BaseData cancel = new BaseData(LPRConstant.ADMIN_USER_STATUS_CANCEL, 
				LPRConstant.ADMIN_USER_STATUS_CANCEL_DESC);
		result.add(new ComboBoxData(normal));
		result.add(new ComboBoxData(cancel));
		return result;
	}

}
