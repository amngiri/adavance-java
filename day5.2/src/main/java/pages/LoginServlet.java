package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	@Override
	public void init() throws ServletException {

		// user dao instance
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// To inform WC that init() has failed : re throw the exception , wrapped in
			// ServletException
			// ServletException(String errMesg,Throwable e)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// invoke dao's cleanup
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// how to tell WC that destroy method failed ?
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type : resp header
		response.setContentType("text/html");
		// get PW to send response
		try (PrintWriter pw = response.getWriter()) {
			// read req params : email n pwd
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// LoginServlet invokes dao's CRUD method
			User user = userDao.validateUser(email, pwd);
			// chk null => invalid login --send retry link
			if (user == null)
				pw.print("<h5> Invalid Login Please <a href='login.html'>Retry</a></h5>");
			// not null => successful login : send validated user details to clnt
			else {
				// In case of successful login , navigate the clnt to TopicsServlet in the SAME
				// request
				// Server Pull : Request Dispatching(chaining)
				// Steps 1. Create RD (javax.servlet.RequestDispatcher) object , to wrap the
				// next page : TopicsServlet
				//Method of ServletRequest : public RD getRequestDispatcher(String path)
				RequestDispatcher rd=request.getRequestDispatcher("topics");
				//2. Forward the clnt to the next page in the SAME request
				//Method of RD : public void forward(ServletRequest rq,ServletResponse rs)
				rd.forward(request, response);
				System.out.println("control of exec came back to login....");
			}
		} catch (Exception e) {
			// re throw the exception to caller (WC)
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
