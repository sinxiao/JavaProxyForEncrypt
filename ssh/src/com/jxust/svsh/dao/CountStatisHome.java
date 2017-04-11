package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.CountStatis;
import com.jxust.svsh.entity.CountStatisId;

/**
 * Home object for domain model class CountStatis.
 * @see com.jxust.svsh.dao.CountStatis
 * @author Hibernate Tools
 */
public class CountStatisHome {

	private static final Log log = LogFactory.getLog(CountStatisHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CountStatis transientInstance) {
		log.debug("persisting CountStatis instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CountStatis instance) {
		log.debug("attaching dirty CountStatis instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CountStatis instance) {
		log.debug("attaching clean CountStatis instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CountStatis persistentInstance) {
		log.debug("deleting CountStatis instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CountStatis merge(CountStatis detachedInstance) {
		log.debug("merging CountStatis instance");
		try {
			CountStatis result = (CountStatis) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CountStatis findById(CountStatisId id) {
		log.debug("getting CountStatis instance with id: " + id);
		try {
			CountStatis instance = (CountStatis) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.CountStatis", id);
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

	public List<CountStatis> findByExample(CountStatis instance) {
		log.debug("finding CountStatis instance by example");
		try {
			List<CountStatis> results = (List<CountStatis>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.CountStatis").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
