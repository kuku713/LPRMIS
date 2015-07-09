package com.lprclient.core.service;

import java.util.List;

import com.lprclient.core.DTO.admin.UserOperateDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午7:04:15  
 * @version V1.0    
 */
public interface IUserOperateSV {
	
	public void saveOrUpdate(UserOperateDTO userOperateDTO);
	
	public void delById(int id);
	
	public UserOperateDTO queryByOperateId(int operateId);
	
	public List<UserOperateDTO> queryByUserId(int userId, int pageNow, int pageSize);
	
	public List<UserOperateDTO> queryAll(int pageNow, int pageSize);
	
	public long getCount();

}
