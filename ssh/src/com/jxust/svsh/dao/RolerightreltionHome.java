package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.Rolerightreltion;

/**
 * Home object for domain model class Rolerightreltion.
 * @see com.jxust.svsh.dao.Rolerightreltion
 * @author Hibernate Tools
 */
public class RolerightreltionHome {

	private static final Log log = LogFactory.getLog(RolerightreltionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Rolerightreltion transientInstance) {
		log.debug("persisting Rolerightreltion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rolerightreltion instance) {
		log.debug("attaching dirty Rolerightreltion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rolerightreltion instance) {
		log.debug("attaching clean Rolerightreltion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rolerightreltion persistentInstance) {
		log.debug("deleting Rolerightreltion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rolerightreltion merge(Rolerightreltion detachedInstance) {
		log.debug("merging Rolerightreltion instance");
		try {
			Rolerightreltion result = (Rolerightreltion) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rolerightreltion findById(int id) {
		log.debug("getting Rolerightreltion instance with id: " + id);
		try {
			Rolerightreltion instance = (Rolerightreltion) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.Rolerightreltion", id);
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

	public List<Rolerightreltion> findByExample(Rolerightreltion instance) {
		log.debug("finding Rolerightreltion instance by example");
		try {
			List<Rolerightreltion> results = (List<Rolerightreltion>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.Rolerightreltion").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
