package com.lprclient.core.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.model.admin.UserRoleRel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 上午12:21:26  
 * @version V1.0    
 */
public class UserRoleRelDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserRoleRelDAO.class);
	
	public static final String REL_ID = "relId";
	public static final String USER_ID = "userId";
	public static final String ROLE_ID = "roleId";
	public static final String STATUS = "status";
	public static final String CREATE_DATE = "createDate";
	
	public void saveOrUpdate(UserRoleRel rel) {
		if (null != rel) {
			if (null != rel.getRelId()) {
				super.update(rel);
			} else {
				super.add(rel);
			}
		}
	}
	
	public UserRoleRel queryByRelId(int id) {
		UserRoleRel rel = (UserRoleRel) super.queryById(UserRoleRel.class, id);
		return rel;
	}
	
	public void delById(int id) {
		UserRoleRel rel = queryByRelId(id);
		super.delete(rel);
	}
	
	public UserRoleRel queryByUserId(int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("from UserRoleRel r where r.").append(USER_ID)
		.append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(userId)};
		return (UserRoleRel) super.queryOne(sql.toString(), param);
	}

}
