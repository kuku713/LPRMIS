package com.lprclient.core.DTO.admin;

import com.lprclient.core.model.admin.Content;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午9:34:06  
 * @version V1.0    
 */
public class ContentDTO {
	
	private Content content;
	
	public ContentDTO() {
		this.content = new Content();
	}
	
	public ContentDTO(Content content) {
		this.content = content;
	}
	
	public Content getEntity() {
		return content;
	}
	
	public Integer getContentId() {
		return content.getContentId();
	}
	
	public void setContentId(Integer contentId) {
		this.content.setContentId(contentId);
	}
	
	public String getContentName() {
		return content.getContentName();
	}
	
	public void setContentName(String contentName) {
		this.content.setContentName(contentName);
	}
	
	public String getContentAction() {
		return content.getContentAction();
	}
	
	public void setContentAction(String contentAction) {
		this.content.setContentAction(contentAction);
	}
	
	public Integer getParentContentId() {
		return content.getParentContentId();
	}
	
	public void setParentContentId(Integer parentContentId) {
		this.content.setParentContentId(parentContentId);
	}
	
	public Integer getContentLevel() {
		return content.getContentLevel();
	}
	
	public void setContentLevel(Integer contentLevel) {
		this.content.setContentLevel(contentLevel);
	}
	
	public Integer getContentOrder() {
		return content.getContentOrder();
	}
	
	public void setContentOrder(Integer contentOrder) {
		this.content.setContentOrder(contentOrder);
	}

}
