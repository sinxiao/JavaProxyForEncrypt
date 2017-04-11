package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.MusicSrc;

/**
 * Home object for domain model class MusicSrc.
 * @see com.jxust.svsh.dao.MusicSrc
 * @author Hibernate Tools
 */
public class MusicSrcHome {

	private static final Log log = LogFactory.getLog(MusicSrcHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MusicSrc transientInstance) {
		log.debug("persisting MusicSrc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MusicSrc instance) {
		log.debug("attaching dirty MusicSrc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MusicSrc instance) {
		log.debug("attaching clean MusicSrc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MusicSrc persistentInstance) {
		log.debug("deleting MusicSrc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MusicSrc merge(MusicSrc detachedInstance) {
		log.debug("merging MusicSrc instance");
		try {
			MusicSrc result = (MusicSrc) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MusicSrc findById(java.lang.Integer id) {
		log.debug("getting MusicSrc instance with id: " + id);
		try {
			MusicSrc instance = (MusicSrc) sessionFactory.getCurrentSession().get("com.jxust.svsh.dao.MusicSrc", id);
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

	public List<MusicSrc> findByExample(MusicSrc instance) {
		log.debug("finding MusicSrc instance by example");
		try {
			List<MusicSrc> results = (List<MusicSrc>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.MusicSrc").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
