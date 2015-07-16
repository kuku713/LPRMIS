package com.lprclient.core.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.model.admin.Role;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午11:13:23  
 * @version V1.0    
 */
public class RoleDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(RoleDAO.class);
	
	public static final String ROLE_ID = "roleId";
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_DESC = "roleDesc";
	
	public void saveOrUpdate(Role role) {
		if (null != role) {
			if (null != role.getRoleId()) {
				super.update(role);
			} else {
				super.add(role);
			}
		}
	}
	
	public Role queryByRoleId(int id) {
		Role role = (Role) super.queryById(Role.class, id);
		return role;
	}
	
	public void delById(int id) {
		Role role = queryByRoleId(id);
		super.delete(role);
	}
	
	public Role queryByUserId(int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select role from Role role, UserRoleRel rel")
		.append(" where role.").append(ROLE_ID).append("= rel.").append(UserRoleRelDAO.ROLE_ID)
		.append(" and rel.").append(UserRoleRelDAO.USER_ID).append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(userId)};
		return (Role) super.queryOne(sql.toString(), param);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByPage(int pageNow, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("from Role");
		log.info("sql:\n{}", sql.toString());
		return super.queryByPage(sql.toString(), null, pageNow, pageSize);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("from Role");
		log.info("sql:\n{}", sql.toString());
		return super.query(sql.toString(), null);
	}
	
	public long getCount() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(role) from Role role");
		log.info("sql:\n{}", sql.toString());
		return super.getCount(sql.toString(), null);
	}

}
