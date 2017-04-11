package com.jxust.svsh.dao;
// Generated 2017-4-10 18:19:24 by Hibernate Tools 5.1.2.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.jxust.svsh.entity.EuserDetail;

/**
 * Home object for domain model class EuserDetail.
 * @see com.jxust.svsh.dao.EuserDetail
 * @author Hibernate Tools
 */
public class EuserDetailHome {

	private static final Log log = LogFactory.getLog(EuserDetailHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(EuserDetail transientInstance) {
		log.debug("persisting EuserDetail instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EuserDetail instance) {
		log.debug("attaching dirty EuserDetail instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EuserDetail instance) {
		log.debug("attaching clean EuserDetail instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EuserDetail persistentInstance) {
		log.debug("deleting EuserDetail instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EuserDetail merge(EuserDetail detachedInstance) {
		log.debug("merging EuserDetail instance");
		try {
			EuserDetail result = (EuserDetail) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EuserDetail findById(java.lang.Integer id) {
		log.debug("getting EuserDetail instance with id: " + id);
		try {
			EuserDetail instance = (EuserDetail) sessionFactory.getCurrentSession()
					.get("com.jxust.svsh.dao.EuserDetail", id);
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

	public List<EuserDetail> findByExample(EuserDetail instance) {
		log.debug("finding EuserDetail instance by example");
		try {
			List<EuserDetail> results = (List<EuserDetail>) sessionFactory.getCurrentSession()
					.createCriteria("com.jxust.svsh.dao.EuserDetail").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
