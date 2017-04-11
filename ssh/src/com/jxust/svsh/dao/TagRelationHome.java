package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.TagRelation;

/**
 * Home object for domain model class TagRelation.
 * @see com.jxust.svsh.dao.TagRelation
 * @author Hibernate Tools
 */
public class TagRelationHome {

	private static final Log log = LogFactory.getLog(TagRelationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TagRelation transientInstance) {
		log.debug("persisting TagRelation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TagRelation instance) {
		log.debug("attaching dirty TagRelation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TagRelation instance) {
		log.debug("attaching clean TagRelation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TagRelation persistentInstance) {
		log.debug("deleting TagRelation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TagRelation merge(TagRelation detachedInstance) {
		log.debug("merging TagRelation instance");
		try {
			TagRelation result = (TagRelation) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

//	public TagRelation findById(com.jxust.svsh.dao.TagRelationId id) {
//		log.debug("getting TagRelation instance with id: " + id);
//		try {
//			TagRelation instance = (TagRelation) sessionFactory.getCurrentSession()
//					.get("com.jxust.svsh.dao.TagRelation", id);
//			if (instance == null) {
//				log.debug("get successful, no instance found");
//			} else {
//				log.debug("get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}

	public List<TagRelation> findByExample(TagRelation instance) {
		log.debug("finding TagRelation instance by example");
		try {
			List<TagRelation> results = (List<TagRelation>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.TagRelation").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
