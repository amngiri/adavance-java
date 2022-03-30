package pages;
import dao.TopicDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDaoImp;
import dao.UserDaoImpl;
import pojos.Topic;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicDaoImp topicDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5> Login Successful , from topics page....</h5>");
			// 3 . how to retrieve user details from a cookie ?
			// API of HttpServletRequest : Cookie[] getCookies()
			Cookie[] cookies = request.getCookies();
			// null chking
//			if (cookies != null) {
//				for (Cookie c : cookies)
//					if (c.getName().equals("user_details")) {
//						pw.print("<h5> Validated User Details  retrieved from a cookie : " + c.getValue() + "</h5>");
//						break;
//					}
//			} else
//				pw.print("<h5> Session Tracking Failed : No Cookies!!!!!!!</h5>");
			List<Topic> list=topicDao.getAllTopics();
			pw.write("<form method='get' action='/tutorial'><table>");
		    for(Topic t:list)
		    {
		    	pw.write("<tr><td><input type='radio' name='topic' value="+t.getTopicId()+"/>"+t.getTopicName()+"</td></tr>");
		    			
		    }
		    pw.write("<tr><td><input type='submit' value='Submit'></td></tr>");
		    pw.write("</table></form>");
		} catch (Exception e) {
			throw new ServletException("err in do-post of "+getClass(), e);
		}
	}

	@Override
	public void destroy() {
		try {
             topicDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in do-post of "+getClass(), e);
		}
	}


	public void init() throws ServletException {

		// user dao instance
		try {
			topicDao = new TopicDaoImp();
		} catch (Exception e) {
			// To inform WC that init() has failed : re throw the exception , wrapped in
			// ServletException
			// ServletException(String errMesg,Throwable e)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}
}
