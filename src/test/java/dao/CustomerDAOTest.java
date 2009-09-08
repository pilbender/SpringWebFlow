package dao;

import exception.GeneralException;
import javabeans.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

/**
 * Test the <code>customerDAO</code> interface with a
 * <code>customerDAOMock</code>.
 *
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
public class CustomerDAOTest {
	// Spring Bean Container Parts
	ApplicationContext context;
	BeanFactory factory;
	CustomerDAO customerDAO;

    public CustomerDAOTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() {
		// Let's initialize the Bean Container with test mock objects.
		context = new ClassPathXmlApplicationContext(new String[] { "testApplicationContext-DAO.xml" });
		factory = context;
		customerDAO = (CustomerDAO) factory.getBean("customerDAO");
    }

    @After
    public void tearDown() {
    }

	/**
	 * Test of create method, of class CustomerDAO.
	 */
	@Test
	@Ignore
	public void testCreate() {
		System.out.println("create");
	}

	/**
	 * Test of read method, of class CustomerDAO.
	 */
	@Test
	public void testRead() throws GeneralException {
		System.out.println("getId");
		Customer customer = customerDAO.read(1);
		assertEquals(1, customer.getId().intValue());
		assertEquals("John", customer.getFirstName());
		assertEquals("Doe", customer.getLastName());
	}

	/**
	 * Test of update method, of class CustomerDAO.
	 */
	@Test
	@Ignore
	public void testUpdate() {
		System.out.println("hashCode");
		CustomerDAO instance = new CustomerDAOImpl();
		int expResult = 0;
		int result = instance.hashCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class CustomerDAO.
	 */
	@Test
	@Ignore
	public void testDelete() {
		System.out.println("setId");
		Long id = null;
		CustomerDAO instance = new CustomerDAOImpl();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}