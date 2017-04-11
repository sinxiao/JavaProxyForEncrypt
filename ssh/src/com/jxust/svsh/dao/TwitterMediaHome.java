package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.TwitterMedia;

/**
 * Home object for domain model class TwitterMedia.
 * @see com.jxust.svsh.dao.TwitterMedia
 * @author Hibernate Tools
 */
public class TwitterMediaHome {

	private static final Log log = LogFactory.getLog(TwitterMediaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TwitterMedia transientInstance) {
		log.debug("persisting TwitterMedia instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TwitterMedia instance) {
		log.debug("attaching dirty TwitterMedia instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TwitterMedia instance) {
		log.debug("attaching clean TwitterMedia instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TwitterMedia persistentInstance) {
		log.debug("deleting TwitterMedia instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TwitterMedia merge(TwitterMedia detachedInstance) {
		log.debug("merging TwitterMedia instance");
		try {
			TwitterMedia result = (TwitterMedia) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

//	public TwitterMedia findById(com.jxust.svsh.dao.TwitterMediaId id) {
//		log.debug("getting TwitterMedia instance with id: " + id);
//		try {
//			TwitterMedia instance = (TwitterMedia) sessionFactory.getCurrentSession()
//					.get("com.jxust.svsh.dao.TwitterMedia", id);
//			if (instance == null) {
//				log.debug("get successful, no instance found");
//			} else {
//				log.debug("get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

	public List<TwitterMedia> findByExample(TwitterMedia instance) {
		log.debug("finding TwitterMedia instance by example");
		try {
			List<TwitterMedia> results = (List<TwitterMedia>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.TwitterMedia").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
