package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {
		System.out.println("in init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get");
		//1. set cont type
		response.setContentType("text/html");
		//2. pw : chat buffered o/p strm connected from servlet ----> clnt
		try(PrintWriter pw=response.getWriter())
		{
			//3 
			pw.print("<h5> Welcome 2 servlet again ...."+new Date()+"</h5>");
		}
	}

}
