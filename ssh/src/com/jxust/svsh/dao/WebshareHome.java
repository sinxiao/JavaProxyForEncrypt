package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.Webshare;

/**
 * Home object for domain model class Webshare.
 * @see com.jxust.svsh.dao.Webshare
 * @author Hibernate Tools
 */
public class WebshareHome {

	private static final Log log = LogFactory.getLog(WebshareHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Webshare transientInstance) {
		log.debug("persisting Webshare instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Webshare instance) {
		log.debug("attaching dirty Webshare instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Webshare instance) {
		log.debug("attaching clean Webshare instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Webshare persistentInstance) {
		log.debug("deleting Webshare instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Webshare merge(Webshare detachedInstance) {
		log.debug("merging Webshare instance");
		try {
			Webshare result = (Webshare) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Webshare findById(java.lang.Integer id) {
		log.debug("getting Webshare instance with id: " + id);
		try {
			Webshare instance = (Webshare) sessionFactory.getCurrentSession().get("com.jxust.svsh.dao.Webshare", id);
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

	public List<Webshare> findByExample(Webshare instance) {
		log.debug("finding Webshare instance by example");
		try {
			List<Webshare> results = (List<Webshare>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.Webshare").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
