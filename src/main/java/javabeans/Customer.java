package javabeans;

import java.io.Serializable;
import javax.persistence.Id;

/**
 * Simple Javabean with only 2 fields.  Eventually, this will become an EJB3
 * Entity Bean.
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
public class Customer implements Serializable {
	@Id
	private Integer id;
	private String firstName;
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
