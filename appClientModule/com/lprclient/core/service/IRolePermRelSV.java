package com.lprclient.core.service;

import java.util.List;

import com.lprclient.core.DTO.admin.RolePermRelDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:23:20  
 * @version V1.0    
 */
public interface IRolePermRelSV {
	
	public void saveOrUpdate(RolePermRelDTO relDTO);
	
	public void saveOrUpdate(List<RolePermRelDTO> relDTOs);
	
	public RolePermRelDTO queryByPermId(int permId);
	
	public RolePermRelDTO queryByRoleAndContentId(int roleId, int contentId);
	
	public void delById(int id);
	
	public List<RolePermRelDTO> queryByRoleId(int roleId);
	
}
