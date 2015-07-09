package com.lprclient.core.DTO.admin;

import com.lprclient.core.model.admin.Role;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午9:34:20  
 * @version V1.0    
 */
public class RoleDTO {
	
	private Role role;
	
	public RoleDTO() {
		this.role = new Role();
	}
	
	public RoleDTO(Role role) {
		this.role = role;
	}
	
	public Role getEntity() {
		return role;
	}
	
	public Integer getRoleId() {
		return role.getRoleId();
	}
	
	public void setRoleId(Integer roleId) {
		this.role.setRoleId(roleId);
	}
	
	public String getRoleName() {
		return role.getRoleName();
	}
	
	public void setRoleName(String roleName) {
		this.role.setRoleName(roleName);
	}
	
	public String getRoleDesc() {
		return role.getRoleDesc();
	}
	
	public void setRoleDesc(String roleDesc) {
		this.role.setRoleDesc(roleDesc);
	}

}
