package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.LongTwitter;

/**
 * Home object for domain model class LongTwitter.
 * @see com.jxust.svsh.dao.LongTwitter
 * @author Hibernate Tools
 */
public class LongTwitterHome {

	private static final Log log = LogFactory.getLog(LongTwitterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(LongTwitter transientInstance) {
		log.debug("persisting LongTwitter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LongTwitter instance) {
		log.debug("attaching dirty LongTwitter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LongTwitter instance) {
		log.debug("attaching clean LongTwitter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LongTwitter persistentInstance) {
		log.debug("deleting LongTwitter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LongTwitter merge(LongTwitter detachedInstance) {
		log.debug("merging LongTwitter instance");
		try {
			LongTwitter result = (LongTwitter) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LongTwitter findById(int id) {
		log.debug("getting LongTwitter instance with id: " + id);
		try {
			LongTwitter instance = (LongTwitter) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.LongTwitter", id);
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

	public List<LongTwitter> findByExample(LongTwitter instance) {
		log.debug("finding LongTwitter instance by example");
		try {
			List<LongTwitter> results = (List<LongTwitter>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.LongTwitter").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
