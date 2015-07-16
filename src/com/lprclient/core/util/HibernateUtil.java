package com.lprclient.core.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月24日 上午12:52:07  
 * @version V1.0    
 */
public class HibernateUtil {
	
	private static AnnotationConfiguration annotationConfiguration;
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			annotationConfiguration = new AnnotationConfiguration();
			annotationConfiguration.configure("config/hibernate.cfg.xml");
			sessionFactory = annotationConfiguration.buildSessionFactory();
		} catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	   
    public static Session getSession() throws HibernateException {
    		return getSessionFactory().getCurrentSession();
    }

}
