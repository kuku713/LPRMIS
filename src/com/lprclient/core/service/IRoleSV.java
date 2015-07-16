package com.lprclient.core.service;

import java.util.List;

import com.lprclient.core.DTO.admin.RoleDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:12:22  
 * @version V1.0    
 */
public interface IRoleSV {
	
	public void saveOrUpdate(RoleDTO roleDTO);
	
	public void delById(int id);
	
	public RoleDTO queryByRoleId(int roleId);
	
	public RoleDTO queryByUserId(int userId);
	
	public List<RoleDTO> queryByPage(int pageNow, int pageSize);
	
	public List<RoleDTO> queryAll();
	
	public long getCount();

}
