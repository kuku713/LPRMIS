package com.lprclient.core.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lprclient.core.util.HibernateUtil;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月25日 下午7:17:10  
 * @version V1.0    
 */
public class BaseDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);
	
	private Session session = null;
	private Transaction tran = null;
	
	/**
	 * 添加数据
	 * @param obj 
	 * @return
	 */
	protected boolean add(Object obj) {
		boolean result = false;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			result = true;
			log.info("save successful");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("save failed", e);
			if (null != tran) {
				tran.rollback();
				log.error("roll back");
			}
		}
		return result;
	}
	
	/**
	 * 修改数据
	 * @param obj 
	 * @return
	 */
	protected boolean update(Object obj) {
		boolean result = false;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			result = true;
			log.info("update successful");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("update failed", e);
			if (null != tran) {
				tran.rollback();
				log.error("roll back");
			}
		}
		return result;
	}
	
	/**
	 * 根据id查询数据
	 * @param c
	 * @param id 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Object queryById(Class c, int id) {
		Object obj = null;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			obj = session.get(c, id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("query failed", e);
		}
		return obj;
	}
	
	/**
	 * 查询多条记录
	 * @param sql
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> query(String sql, String[] param) {
		List<T> list = new ArrayList<T>();
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(sql);
			if (null != param) {
				for (int i=0; i<param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("query failed", e);
		}
		return list;
	}
	
	/**
	 * 查询一条记录
	 * @param sql
	 * @param param
	 * @return
	 */
	protected Object queryOne(String sql, String[] param) {
		Object obj = null;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(sql);
			if (null != param) {
				for (int i=0; i<param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			obj = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("query failed", e);
		}
		return obj;
	}
	
	/**
	 * 删除数据
	 * @param obj
	 * @return
	 */
	protected boolean delete(Object obj) {
		boolean result = false;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
			result = true;
			log.info("delete successful");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("delete failed", e);
			if (null != tran) {
				tran.rollback();
				log.error("roll back");
			}
		}
		return result;
	}
	
	/**
	 * 分页查找
	 * @param sql
	 * @param param
	 * @param page
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> queryByPage(String sql, String[] param, int pageNow, int pageSize) {
		List<T> list = new ArrayList<T>();
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(sql);
			if (null != param) {
				for (int i=0; i<param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			query.setFirstResult((pageNow-1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("query failed", e);
		}
		return list;
	}
	
	/**
	 * 返回结果集大小
	 * @param sql
	 * @param param
	 * @return
	 */
	protected long getCount(String sql, String[] param) {
		long count = 0;
		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(sql);
			if (null != param) {
				for (int i=0; i<param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("query failed", e);
		}
		return count;
	}
	
}
