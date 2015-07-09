package com.lprclient.core.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.model.admin.RolePermRel;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午11:55:10  
 * @version V1.0    
 */
public class RolePermRelDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(RolePermRelDAO.class);
	
	public static final String PERM_ID = "permId";
	public static final String ROLE_ID = "roleId";
	public static final String CONTENT_ID = "contentId";
	public static final String CREATE_DATE = "createDate";
	public static final String PERM_PAGE = "permPage";
	public static final String PERM_ADD = "permAdd";
	public static final String PERM_UPDATE = "permUpdate";
	public static final String PERM_DEL = "permDel";
	public static final String PERM_DETAIL = "permDetail";
	public static final String PERM_OTHER = "permOther";
	
	public void saveOrUpdate(RolePermRel rel) {
		if (null != rel) {
			if (null != rel.getPermId()) {
				super.update(rel);
			} else {
				super.add(rel);
			}
		}
	}
	
	public RolePermRel queryByPermId(int id) {
		RolePermRel rel = (RolePermRel) super.queryById(RolePermRel.class, id);
		return rel;
	}
	
	public RolePermRel queryByRoleAndContentId(int roleId, int contentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("from RolePermRel p where p.").append(ROLE_ID)
		.append("=? and p.").append(CONTENT_ID).append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(roleId), String.valueOf(contentId)};
		return (RolePermRel) super.queryOne(sql.toString(), param);
	}
	
	public void delById(int id) {
		RolePermRel rel = queryByPermId(id);
		super.delete(rel);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByRoleId(int roleId) {
		StringBuffer sql = new StringBuffer();
		sql.append("from RolePermRel p where p.").append(ROLE_ID)
		.append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(roleId)};
		return super.query(sql.toString(), param);
	}
	
}
