package com.lprclient.core.DTO.admin;

import java.util.Date;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.model.admin.UserOperate;
import com.lprclient.core.service.IUserSV;
import com.lprclient.core.service.impl.UserSVImpl;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午3:36:44  
 * @version V1.0    
 */
public class UserOperateDTO {
	
	private UserOperate userOperate;
	private IUserSV userSV = new UserSVImpl();
	
	public UserOperateDTO() {
		this.userOperate = new UserOperate();
	}
	
	public UserOperateDTO(UserOperate userOperate) {
		this.userOperate = userOperate;
	}
	
	public UserOperateDTO(UserDTO userDTO, 
			String operateType, int operateResult) {
		userOperate = new UserOperate();
		userOperate.setUserId(userDTO.getUserId());
		userOperate.setOperateType(operateType);
		userOperate.setOperateResult(operateResult);
		userOperate.setOperateDate(new Date());
	}
	
	public UserOperate getEntity() {
		return userOperate;
	}
	
	public Integer getOperateId() {
		return userOperate.getOperateId();
	}
	
	public void setOperateId(Integer operateId) {
		this.userOperate.setOperateId(operateId);
	}
	
	public Integer getUserId() {
		return userOperate.getUserId();
	}
	
	public void setUserId(Integer userId) {
		this.userOperate.setUserId(userId);
	}
	
	public String getOperateType() {
		return userOperate.getOperateType();
	}
	
	public void setOperateType(String operateType) {
		this.userOperate.setOperateType(operateType);
	}
	
	public Integer getOperateResult() {
		return userOperate.getOperateResult();
	}
	
	public void setOperateResult(Integer operateResult) {
		this.userOperate.setOperateResult(operateResult);
	}
	
	public Date getOperateDate() {
		return userOperate.getOperateDate();
	}
	
	public void setOperateDate(Date operateDate) {
		this.userOperate.setOperateDate(operateDate);
	}

	public UserDTO getUserDTO() {
		return userSV.queryByUserId(getUserId());
	}
	
	public String getOperateResultDesc() {
		if (getOperateResult() == LPRConstant.ACTION_SUCCESS) {
			return LPRConstant.ACTION_SUCCESS_DESC;
		} else {
			return LPRConstant.ACTION_FAIL_DESC;
		}
	}
	
}
