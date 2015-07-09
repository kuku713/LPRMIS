package com.lprclient.core.dao.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.model.admin.User;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月24日 下午9:11:44  
 * @version V1.0    
 */
public class UserDAO extends BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	
	public static final String USER_ID = "userId";
	public static final String USERNAME = "userName";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String CREATE_DATE = "create_date";
	public static final String LOGIN_TIMES = "login_times";
	public static final String LAST_LOGIN_DATE = "last_login_date";
	
	public void saveOrUpdate(User user) {
		if (null != user) {
			if (null != user.getUserId()) {
				super.update(user);
			} else {
				super.add(user);
			}
		}
	}
	
	public void delById(int id) {
		User user = queryByUserId(id);
		super.delete(user);
	}
	
	public User queryByUserId(int id) {
		User user = (User) super.queryById(User.class, id);
		return user;
	}
	
	public long queryCountByUserName(String userName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(u) from User u where u.").append(USERNAME).append("=? ");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{userName};
		return super.getCount(sql.toString(), param);
	}
	
	public User login(String userName, String password) {
		StringBuffer sql = new StringBuffer();
		sql.append("from User u where u.").append(USERNAME)
		.append("=? and u.").append(PASSWORD).append("=?");
		log.info("sql:\n{}", sql.toString());
		String[] param = new String[]{userName, password};
		return (User) super.queryOne(sql.toString(), param);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryAll(int pageNow, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("from User");
		log.info("sql:\n{}", sql.toString());
		return super.queryByPage(sql.toString(), null, pageNow, pageSize);
	}
	
	public long getCount() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(user) from User user");
		log.info("sql:\n{}", sql.toString());
		return super.getCount(sql.toString(), null);
	}
	
//	public List<User> queryByRoleId(int roleId) {
//		StringBuffer sbff = new StringBuffer();
//		sbff.append("select user from User user, UserRoleRel rel where u.").append(USER_ID).append("=? ");
//		
//	}

}
