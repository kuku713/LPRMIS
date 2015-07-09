package com.lprclient.core.DTO.admin;

import java.util.Date;

import com.lprclient.core.model.admin.UserRoleRel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午9:35:57  
 * @version V1.0    
 */
public class UserRoleRelDTO {
	
	private UserRoleRel rel;
	
	public UserRoleRelDTO() {
		this.rel = new UserRoleRel();
	}
	
	public UserRoleRelDTO(UserRoleRel rel) {
		this.rel = rel;
	}
	
	public UserRoleRel getEntity() {
		return rel;
	}
	
	public Integer getRelId() {
		return rel.getRelId();
	}
	
	public void setRelId(Integer relId) {
		this.rel.setRelId(relId);
	}
	
	public Integer getUserId() {
		return rel.getUserId();
	}
	
	public void setUserId(Integer userId) {
		this.rel.setUserId(userId);
	}
	
	public Integer getRoleId() {
		return rel.getRoleId();
	}
	
	public void setRoleId(Integer roleId) {
		this.rel.setRoleId(roleId);
	}
	
	public Integer getStatus() {
		return rel.getStatus();
	}
	
	public void setStatus(Integer status) {
		this.rel.setStatus(status);
	}
	
	public Date getCreateDate() {
		return rel.getCreateDate();
	}
	
	public void setCreateDate(Date createDate) {
		this.rel.setCreateDate(createDate);
	}

}
