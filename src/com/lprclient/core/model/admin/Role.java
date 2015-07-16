package com.lprclient.core.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午8:42:58  
 * @version V1.0    
 */
@Entity
@Table(name="ADMIN_ROLE") 
public class Role {
	
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer roleId;
	@Column(name = "ROLE_NAME")
	private String roleName;
	@Column(name = "ROLE_DESC")
	private String roleDesc;
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleDesc() {
		return roleDesc;
	}
	
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
