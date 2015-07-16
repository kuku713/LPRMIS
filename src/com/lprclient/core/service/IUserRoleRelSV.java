package com.lprclient.core.service;

import com.lprclient.core.DTO.admin.UserRoleRelDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:03:18  
 * @version V1.0    
 */
public interface IUserRoleRelSV {
	
	public void saveOrUpdate(UserRoleRelDTO relDTO);
	
	public void delById(int id);
	
	public UserRoleRelDTO queryByRelId(int id);
	
	public UserRoleRelDTO queryByUserId(int userId);

}
