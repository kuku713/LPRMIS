package com.lprclient.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lprclient.core.dao.admin.UserOperateDAO;
import com.lprclient.core.DTO.admin.UserOperateDTO;
import com.lprclient.core.model.admin.UserOperate;
import com.lprclient.core.service.IUserOperateSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午7:11:10  
 * @version V1.0    
 */
public class UserOperateSVImpl implements IUserOperateSV {
	
	private UserOperateDAO userOperateDAO = new UserOperateDAO();

	@Override
	public void saveOrUpdate(UserOperateDTO userOperateDTO) {
		userOperateDAO.saveOrUpdate(userOperateDTO.getEntity());
	}

	@Override
	public void delById(int id) {
		userOperateDAO.delById(id);
	}

	@Override
	public UserOperateDTO queryByOperateId(int operateId) {
		UserOperate userOperate = userOperateDAO.queryByOperateId(operateId);
		UserOperateDTO userOperateDTO = new UserOperateDTO(userOperate);
		return userOperateDTO;
	}

	@SuppressWarnings("rawtypes")
	public List<UserOperateDTO> queryByUserId(int userId, int pageNow,
			int pageSize) {
		List list = userOperateDAO.queryByUserId(userId, pageNow, pageSize);
		List<UserOperateDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<UserOperateDTO> queryAll(int pageNow, int pageSize) {
		List list = userOperateDAO.queryAll(pageNow, pageSize);
		List<UserOperateDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<UserOperateDTO> listToDTO(List list) {
		List<UserOperateDTO> result = new ArrayList<UserOperateDTO>();
		if (null != list && list.size() > 0) {
			for (int i=0; i<list.size(); i++) {
				UserOperate userOperate = (UserOperate) list.get(i);
				result.add(new UserOperateDTO(userOperate));
			}
		}
		return result;
	}

	@Override
	public long getCount() {
		return userOperateDAO.getCount();
	}

}
