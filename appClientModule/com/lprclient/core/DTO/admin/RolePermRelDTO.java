package com.lprclient.core.DTO.admin;

import java.util.Date;

import com.lprclient.core.model.admin.RolePermRel;
import com.lprclient.core.service.IContentSV;
import com.lprclient.core.service.impl.ContentSVImpl;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午9:35:27  
 * @version V1.0    
 */
public class RolePermRelDTO {
	
	private RolePermRel rel;
	private IContentSV contentSV = new ContentSVImpl();
	
	public RolePermRelDTO() {
		this.rel = new RolePermRel();
	}
	
	public RolePermRelDTO(RolePermRel rel) {
		this.rel = rel;
	}
	
	public RolePermRel getEntity() {
		return rel;
	}
	
	public Integer getPermId() {
		return rel.getPermId();
	}

	public void setPermId(Integer permId) {
		this.rel.setPermId(permId);
	}

	public Integer getRoleId() {
		return rel.getRoleId();
	}

	public void setRoleId(Integer roleId) {
		this.rel.setRoleId(roleId);
	}

	public Integer getContentId() {
		return rel.getContentId();
	}

	public void setContentId(Integer contentId) {
		this.rel.setContentId(contentId);
	}

	public Date getCreateDate() {
		return rel.getCreateDate();
	}

	public void setCreateDate(Date createDate) {
		this.rel.setCreateDate(createDate);
	}

	public Integer getPermPage() {
		return rel.getPermPage();
	}

	public void setPermPage(Integer permPage) {
		this.rel.setPermPage(permPage);
	}

	public Integer getPermAdd() {
		return rel.getPermAdd();
	}

	public void setPermAdd(Integer permAdd) {
		this.rel.setPermAdd(permAdd);
	}

	public Integer getPermUpdate() {
		return rel.getPermUpdate();
	}

	public void setPermUpdate(Integer permUpdate) {
		this.rel.setPermUpdate(permUpdate);
	}

	public Integer getPermDel() {
		return rel.getPermDel();
	}

	public void setPermDel(Integer permDel) {
		this.rel.setPermDel(permDel);
	}

	public Integer getPermDetail() {
		return rel.getPermDetail();
	}

	public void setPermDetail(Integer permDetail) {
		this.rel.setPermDetail(permDetail);
	}

	public Integer getPermOther() {
		return rel.getPermOther();
	}

	public void setPermOther(Integer permOther) {
		this.rel.setPermOther(permOther);
	}
	
	public ContentDTO getContentDTO() {
		return contentSV.queryByContentId(getContentId());
	}

}
