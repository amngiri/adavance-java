package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import pojos.Topic;

/**
 * Servlet implementation class AdminTutorial
 */
@WebServlet("/add_tutorial")
public class ShowFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			TopicDaoImpl dao = (TopicDaoImpl) session.getAttribute("topic_dao");
			List<Topic>topics=dao.getAllTopics();
			pw.print("<form action='validateform' method='get' ><table border='2'><tr><td>Topic</td><td><select name='topic_id'>");
			for(Topic t:topics)
			{
				
				pw.print("<option value='" + t.getTopicName() + "'>" + t.getTopicName()+"</option>");
				
			}
			pw.print("</select></td></tr>");
			pw.print("<tr><td>Name</td><td><input type='text' id='name' name='nm'></td></tr>");
			pw.print("<tr><td>Author</td><td><input type='text' id='author' name='aut'></td></tr>");
			pw.print("<tr><td>Publish Date</td><td><input type='date' id='date' name='dt'></td></tr>");
			pw.print("<tr><td>Contents</td><td><textarea id='content' name='con' value='cont'></textarea></td></tr>");
			pw.print("<tr><td><input type='submit' value='submit'/></td></tr>");	
			pw.print("</table><form/>");
			
		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}
