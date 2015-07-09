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
 * @date: 2015年6月29日 下午8:59:08  
 * @version V1.0    
 */
@Entity
@Table(name="ADMIN_ROLE_PERM_REL")
public class RolePermRel {
	
	@Id
	@Column(name = "PERM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer permId;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "CONTENT_ID")
	private Integer contentId;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(name = "PERM_PAGE")
	private Integer permPage;
	@Column(name = "PERM_ADD")
	private Integer permAdd;
	@Column(name = "PERM_UPDATE")
	private Integer permUpdate;
	@Column(name = "PERM_DEL")
	private Integer permDel;
	@Column(name = "PERM_DETAIL")
	private Integer permDetail;
	@Column(name = "PERM_OTHER")
	private Integer permOther;

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getPermPage() {
		return permPage;
	}

	public void setPermPage(Integer permPage) {
		this.permPage = permPage;
	}

	public Integer getPermAdd() {
		return permAdd;
	}

	public void setPermAdd(Integer permAdd) {
		this.permAdd = permAdd;
	}

	public Integer getPermUpdate() {
		return permUpdate;
	}

	public void setPermUpdate(Integer permUpdate) {
		this.permUpdate = permUpdate;
	}

	public Integer getPermDel() {
		return permDel;
	}

	public void setPermDel(Integer permDel) {
		this.permDel = permDel;
	}

	public Integer getPermDetail() {
		return permDetail;
	}

	public void setPermDetail(Integer permDetail) {
		this.permDetail = permDetail;
	}

	public Integer getPermOther() {
		return permOther;
	}

	public void setPermOther(Integer permOther) {
		this.permOther = permOther;
	}
	
}
