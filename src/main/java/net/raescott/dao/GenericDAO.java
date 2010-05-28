package net.raescott.dao;

import net.raescott.exception.GeneralException;
import java.io.Serializable;

/**
 * Generic interface to the CRUD operations common to all DAOs.
 *
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * Persistence <code>newInstance</code> object into the database.
	 * 
	 * @param newInstance
	 * @return
	 * @throws GeneralException
	 */
	T create(T newInstance) throws GeneralException;

	/**
	 * Retrieve an object that was previously persisted to the
     * database using the indicated <code>id</code> as primary key.
	 * 
	 * @param id
	 * @return
	 * @throws GeneralException
	 */
	T read(PK id) throws GeneralException;

	/**
	 * Save changes made to a persistent object.
	 * 
	 * @param transientObject
	 * @return
	 * @throws GeneralException
	 */
	T update(T transientObject) throws GeneralException;

	/**
	 * Remove an object from persistent storage in the database.
	 * 
	 * @param persistentObject
	 * @throws GeneralException
	 */
	void delete(T persistentObject) throws GeneralException;
}
