package com.lprclient.core.service;

import java.util.List;

import com.lprclient.core.DTO.admin.ContentDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:16:41  
 * @version V1.0    
 */
public interface IContentSV {
	
	public void saveOrUpdate(ContentDTO contentDTO);
	
	public void delById(int id);
	
	public ContentDTO queryByContentId(int contentId);
	
	public List<ContentDTO> queryByUserId(int userId);
	
	public List<ContentDTO> queryAll();
	
	public List<ContentDTO> queryAllMain();
	
	public List<ContentDTO> querySubByMainId(int mainId);

}
