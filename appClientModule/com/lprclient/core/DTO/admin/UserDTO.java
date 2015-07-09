package com.lprclient.core.DTO.admin;

import java.util.Date;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.model.admin.User;
import com.lprclient.core.service.IRoleSV;
import com.lprclient.core.service.impl.RoleSVImpl;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月25日 下午10:50:38  
 * @version V1.0    
 */
public class UserDTO {
	
	private User user;
	private RoleDTO roleDTO;
	private IRoleSV roleSV = new RoleSVImpl();

	public UserDTO() {
		this.user = new User();
	}
	
	public UserDTO(User user) {
		this.user = user;
	}
	
	public User getEntity() {
		return user;
	}
	
	public Integer getUserId() {
		return user.getUserId();
	}

	public void setUserId(Integer userId) {
		this.user.setUserId(userId);
	}

	public String getUserName() {
		return user.getUserName();
	}

	public void setUserName(String userName) {
		this.user.setUserName(userName);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public void setPassword(String password) {
		this.user.setPassword(password);
	}

	public Integer getStatus() {
		return user.getStatus();
	}

	public void setStatus(Integer status) {
		this.user.setStatus(status);
	}

	public Date getCreateDate() {
		return user.getCreateDate();
	}

	public void setCreateDate(Date createDate) {
		this.user.setCreateDate(createDate);
	}

	public Integer getLoginTimes() {
		return user.getLoginTimes();
	}

	public void setLoginTimes(Integer loginTimes) {
		this.user.setLoginTimes(loginTimes);
	}

	public Date getLastLoginDate() {
		return user.getLastLoginDate();
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.user.setLastLoginDate(lastLoginDate);
	}
	
	public String getNickName() {
		return user.getNickName();
	}
	
	public void setNickName(String nickName) {
		this.user.setNickName(nickName);
	}
	
	public RoleDTO getRoleDTO() {
		roleDTO = roleSV.queryByUserId(getUserId());
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	
	public String getStatusDesc() {
		if (getStatus() == LPRConstant.ADMIN_USER_STATUS_NORMAL) {
			return LPRConstant.ADMIN_USER_STATUS_NORMAL_DESC;
		} else if (getStatus() == LPRConstant.ADMIN_USER_STATUS_CANCEL) {
			return LPRConstant.ADMIN_USER_STATUS_CANCEL_DESC;
		}
		return "";
	}

}
