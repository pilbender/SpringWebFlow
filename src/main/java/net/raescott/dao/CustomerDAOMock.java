package net.raescott.dao;

import net.raescott.dao.*;
import net.raescott.exception.GeneralException;
import net.raescott.javabeans.Customer;

/**
 * Mock Object to test the Customer Interface.
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
public class CustomerDAOMock implements CustomerDAO {
	private Customer customer;

	public Customer create(Customer newInstance) throws GeneralException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public Customer read(Integer id) throws GeneralException {
		// I'm a little bothered by this autoboxing behavior.
		if (customer.getId().intValue() == id.intValue()) {
			return customer;
		} else {
			return null;
		}
	}

	public Customer update(Customer transientObject) throws GeneralException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void delete(Customer persistentObject) throws GeneralException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * For Spring Dependency Injection.
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * For Spring Dependency Injection.
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
