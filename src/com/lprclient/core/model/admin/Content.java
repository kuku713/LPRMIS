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
 * @date: 2015年6月29日 下午8:50:58  
 * @version V1.0    
 */
@Entity
@Table(name="ADMIN_CONTENT")
public class Content {
	
	@Id
	@Column(name = "CONTENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer contentId;
	@Column(name = "CONTENT_NAME")
	private String contentName;
	@Column(name = "CONTENT_ACTION")
	private String contentAction;
	@Column(name = "PARENT_CONTENT_ID")
	private Integer parentContentId;
	@Column(name = "CONTENT_LEVEL")
	private Integer contentLevel;
	@Column(name = "CONTENT_ORDER")
	private Integer contentOrder;
	
	public Integer getContentId() {
		return contentId;
	}
	
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	
	public String getContentName() {
		return contentName;
	}
	
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
	public String getContentAction() {
		return contentAction;
	}
	
	public void setContentAction(String contentAction) {
		this.contentAction = contentAction;
	}
	
	public Integer getParentContentId() {
		return parentContentId;
	}
	
	public void setParentContentId(Integer parentContentId) {
		this.parentContentId = parentContentId;
	}
	
	public Integer getContentLevel() {
		return contentLevel;
	}
	
	public void setContentLevel(Integer contentLevel) {
		this.contentLevel = contentLevel;
	}
	
	public Integer getContentOrder() {
		return contentOrder;
	}
	
	public void setContentOrder(Integer contentOrder) {
		this.contentOrder = contentOrder;
	}

}
