package com.lprclient.core.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.LPRConstant;
import com.lprclient.core.model.admin.Content;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月30日 上午12:18:12  
 * @version V1.0    
 */
public class ContentDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ContentDAO.class);
	
	public static final String CONTENT_ID = "contentId";
	public static final String CONTENT_NAME = "contentName";
	public static final String CONTENT_ACTION = "contentAction";
	public static final String PARENT_CONTENT_ID = "parentContentId";
	public static final String CONTENT_LEVEL = "contentLevel";
	public static final String CONTENT_ORDER = "contentOrder";
	
	public void saveOrUpdate(Content content) {
		if (null != content) {
			if (null != content.getContentId()) {
				super.update(content);
			} else {
				super.add(content);
			}
		}
	}
	
	public Content queryByContentId(int id) {
		Content content = (Content) super.queryById(Content.class, id);
		return content;
	}
	
	public void delById(int id) {
		Content content = queryByContentId(id);
		super.delete(content);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByUserId(int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select con from Content con, RolePermRel permRel, UserRoleRel roleRel")
		.append(" where con.").append(CONTENT_ID).append("=permRel.").append(RolePermRelDAO.CONTENT_ID)
		.append(" and permRel.").append(RolePermRelDAO.ROLE_ID).append("=roleRel.").append(UserRoleRelDAO.ROLE_ID)
		.append(" and roleRel.").append(UserRoleRelDAO.USER_ID).append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(userId)};
		return super.query(sql.toString(), param);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("from Content con order by con.").append(CONTENT_ID).append(" desc");
		log.info("sql:\n{}", sql.toString());
		return super.query(sql.toString(), null);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAllMain() {
		StringBuffer sql = new StringBuffer();
		sql.append("from Content con where con.").append(CONTENT_LEVEL)
		.append("=").append(LPRConstant.CONTENT_LEVEL_MAIN)
		.append(" order by con.").append(CONTENT_ORDER).append(" asc");
		log.info("sql:\n{}", sql.toString());
		return super.query(sql.toString(), null);
	}
	
	@SuppressWarnings("rawtypes")
	public List querySubByMainId(int mainId) {
		StringBuffer sql = new StringBuffer();
		sql.append("from Content con where con.").append(CONTENT_LEVEL)
		.append("=").append(LPRConstant.CONTENT_LEVEL_SUB)
		.append(" and con.").append(PARENT_CONTENT_ID).append("=?")
		.append(" order by con.").append(CONTENT_ORDER).append(" asc");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(mainId)};
		return super.query(sql.toString(), param);
	}

}
