package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDaoImp;
import dao.UserDaoImpl;
import pojos.User;
import static utils.DBUtils.closeConnection;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
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
			closeConnection();
			System.out.println("in destroy");
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
		// set content type
		response.setContentType("text/html");
		// get PW to send response
		try (PrintWriter pw = response.getWriter()) {
			// read req params : email n pwd
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// LoginServlet invokes dao's CRUD method
			User user = userDao.validateUser(email, pwd);
			// chk null => invalid login --send retry link
			if(user == null)
				pw.print("<h5> Invalid Login Please <a href='login.html'>Retry</a></h5>");
			// not null => successful login : send validated user details to clnt
			else {
				//=>login success
				//1. Create a cookie to store , validated user details
				//javax.servlet.http.Cookie(String name,String value)
				Cookie c1=new Cookie("user_details", user.toString());
				//2. send cookie from server --> clnt , in the resp header
				//Method of HttpServletResponse : public void addCookie(Cookie c)
				response.addCookie(c1);
				//automatically redirect the client to the topics page
				//API of HttpServletResponse
				//Method : public void sendRedirect(String redirectLocation) throws IOException
				response.sendRedirect("topics");
				//WC : sends temp redirect response
				//resp : SC 302 | header : location =topics,set-cookie : user_details : tostring | body : EMPTY
				//web browser : sends NEW request 
				//URL : http://host:port/day4.2/topics
				//HTTP method : GET 
				//request header : cookie : user_details : tostring
				//add a TopicsServlet : with /topics
			}
		} catch (Exception e) {
			//re throw the exception to caller (WC)
			throw new ServletException("err in do-post of "+getClass(), e);
		}
	}

}
