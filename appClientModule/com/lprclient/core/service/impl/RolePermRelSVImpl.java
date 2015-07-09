package com.lprclient.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lprclient.core.DTO.admin.RolePermRelDTO;
import com.lprclient.core.dao.admin.RolePermRelDAO;
import com.lprclient.core.model.admin.RolePermRel;
import com.lprclient.core.service.IRolePermRelSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:27:11  
 * @version V1.0    
 */
public class RolePermRelSVImpl implements IRolePermRelSV {
	
	private RolePermRelDAO relDAO = new RolePermRelDAO();

	@Override
	public void saveOrUpdate(RolePermRelDTO relDTO) {
		relDAO.saveOrUpdate(relDTO.getEntity());
	}
	
	@Override
	public void saveOrUpdate(List<RolePermRelDTO> relDTOs) {
		if (null != relDTOs && relDTOs.size() > 0) {
			for (RolePermRelDTO dto : relDTOs) {
				saveOrUpdate(dto);
			}
		}
	}

	@Override
	public RolePermRelDTO queryByPermId(int permId) {
		RolePermRel rel = relDAO.queryByPermId(permId);
		RolePermRelDTO dto = new RolePermRelDTO(rel);
		return dto;
	}

	@Override
	public RolePermRelDTO queryByRoleAndContentId(int roleId, int contentId) {
		RolePermRel rel = relDAO.queryByRoleAndContentId(roleId, contentId);
		RolePermRelDTO dto = new RolePermRelDTO(rel);
		return dto;
	}

	@Override
	public void delById(int id) {
		relDAO.delById(id);
	}

	@SuppressWarnings("rawtypes")
	public List<RolePermRelDTO> queryByRoleId(int roleId) {
		List list = relDAO.queryByRoleId(roleId);
		List<RolePermRelDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<RolePermRelDTO> listToDTO(List list) {
		List<RolePermRelDTO> result = new ArrayList<RolePermRelDTO>();
		if (null != list && list.size() > 0) {
			for (int i=0; i<list.size(); i++) {
				RolePermRel rel = (RolePermRel) list.get(i);
				result.add(new RolePermRelDTO(rel));
			}
		}
		return result;
	}

}
