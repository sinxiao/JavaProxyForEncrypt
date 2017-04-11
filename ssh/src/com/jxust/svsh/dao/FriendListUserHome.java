package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.FriendListUser;

/**
 * Home object for domain model class FriendListUser.
 * @see com.jxust.svsh.dao.FriendListUser
 * @author Hibernate Tools
 */
public class FriendListUserHome {

	private static final Log log = LogFactory.getLog(FriendListUserHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FriendListUser transientInstance) {
		log.debug("persisting FriendListUser instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FriendListUser instance) {
		log.debug("attaching dirty FriendListUser instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FriendListUser instance) {
		log.debug("attaching clean FriendListUser instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FriendListUser persistentInstance) {
		log.debug("deleting FriendListUser instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FriendListUser merge(FriendListUser detachedInstance) {
		log.debug("merging FriendListUser instance");
		try {
			FriendListUser result = (FriendListUser) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FriendListUser findById(java.lang.Integer id) {
		log.debug("getting FriendListUser instance with id: " + id);
		try {
			FriendListUser instance = (FriendListUser) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.FriendListUser", id);
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

	public List<FriendListUser> findByExample(FriendListUser instance) {
		log.debug("finding FriendListUser instance by example");
		try {
			List<FriendListUser> results = (List<FriendListUser>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.FriendListUser").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
