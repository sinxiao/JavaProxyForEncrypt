package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.NewsComment;

/**
 * Home object for domain model class NewsComment.
 * @see com.jxust.svsh.dao.NewsComment
 * @author Hibernate Tools
 */
public class NewsCommentHome {

	private static final Log log = LogFactory.getLog(NewsCommentHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(NewsComment transientInstance) {
		log.debug("persisting NewsComment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(NewsComment instance) {
		log.debug("attaching dirty NewsComment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewsComment instance) {
		log.debug("attaching clean NewsComment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NewsComment persistentInstance) {
		log.debug("deleting NewsComment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewsComment merge(NewsComment detachedInstance) {
		log.debug("merging NewsComment instance");
		try {
			NewsComment result = (NewsComment) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NewsComment findById(java.lang.Integer id) {
		log.debug("getting NewsComment instance with id: " + id);
		try {
			NewsComment instance = (NewsComment) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.NewsComment", id);
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

	public List<NewsComment> findByExample(NewsComment instance) {
		log.debug("finding NewsComment instance by example");
		try {
			List<NewsComment> results = (List<NewsComment>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.NewsComment").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
