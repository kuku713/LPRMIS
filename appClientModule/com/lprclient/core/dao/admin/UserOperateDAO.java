package com.lprclient.core.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.model.admin.UserOperate;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月29日 下午3:43:31  
 * @version V1.0    
 */
public class UserOperateDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserOperateDAO.class);
	
	public static final String OPERATE_ID = "operateId";
	public static final String USER_ID = "userId";
	public static final String OPERATE_TYPE = "operateType";
	public static final String OPERATE_RESULT = "operateResult";
	public static final String OPERATE_DATE = "operateDate";
	
	public void saveOrUpdate(UserOperate userOperate) {
		if (null != userOperate) {
			if (null != userOperate.getOperateId()) {
				super.update(userOperate);
			} else {
				super.add(userOperate);
			}
		}
	}
	
	public void delById(int id) {
		UserOperate userOperate = queryByOperateId(id);
		super.delete(userOperate);
	}
	
	public UserOperate queryByOperateId(int id) {
		UserOperate userOperate = (UserOperate) super.queryById(UserOperate.class, id);
		return userOperate;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByUserId(int userId, int pageNow, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("from UserOperate o where o.").append(USER_ID)
		.append("=? order by o.").append(OPERATE_ID).append(" desc");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(userId)};
		return super.queryByPage(sql.toString(), param, pageNow, pageSize);
	}
	
	public long getCountByUserId(int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(o) from UserOperate o where o.").append(USER_ID)
		.append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{String.valueOf(userId)};
		return super.getCount(sql.toString(), param);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAll(int pageNow, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("from UserOperate");
		log.info("sql:\n{}", sql.toString());
		return super.queryByPage(sql.toString(), null, pageNow, pageSize);
	}
	
	public long getCount() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(op) from UserOperate op");
		log.info("sql:\n{}", sql.toString());
		return super.getCount(sql.toString(), null);
	}

}
