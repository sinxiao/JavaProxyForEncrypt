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

import com.jxust.svsh.entity.Euser;

/**
 * Home object for domain model class Euser.
 * @see com.jxust.svsh.dao.Euser
 * @author Hibernate Tools
 */
@Repository
public class EuserHome {

	private static final Log log = LogFactory.getLog(EuserHome.class);

	@Resource
	private SessionFactory sessionFactory ;

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Euser transientInstance) {
		log.debug("persisting Euser instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Euser instance) {
		log.debug("attaching dirty Euser instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Euser instance) {
		log.debug("attaching clean Euser instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Euser persistentInstance) {
		log.debug("deleting Euser instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Euser merge(Euser detachedInstance) {
		log.debug("merging Euser instance");
		try {
			Euser result = (Euser) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Euser findById(java.lang.Integer id) {
		log.debug("getting Euser instance with id: " + id);
		try {
			Euser instance = (Euser) sessionFactory.getCurrentSession().get("com.jxust.svsh.entity.Euser", id);
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

	public List<Euser> findByExample(Euser instance) {
		log.debug("finding Euser instance by example");
		try {
			List<Euser> results = (List<Euser>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.entity.Euser").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
