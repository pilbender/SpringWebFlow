package net.raescott.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import net.raescott.exception.GeneralException;

/**
 * Provides a generic, type-safe implementation of the basic CRUD operations
 * available to all DAOs.
 *
 * @author Richard Scott Smith
 *
 * @param <T>
 * @param <PK>
 */
// @Transactional
public class GenericDAOImpl<T, PK extends Serializable> implements
		GenericDAO<T, PK> {

	/*
	 * Commented out because sequence generation is not working with dependency
	 * injection of the Entity Manager.
	 */
	// @PersistenceContext(unitName="IntegrationServicesPU")
	@Autowired
	protected EntityManagerFactory entityManagerFactory;

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.maximus.stt.comp.schoolmax.common.dao.GenericDAO#create
	 * (java.lang.Object)
	 */
	public T create(T newInstance) throws GeneralException {
		EntityManager em = null;
		try {
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(newInstance);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (null != em && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new GeneralException(e);
		} finally {
			if (null != em) {
				em.close();
			}
		}
		return newInstance;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.maximus.stt.comp.schoolmax.common.dao.GenericDAO#read(java
	 * .io.Serializable)
	 */
	public T read(PK id) throws GeneralException {
		T managedInstance = null;
		EntityManager em = null;
		try {
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			managedInstance = em.find(type, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (null != em && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new GeneralException(e);
		} finally {
			if (null != em) {
				em.close();
			}
		}
		return managedInstance;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.maximus.stt.comp.schoolmax.common.dao.GenericDAO#update
	 * (java.lang.Object)
	 */
	public T update(T transientObject) throws GeneralException {
		EntityManager em = null;
		try {
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			transientObject = em.merge(transientObject);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (null != em && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new GeneralException(e);
		} finally {
			if (null != em) {
				em.close();
			}
		}
		return transientObject;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.maximus.stt.comp.schoolmax.common.dao.GenericDAO#delete
	 * (java.lang.Object)
	 */
	public void delete(T persistentObject) throws GeneralException {
		EntityManager em = null;
		try {
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			persistentObject = em.merge(persistentObject);
			em.remove(persistentObject);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (null != em && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new GeneralException(e);
		} finally {
			if (null != em) {
				em.close();
			}
		}
	}
}
