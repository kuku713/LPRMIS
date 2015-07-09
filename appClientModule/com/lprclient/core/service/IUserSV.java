package com.lprclient.core.service;

import java.util.List;

import com.lprclient.core.DTO.admin.UserDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月25日 下午10:47:38  
 * @version V1.0    
 */
public interface IUserSV {
	
	public void saveOrUpdate(UserDTO userDTO);
	
	public void delById(int id);
	
	public UserDTO queryByUserId(int id); 
	
	public long queryCountByUserName(String userName);
	
	public UserDTO login(String userName, String password);
	
	public long getCount();
	
	public List<UserDTO> queryAll(int pageNow, int pageSize);

}
