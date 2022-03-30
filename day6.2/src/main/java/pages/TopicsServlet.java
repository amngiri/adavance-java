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
		System.out.println("in do-get of " + getClass());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h5> Login Successful , from topics page....</h5>");
		// RD : server pull : retrieve user details from curnt request scope
		User retrievedUser = (User) request.getAttribute("user_details");
		if (retrievedUser != null)
			pw.print("<h5> Retrieved User details from Request " + retrievedUser + "</h5>");
		else
			pw.print("<h5> Request Dispatching failed....</h5>");

	}
	// override doPost

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-post of " + getClass());
		doGet(req, resp);
	}

}
