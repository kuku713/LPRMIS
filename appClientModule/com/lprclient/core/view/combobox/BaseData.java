package com.lprclient.core.view.combobox;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年7月6日 下午5:40:33  
 * @version V1.0    
 */
public class BaseData {
	
	private Integer key;
	private String value;
	
	public BaseData() {};
	
	public BaseData(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
