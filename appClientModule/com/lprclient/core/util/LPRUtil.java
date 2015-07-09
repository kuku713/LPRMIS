package com.lprclient.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.DTO.admin.ContentDTO;
import com.lprclient.core.DTO.admin.UserDTO;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月20日 下午9:34:26  
 * @version V1.0    
 */
public class LPRUtil {
	
	static Map<String, Object> props = new HashMap<String, Object>();
	
	public static void setUserName(String userName) {
		if (StringUtil.isNotBlank(userName)) {
			props.put(LPRConstant.K_USERNAME, userName);
		}
	}
	
	public static String getUserName() {
		return (String) props.get(LPRConstant.K_USERNAME);
	}
	
	public static void setIsLogin(String isLogin) {
		if (StringUtil.isNotBlank(isLogin)) {
			props.put(LPRConstant.K_ISLOGIN, isLogin);
		}
	}
	
	public static String getIsLogin() {
		return (String) props.get(LPRConstant.K_ISLOGIN);
	}
	
	public static void setAdminUser(UserDTO userDTO) {
		if (null != userDTO.getEntity()) {
			props.put(LPRConstant.K_ADMINUSER, userDTO);
		}
	}
	
	public static UserDTO getAdminUser() {
		return (UserDTO) props.get(LPRConstant.K_ADMINUSER);
	}
	
	public static void setContentDTO(List<ContentDTO> dto) {
		if (null == dto || dto.size() == 0) {
			dto = new ArrayList<ContentDTO>();
		}
		props.put(LPRConstant.K_CONTENT, dto);
	}
	
	@SuppressWarnings("unchecked")
	public static List<ContentDTO> getContentDTO() {
		return (List<ContentDTO>) props.get(LPRConstant.K_CONTENT);
	}
	
}
