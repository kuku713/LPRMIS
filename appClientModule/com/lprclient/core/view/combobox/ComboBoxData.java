package com.lprclient.core.view.combobox;

import com.lprclient.core.model.admin.Content;
import com.lprclient.core.model.admin.Role;
import com.lprclient.core.model.admin.User;
import com.lprclient.core.model.admin.UserOperate;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月6日 下午3:23:06  
 * @version V1.0    
 */
public class ComboBoxData {
	
	private Object obj;   // 下拉列表对象
	private String text;  // 下拉列表显示
	private Integer key;  // 下拉列表ID
	
	public ComboBoxData(Object obj) {
		this.obj = obj;
		if (obj instanceof Role) {
			this.key = ((Role) obj).getRoleId();
			this.text = ((Role) obj).getRoleName();
		} else if (obj instanceof Content) {
			this.key = ((Content) obj).getContentId();
			this.text = ((Content) obj).getContentName();
		} else if (obj instanceof User) {
			this.key = ((User) obj).getUserId();
			this.text = ((User) obj).getUserName();
		} else if (obj instanceof UserOperate) {
			this.key = ((UserOperate) obj).getOperateId();
			this.text = ((UserOperate) obj).getOperateType();
		} else if (obj instanceof BaseData) {
			this.key = ((BaseData) obj).getKey();
			this.text = ((BaseData) obj).getValue();
		}
	}
	
	public Object getObj() {
		return obj;
	}
	
	public String getText() {
		return text;
	}
	
	public Integer getKey() {
		return key;
	}

}
