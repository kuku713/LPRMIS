package com.lprclient.core.DTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月22日 下午11:58:09  
 * @version V1.0    
 */
public class ContentDTO {
	
	private int id;
	private String contentName;
	private int subContents;
	private String contentAction;
	private int parentContentId;
	private int contentLevel;
	
	public ContentDTO() {
		
	}
	
	public ContentDTO(int id, String contentName, int subContents, String contentAction,
			int parentContentId, int contentLevel) {
		this.id = id;
		this.contentName = contentName;
		this.subContents = subContents;
		this.contentAction = contentAction;
		this.parentContentId = parentContentId;
		this.contentLevel = contentLevel;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContentName() {
		return contentName;
	}
	
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
	public int getSubContents() {
		return subContents;
	}
	
	public void setSubContents(int subContents) {
		this.subContents = subContents;
	}
	
	public String getContentAction() {
		return contentAction;
	}
	
	public void setContentAction(String contentAction) {
		this.contentAction = contentAction;
	}
	
	public int getParentContentId() {
		return parentContentId;
	}
	
	public void setParentContentId(int parentContentId) {
		this.parentContentId = parentContentId;
	}

	public int getContentLevel() {
		return contentLevel;
	}

	public void setContentLevel(int contentLevel) {
		this.contentLevel = contentLevel;
	}

}
