package net.raescott.dao;

import net.raescott.javabeans.Customer;
import javax.persistence.Entity;

/**
 *
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
@Entity
public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {

	public CustomerDAOImpl() {
		super(Customer.class);
	}
}
