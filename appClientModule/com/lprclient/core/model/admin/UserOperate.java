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
 * @date: 2015年6月27日 下午11:16:17  
 * @version V1.0    
 */
@Entity
@Table(name="ADMIN_USER_OPERATE") 
public class UserOperate {
	
	@Id
	@Column(name = "OPERATE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer operateId;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "OPERATE_TYPE")
	private String operateType;
	@Column(name = "OPERATE_RESULT")
	private Integer operateResult;
	@Column(name = "OPERATE_DATE")
	private Date operateDate;
	
	public Integer getOperateId() {
		return operateId;
	}
	
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getOperateType() {
		return operateType;
	}
	
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	public Integer getOperateResult() {
		return operateResult;
	}
	
	public void setOperateResult(Integer operateResult) {
		this.operateResult = operateResult;
	}
	
	public Date getOperateDate() {
		return operateDate;
	}
	
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
}
