package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5> Login Successful , from topics page....</h5>");
			// Steps 1. Get HttpSession object from WC (existing object , provided cookies
			// are enabled!)
			HttpSession hs = request.getSession();
			System.out.println("from topics page sesison is new " + hs.isNew());// false
			System.out.println("session id " + hs.getId());// will display SAME JSESSIONID for the SAME client
			// 2. Retrieve user details from the session scope
			// HttpSession API : public Object getAttribute(String attributeName)
			User retrievedUser = (User) hs.getAttribute("clnt_details");
			if (retrievedUser != null)
				pw.print("<h5> Retrieved User details from HttpSession " + retrievedUser + "</h5>");
			else
				pw.print("<h5> Session Tracking based upon HttpSession Failed : No Cookies!!!!!!!</h5>");
			
			

		}
	}

}
