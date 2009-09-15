package controller;

import javabeans.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * This is a basic Spring Controller.
 * @author Richard Scott Smith
 */
public class HomeController extends AbstractController {
	private Customer customer;

	public HomeController() {
		// We are only supporting http get right now.
		setSupportedMethods(new String[]{METHOD_GET});
		// Tell Browsers to cache this for 5 minutes.
		setCacheSeconds(300);
	}

	/**
	 * The existence of this setter means it will be dependency injected.
	 * We would like to dependency inject the <code>Customer</code>
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("customers", customer);
		return mav;
	}
}