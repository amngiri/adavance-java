package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.TutorialDaoImpl;
import pojos.Tutorial;
/**
 * Servlet implementation class ProcessFormServlet
 */
@WebServlet("/validateform")
public class ProcessFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
	  try(PrintWriter pw=response.getWriter())
	  {
		  HttpSession session =request.getSession();
			TutorialDaoImpl dao=(TutorialDaoImpl) session.getAttribute("tutorial_dao");
		  String topic=request.getParameter("topic_id");
		  String name=request.getParameter("nm");
		  String author=request.getParameter("aut");
		  String content=request.getParameter("con");
		  LocalDate publishDate=LocalDate.parse(request.getParameter("dt"));
		  Date d=Date.valueOf(publishDate);
		  Period period = Period.between( publishDate,LocalDate.now());
		  if(content.length()<255 && period.getMonths()<6)
		  {
				int id=dao.getIdByName(topic);
				System.out.println(id);
			  pw.print(id);
				String status=dao.insertTutorial(new Tutorial(name,author, d,0,content,id));
				//String name, String author, String publishDate, int visit, String content, int id
				System.out.println(status);
		  }
		  else
		  {
			  System.out.println("You have the validation check");  
		  }  
	  }catch (Exception e) {
		  throw new ServletException("err in do-post of " + getClass(), e);
	}
	}

}
