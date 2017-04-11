package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.TwitterLove;

/**
 * Home object for domain model class TwitterLove.
 * @see com.jxust.svsh.dao.TwitterLove
 * @author Hibernate Tools
 */
public class TwitterLoveHome {

	private static final Log log = LogFactory.getLog(TwitterLoveHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TwitterLove transientInstance) {
		log.debug("persisting TwitterLove instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TwitterLove instance) {
		log.debug("attaching dirty TwitterLove instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TwitterLove instance) {
		log.debug("attaching clean TwitterLove instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TwitterLove persistentInstance) {
		log.debug("deleting TwitterLove instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TwitterLove merge(TwitterLove detachedInstance) {
		log.debug("merging TwitterLove instance");
		try {
			TwitterLove result = (TwitterLove) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TwitterLove findById(int id) {
		log.debug("getting TwitterLove instance with id: " + id);
		try {
			TwitterLove instance = (TwitterLove) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.TwitterLove", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TwitterLove> findByExample(TwitterLove instance) {
		log.debug("finding TwitterLove instance by example");
		try {
			List<TwitterLove> results = (List<TwitterLove>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.TwitterLove").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
