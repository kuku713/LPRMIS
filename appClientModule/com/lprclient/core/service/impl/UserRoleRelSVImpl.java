package com.lprclient.core.service.impl;

import com.lprclient.core.DTO.admin.UserRoleRelDTO;
import com.lprclient.core.dao.admin.UserRoleRelDAO;
import com.lprclient.core.model.admin.UserRoleRel;
import com.lprclient.core.service.IUserRoleRelSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:10:52  
 * @version V1.0    
 */
public class UserRoleRelSVImpl implements IUserRoleRelSV {
	
	private UserRoleRelDAO relDAO = new UserRoleRelDAO();

	@Override
	public void saveOrUpdate(UserRoleRelDTO relDTO) {
		relDAO.saveOrUpdate(relDTO.getEntity());
	}

	@Override
	public void delById(int id) {
		relDAO.delById(id);
	}

	@Override
	public UserRoleRelDTO queryByRelId(int id) {
		UserRoleRel rel = relDAO.queryByRelId(id);
		UserRoleRelDTO dto = new UserRoleRelDTO(rel);
		return dto;
	}

	@Override
	public UserRoleRelDTO queryByUserId(int userId) {
		UserRoleRel rel = relDAO.queryByUserId(userId);
		UserRoleRelDTO dto = new UserRoleRelDTO(rel);
		return dto;
	}

}
