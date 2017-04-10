package bat.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (type.equals("Student"))
		{
			Student student = DBOperation.checkStudentPass(id, password);

			if (student != null)
			{
				CookieRes.setCookie(response, "student_id", student.getStudentId() + "");
				CookieRes.setCookie(response, "name", student.getName());
				CookieRes.setCookie(response, "type", "student");

				response.sendRedirect("student_index.jsp");
			} else
			{
				out.println("<html><div class='alert alert-danger alert-dismissable fade in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Login Failed! Please try again.</strong></div></html>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.include(request, response);
			}

		} else if (type.equals("Librarian"))
		{
			Librarian librarian = DBOperation.checkLibrarianPass(id, password);

			if (librarian != null)
			{
				CookieRes.setCookie(response, "user_id", librarian.getUserId() + "");
				CookieRes.setCookie(response, "name", librarian.getName());
				CookieRes.setCookie(response, "type", "librarian");

				response.sendRedirect("librarian_index.jsp");
			} else
			{
				out.println("<html><div class='alert alert-danger alert-dismissable fade in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Login Failed! Please try again.</strong></div></html>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.include(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
