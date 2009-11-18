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
		setSupportedMethods(new String[]{METHOD_GET, METHOD_POST});
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
		/* Or home-servlet.xml can configure the viewResolver to
		 * exposeContextBeansAsAttributes = true and then just use regular
		 * JSP Expression Language to access beans that way.
		 *
		 * When you add the object to the ModelAndView, you must also add
		 * org.springframework.web.context.ContextLoaderListener in the web.xml
		 * because these are made available and accessed from the application
		 * context.
		 */
		if (request.getParameter("leftPosition") != null) {
			customer.setLeftPosition(Integer.valueOf(request.getParameter("leftPosition")));
		}
		if (request.getParameter("topPosition") != null) {
			customer.setTopPosition(Integer.valueOf(request.getParameter("topPosition")));
		}
		mav.addObject("customer", customer);
		return mav;
	}
}
