package com.lprclient.core.model.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午8:47:06  
 * @version V1.0    
 */
@Entity
@Table(name="ADMIN_USER_ROLE_REL")
public class UserRoleRel {
	
	@Id
	@Column(name = "REL_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer relId;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public Integer getRelId() {
		return relId;
	}
	
	public void setRelId(Integer relId) {
		this.relId = relId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
