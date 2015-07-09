package com.lprclient.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lprclient.core.DTO.admin.UserDTO;
import com.lprclient.core.dao.admin.UserDAO;
import com.lprclient.core.model.admin.User;
import com.lprclient.core.service.IUserSV;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月25日 下午11:37:38  
 * @version V1.0    
 */
public class UserSVImpl implements IUserSV {
	
	private UserDAO userDAO = new UserDAO();

	@Override
	public void saveOrUpdate(UserDTO userDTO) {
		userDAO.saveOrUpdate(userDTO.getEntity());
	}

	@Override
	public void delById(int id) {
		userDAO.delById(id);
	}

	@Override
	public UserDTO queryByUserId(int id) {
		User user = userDAO.queryByUserId(id);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	@Override
	public long queryCountByUserName(String userName) {
		return userDAO.queryCountByUserName(userName);
	}

	@Override
	public UserDTO login(String userName, String password) {
		User user = userDAO.login(userName, password);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	@Override
	public long getCount() {
		return userDAO.getCount();
	}

	@SuppressWarnings("rawtypes")
	public List<UserDTO> queryAll(int pageNow, int pageSize) {
		List list = userDAO.queryAll(pageNow, pageSize);
		List<UserDTO> result = listToDTO(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List<UserDTO> listToDTO(List list) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		if (null != list && list.size() > 0) {
			for (int i=0; i<list.size(); i++) {
				User user = (User) list.get(i);
				result.add(new UserDTO(user));
			}
		}
		return result;
	}

}
