package com.lprclient.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lprclient.core.DTO.admin.RoleDTO;
import com.lprclient.core.dao.admin.RoleDAO;
import com.lprclient.core.model.admin.Role;
import com.lprclient.core.service.IRoleSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:16:22  
 * @version V1.0    
 */
public class RoleSVImpl implements IRoleSV {
	
	private RoleDAO relDAO = new RoleDAO();

	@Override
	public void saveOrUpdate(RoleDTO roleDTO) {
		relDAO.saveOrUpdate(roleDTO.getEntity());
	}

	@Override
	public void delById(int id) {
		relDAO.delById(id);
	}

	@Override
	public RoleDTO queryByRoleId(int roleId) {
		Role role = relDAO.queryByRoleId(roleId);
		RoleDTO dto = new RoleDTO(role);
		return dto;
	}
	
	@Override
	public RoleDTO queryByUserId(int userId) {
		Role role = relDAO.queryByUserId(userId);
		RoleDTO dto = new RoleDTO(role);
		return dto;
	}

	@SuppressWarnings("rawtypes")
	public List<RoleDTO> queryByPage(int pageNow, int pageSize) {
		List list = relDAO.queryByPage(pageNow, pageSize);
		List<RoleDTO> result = listToDTO(list);
		return result;
	}
	

	@SuppressWarnings("rawtypes")
	public List<RoleDTO> queryAll() {
		List list = relDAO.queryAll();
		List<RoleDTO> result = listToDTO(list);
		return result;
	}

	@Override
	public long getCount() {
		return relDAO.getCount();
	}
	
	@SuppressWarnings("rawtypes")
	public List<RoleDTO> listToDTO(List list) {
		List<RoleDTO> result = new ArrayList<RoleDTO>();
		if (null != list && list.size() > 0) {
			for (int i=0; i<list.size(); i++) {
				Role role = (Role) list.get(i);
				result.add(new RoleDTO(role));
			}
		}
		return result;
	}

}
