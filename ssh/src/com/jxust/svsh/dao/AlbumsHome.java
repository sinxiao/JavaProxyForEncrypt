package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.annotation.Resource;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.jxust.svsh.entity.Albums;

/**
 * Home object for domain model class Albums.
 * @see com.jxust.svsh.dao.Albums
 * @author Hibernate Tools
 */
@Repository
public class AlbumsHome {

	private static final Log log = LogFactory.getLog(AlbumsHome.class);

	@Resource
	private SessionFactory sessionFactory = null;

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Albums transientInstance) {
		log.debug("persisting Albums instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Albums instance) {
		log.debug("attaching dirty Albums instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Albums instance) {
		log.debug("attaching clean Albums instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Albums persistentInstance) {
		log.debug("deleting Albums instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Albums merge(Albums detachedInstance) {
		log.debug("merging Albums instance");
		try {
			Albums result = (Albums) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Albums findById(java.lang.Integer id) {
		log.debug("getting Albums instance with id: " + id);
		try {
			Albums instance = (Albums) sessionFactory.getCurrentSession().get("com.jxust.svsh.dao.Albums", id);
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

	public List<Albums> findByExample(Albums instance) {
		log.debug("finding Albums instance by example");
		try {
			List<Albums> results = (List<Albums>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.Albums").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
