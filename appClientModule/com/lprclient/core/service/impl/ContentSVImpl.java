package com.lprclient.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lprclient.core.DTO.admin.ContentDTO;
import com.lprclient.core.dao.admin.ContentDAO;
import com.lprclient.core.model.admin.Content;
import com.lprclient.core.service.IContentSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 下午7:20:24  
 * @version V1.0    
 */
public class ContentSVImpl implements IContentSV {
	
	private ContentDAO contentDAO = new ContentDAO();

	@Override
	public void saveOrUpdate(ContentDTO contentDTO) {
		contentDAO.saveOrUpdate(contentDTO.getEntity());
	}

	@Override
	public void delById(int id) {
		contentDAO.delById(id);
	}

	@Override
	public ContentDTO queryByContentId(int contentId) {
		Content content = contentDAO.queryByContentId(contentId);
		ContentDTO contentDTO = new ContentDTO(content);
		return contentDTO;
	}

	@SuppressWarnings("rawtypes")
	public List<ContentDTO> queryByUserId(int userId) {
		List list = contentDAO.queryByUserId(userId);
		List<ContentDTO> result = listToDTO(list);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public List<ContentDTO> queryAll() {
		List list = contentDAO.queryAll();
		List<ContentDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<ContentDTO> queryAllMain() {
		List list = contentDAO.queryAllMain();
		List<ContentDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<ContentDTO> querySubByMainId(int mainId) {
		List list = contentDAO.querySubByMainId(mainId);
		List<ContentDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<ContentDTO> listToDTO(List list) {
		List<ContentDTO> result = new ArrayList<ContentDTO>();
		if (null != list && list.size() > 0) {
			for (int i=0; i<list.size(); i++) {
				Content content = (Content) list.get(i);
				result.add(new ContentDTO(content));
			}
		}
		return result;
	}

}
